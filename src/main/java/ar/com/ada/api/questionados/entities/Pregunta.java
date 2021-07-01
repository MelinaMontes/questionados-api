package ar.com.ada.api.questionados.entities;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
//@Table(name = "pregunta")
public class Pregunta {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "pregunta_id")
    //private Integer preguntaId;



    public Pregunta(String enunciado) {
        this.enunciado = enunciado;
    }

    private Categoria categoria;

    private String enunciado; 

    private List<Respuesta> opciones = new ArrayList<>();

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Respuesta> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Respuesta> opciones) {
        this.opciones = opciones;
    }
    

}
