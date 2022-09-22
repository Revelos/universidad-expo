package com.universidad.controlador;

import com.universidad.exception.BadRequestException;
import com.universidad.servicios.contratos.GenericDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class GenericController<E,S extends GenericDAO<E>>{

    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public List<E> obtenerTodos(){
        List<E> listatodo = (List<E>) service.findAll();
        if(listatodo.isEmpty()){
            throw new BadRequestException(String.format("No se han encontrado %ss",nombreEntidad));
        }
        return listatodo;
    }

    @GetMapping(value = "/{codigo}")
    public E obtenerPorId(@PathVariable(value = "codigo",required = false)Integer id){
        Optional<E> oPersona = service.findById(id);
        if(!oPersona.isPresent()){
            throw new BadRequestException(String.format("El alumno con id %d no existe",id));
        }
        return oPersona.get();
    }

    @PostMapping
    public E altaAlumno(@RequestBody E e){
        return service.save(e);
    }

    @DeleteMapping(value = "/{id}")
    public void borrarPorId(@PathVariable Integer id){
        service.deleteById(id);
    }

}
