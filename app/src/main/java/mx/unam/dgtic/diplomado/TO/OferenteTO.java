package mx.unam.dgtic.diplomado.TO;

public class OferenteTO {

    private String rfcOferente;
    private String edadOferente;
    private String sexoOferente;
    private String clabeOferente;
    private String balanceOferente;

    public OferenteTO(){

    }

    public OferenteTO(String rfcOferente, String edadOferente, String sexoOferente, String clabeOferente, String balanceOferente) {
        this.rfcOferente = rfcOferente;
        this.edadOferente = edadOferente;
        this.sexoOferente = sexoOferente;
        this.clabeOferente = clabeOferente;
        this.balanceOferente = balanceOferente;
    }

    public String getRfcOferente() {
        return rfcOferente;
    }

    public void setRfcOferente(String rfcOferente) {
        this.rfcOferente = rfcOferente;
    }

    public String getEdadOferente() {
        return edadOferente;
    }

    public void setEdadOferente(String edadOferente) {
        this.edadOferente = edadOferente;
    }

    public String getSexoOferente() {
        return sexoOferente;
    }

    public void setSexoOferente(String sexoOferente) {
        this.sexoOferente = sexoOferente;
    }

    public String getClabeOferente() {
        return clabeOferente;
    }

    public void setClabeOferente(String clabeOferente) {
        this.clabeOferente = clabeOferente;
    }

    public String getBalanceOferente() {
        return balanceOferente;
    }

    public void setBalanceOferente(String balanceOferente) {
        this.balanceOferente = balanceOferente;
    }

    @Override
    public String toString() {
        return "OferenteTO{" +
                "rfcOferente='" + rfcOferente + '\'' +
                ", edadOferente='" + edadOferente + '\'' +
                ", sexoOferente='" + sexoOferente + '\'' +
                ", clabeOferente='" + clabeOferente + '\'' +
                ", balanceOferente='" + balanceOferente + '\'' +
                '}';
    }
}
