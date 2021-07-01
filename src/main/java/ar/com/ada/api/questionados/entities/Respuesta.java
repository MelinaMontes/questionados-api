package ar.com.ada.api.questionados.entities;

public class Respuesta {
    
    private String texto;
    private boolean esCorrecta;

    public Respuesta(String texto, boolean esCorrecta) {
        this.texto = texto;
        this.esCorrecta = esCorrecta;
    }

    public Respuesta(String texto) {
        this.texto = texto;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public boolean isEsCorrecta() {
        return esCorrecta;
    }
    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }
    
}
