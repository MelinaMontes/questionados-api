package ar.com.ada.api.questionados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.models.request.CategoriaNuevaInfo;
import ar.com.ada.api.questionados.models.response.GenericResponse;
import ar.com.ada.api.questionados.services.CategoriaService;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traer() {
        return ResponseEntity.ok(service.traer());
    }

    // categoria por id
    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping(value = "/categorias") // crea una categoria nueva y si ya esta creada ejecuta un badRequest
    public ResponseEntity<?> crear(@RequestBody Categoria categoria) {

        GenericResponse response = new GenericResponse();

        if (service.crear(categoria)) {
            response.id = categoria.getCategoriaId();
            response.isOk = true;
            response.message = "Categoria creada";

            return ResponseEntity.ok(response);

        } else {
            response.isOk = false;
            response.message = "La categoria ya existe";

            return ResponseEntity.badRequest().body(response);

        }
        
   /* @PutMapping("/categorias/{id}") //actualiza una categoria existente
    public ResponseEntity<GenericResponse> actualizar (@PathVariable Integer id, @RequestBody CategoriaNuevaInfo categoriaNuevaInfo){
    
        service.actualizar(id, categoriaNuevaInfo);
        GenericResponse respuesta = new GenericResponse();

        respuesta.isOk = true;
        respuesta.message = "Categoria actualizada";

        return ResponseEntity.ok(respuesta);

    }

    }*/



}
}
