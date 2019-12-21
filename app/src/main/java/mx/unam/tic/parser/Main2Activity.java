package mx.unam.tic.parser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main2Activity extends AppCompatActivity {

    private TextView tvResultado0;
    private TextView tvResultado1;
    private TextView tvResultado2;
    private TextView tvResultado3;
    private TextView tvResultado4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvResultado0 = findViewById(R.id.tvResultado0);
        tvResultado1 = findViewById(R.id.tvResultado1);
        tvResultado2 = findViewById(R.id.tvResultado2);
        tvResultado3 = findViewById(R.id.tvResultado3);
        tvResultado4 = findViewById(R.id.tvResultado4);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j0 = (String) b.get("rfcOferente");
            String j1 = (String) b.get("edadOferente");
            String j2 = (String) b.get("sexoOferente");
            String j3 = (String) b.get("clabeOferente");
            String j4 = (String) b.get("balanceOferente");
            tvResultado0.setText("RFC: "+ j0);
            tvResultado1.setText("EDAD: " +j1);
            tvResultado2.setText("SEXO: "+j2);
            tvResultado3.setText("CLABE: "+j3);
            tvResultado4.setText("BALANCE: "+j4);
        }
    }

}
