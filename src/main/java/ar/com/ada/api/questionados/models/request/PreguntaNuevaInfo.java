package ar.com.ada.api.questionados.models.request;

import java.util.List;

import ar.com.ada.api.questionados.entities.Respuesta;

public class PreguntaNuevaInfo {

    public String enunciado;

    public List<Respuesta> opciones;

    public Integer categoriaId;

}
