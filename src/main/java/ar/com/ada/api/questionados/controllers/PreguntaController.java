package ar.com.ada.api.questionados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.models.request.PreguntaNuevaInfo;
import ar.com.ada.api.questionados.models.response.GenericResponse;
import ar.com.ada.api.questionados.services.PreguntaService;

@RestController
public class PreguntaController {

    @Autowired
    private PreguntaService service;

    @GetMapping("/preguntas")
    public ResponseEntity<List<Pregunta>> traer() {
        return ResponseEntity.ok(service.traer());
    }

    @GetMapping("/preguntas/{id}")
    public ResponseEntity<Pregunta> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/preguntas")
    public ResponseEntity<?> crear(@RequestBody PreguntaNuevaInfo preguntaNueva) {

        GenericResponse respuesta = new GenericResponse();
        Pregunta pregunta = service.crear(preguntaNueva.enunciado, preguntaNueva.categoriaId, preguntaNueva.opciones);
        respuesta.isOk = true;
        respuesta.id = pregunta.getPreguntaId();
        respuesta.message = "Pregunta creada.";

        return ResponseEntity.ok(preguntaNueva);

    }
}
