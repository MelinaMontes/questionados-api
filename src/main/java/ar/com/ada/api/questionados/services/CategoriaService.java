package ar.com.ada.api.questionados.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.models.request.CategoriaNuevaInfo;
import ar.com.ada.api.questionados.repos.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public List<Categoria> traer() { // trae todas las categorias
        return repo.findAll();
    }

    public Categoria buscar(Integer categoriaId) { // busca una por id

        Categoria categoria = repo.findById(categoriaId.intValue());

        return categoria;

    }

    public boolean crear(Categoria categoria) { 
        if (existe(categoria.getNombre()))
            return false;

        repo.save(categoria);

        return true;
    }

    public boolean existe(String nombre) { // controla si ya existe la categoria que queremos crear
        return repo.existsByNombre(nombre);

    }


    public void actualizar(Integer Id, CategoriaNuevaInfo categoriaNuevaInfo){

        Categoria categoria = this.buscar(Id);
        categoria.setNombre(categoriaNuevaInfo.otroNombre);
        categoria.setDescripcion(categoriaNuevaInfo.otraDescripcion);
        repo.save(categoria);

      
    }
}
