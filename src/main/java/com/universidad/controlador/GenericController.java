package com.universidad.controlador;

import com.universidad.exception.BadRequestException;
import com.universidad.servicios.contratos.GenericDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> obtenerTodos(){
        List<E> listatodo = (List<E>) service.findAll();
        if(listatodo.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestException(String.format("No se han encontrado %ss",nombreEntidad)));
        }
        return ResponseEntity.status(HttpStatus.OK).body(listatodo);
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<?> obtenerPorId(@PathVariable(value = "codigo",required = false)Integer id){
        Optional<E> oPersona = service.findById(id);
        if(!oPersona.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestException(String.format("El alumno con id %d no existe",id))) ;
        }
        return ResponseEntity.status(HttpStatus.OK).body(oPersona.get());
    }

    @PostMapping
    public ResponseEntity<?> altaAlumno(@RequestBody E e){
        return ResponseEntity.ok().body(service.save(e));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> borrarPorId(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
