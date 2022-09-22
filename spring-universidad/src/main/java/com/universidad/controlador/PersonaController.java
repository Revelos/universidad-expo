package com.universidad.controlador;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Persona;
import com.universidad.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaDAO> {

    public PersonaController(PersonaDAO service) {
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public Persona buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre,apellido);
        if(!oPersona.isPresent()){
            throw new BadRequestException(String.format("No existe persona llamada %ss %ss",nombre,apellido));
        }
        return oPersona.get();
    }

    @GetMapping("/dni/{dni}")
    public Persona buscarPersonaDni(@PathVariable String dni){
        Optional<Persona> oPersona = service.buscarPorDni(dni);
        if(!oPersona.isPresent()){
            throw new BadRequestException(String.format("No existe persona con DNI %ss ",dni));
        }
        return oPersona.get();
    }

    @GetMapping("/apellido")
    public Persona buscarPersonaPorApellido(@RequestParam String apellido){
        Optional<Persona> oPersona = service.buscarPersonaPorApellido(apellido);
        if(!oPersona.isPresent()){
            throw new BadRequestException(String.format("No existe persona llamada %ss",apellido));
        }
        return oPersona.get();
    }

}
