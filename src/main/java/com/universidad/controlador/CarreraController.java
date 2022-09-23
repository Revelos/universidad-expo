package com.universidad.controlador;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.repositorios.CarreraRepository;
import com.universidad.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera,CarreraDAO>{


    public CarreraController(CarreraDAO service) {
        super(service);
        super.nombreEntidad = "Carrera";
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable(value = "id") Integer id,@RequestBody Carrera carrera){
        Carrera carreraUpdate=null;
        Optional<Carrera> oCarrera = service.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe",id));
        }
        //carrera.setId(id);
        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        return ResponseEntity.ok().body(service.save(carreraUpdate));
    }

    @GetMapping("/carrera-nombre")
    public ResponseEntity<?> encontrarCarreraPorNombre(@RequestParam String nombre){
        List<Carrera> listatodo = (List<Carrera>) service.findCarreraByNombreContains(nombre);
        if(listatodo.isEmpty()){
            throw new BadRequestException(String.format("No se ha encontrado carrera llamada %s",nombre));
        }
        return ResponseEntity.ok().body(listatodo);
    }

    @GetMapping("/carrera-nombre-ignorecase")
    public ResponseEntity<?> encontrarCarreraPorNombreIgnoreCase(@RequestParam String nombre){
        List<Carrera> listatodo = (List<Carrera>) service.findCarreraByNombreContainsIgnoreCase(nombre);
        if(listatodo.isEmpty()){
            return ResponseEntity.ok().body(new BadRequestException(String.format("No se ha encontrado carrera llamada %s",nombre))) ;
        }
        return ResponseEntity.ok().body(listatodo);
    }

    @GetMapping("/carrera-anos/{anos}")
    public ResponseEntity<?> encontrarCarreraPorAnos(@PathVariable Integer anos){
        List<Carrera> listatodo = (List<Carrera>) service.findCarreraByCantidadAniosAfter(anos);
        if(listatodo.isEmpty()){
            return ResponseEntity.badRequest().body(new BadRequestException(String.format("No se ha encontrado carrera llamada %s",anos))) ;
        }
        return ResponseEntity.ok().body(listatodo);
    }

    @GetMapping("/carrera-profesor")
    public ResponseEntity<?> encontrarCarreraPorProfesor(@RequestParam String nombre,@RequestParam String apellido){
        List<Carrera> listatodo = (List<Carrera>) service.buscarCarrerasPorProfesorNombreYApellido(nombre,apellido);
        if(listatodo.isEmpty()){
            return ResponseEntity.badRequest().body(new BadRequestException(String.format("No se ha encontrado carrera con profesores llamados %s %s",nombre,apellido))) ;
        }
        return ResponseEntity.ok().body(listatodo) ;
    }

}
