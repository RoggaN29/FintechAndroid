package mx.unam.tic.parser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import mx.unam.tic.parser.TO.OferenteTO;

public class MainActivity extends AppCompatActivity {
    private ListView lista;

    private XmlPullParserFactory xmlFactoryObject;
    private XmlPullParser miParser;
    private List<String> rfcList;
    private List<OferenteTO> oferentes;

    String textValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.list);

        rfcList = new ArrayList<String>();
        oferentes = new ArrayList<OferenteTO>();
        try{
            InputStream is = getAssets().open("archivo1.xml");

            xmlFactoryObject = XmlPullParserFactory.newInstance();
            miParser = xmlFactoryObject.newPullParser();

            miParser.setInput(is, null);

            boolean encontrado = false;
            int position = -1;

            int evento = miParser.getEventType();

            while(evento!= XmlPullParser.END_DOCUMENT){
                String nombre = miParser.getName();
                switch(evento){
                    case XmlPullParser.START_TAG:
                        if(nombre.equals("rfcOferente")){
                            position = 0;
                            encontrado = true;
                        }else if(nombre.equals("edadOferente")) {
                            position = 1;
                            encontrado = true;
                        }else if(nombre.equals("sexoOferente")){
                            position = 2;
                            encontrado = true;
                        }else if(nombre.equals("clabeOferente")){
                            position = 3;
                            encontrado = true;
                        }else if(nombre.equals("balanceOferente")){
                            position = 4;
                            encontrado = true;
                        }
                        break;

                    case XmlPullParser.TEXT:
                        if(encontrado){
                            //System.out.println("POSITION ======>" +position);
                            textValue = miParser.getText();
                            //System.out.println("VALOR ======>" +textValue);
                            if(position == 0){
                                oferentes.add(new OferenteTO());
                                oferentes.get(oferentes.size()-1).setRfcOferente(textValue);
                                rfcList.add(textValue);
                            }else if(position == 1){
                                oferentes.get(oferentes.size()-1).setEdadOferente(textValue);
                            }else if(position == 2){
                                oferentes.get(oferentes.size()-1).setSexoOferente(textValue);
                            }else if(position == 3){
                                oferentes.get(oferentes.size()-1).setClabeOferente(textValue);
                            }else if(position == 4){
                                oferentes.get(oferentes.size()-1).setBalanceOferente(textValue);
                            }
                            encontrado = false;
                            position = -1;
                        }
                        break;

                    case XmlPullParser.END_TAG:

                        break;
                }
                evento = miParser.next();
            }


        }catch(Exception e){

        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, rfcList);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                //String value=oferentes.get(position).getBalanceOferente();
                //Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                OferenteTO ofSelected = oferentes.get(position);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("rfcOferente",ofSelected.getRfcOferente());
                intent.putExtra("edadOferente",ofSelected.getEdadOferente());
                intent.putExtra("sexoOferente",ofSelected.getSexoOferente());
                intent.putExtra("clabeOferente",ofSelected.getClabeOferente());
                intent.putExtra("balanceOferente",ofSelected.getBalanceOferente());
                startActivity(intent);

            }
        });

    }
}
