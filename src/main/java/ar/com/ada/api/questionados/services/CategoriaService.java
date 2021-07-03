package ar.com.ada.api.questionados.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.repos.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public List<Categoria> traer() {
        return repo.findAll();
    }

    public Categoria buscar(Integer categoriaId) {

        Categoria categoria = repo.findById(categoriaId.intValue());

        return categoria;

    }

    public boolean existe(String nombre){
        return repo.existsByNombre(nombre);

    }

}
