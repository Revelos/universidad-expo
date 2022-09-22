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
    public Carrera actualizarCarrera(@PathVariable(value = "id") Integer id,@RequestBody Carrera carrera){
        Carrera carreraUpdate=null;
        Optional<Carrera> oCarrera = service.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe",id));
        }
        //carrera.setId(id);
        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        return service.save(carreraUpdate);
    }

    @GetMapping("/carrera-nombre")
    public List<Carrera> encontrarCarreraPorNombre(@RequestParam String nombre){
        List<Carrera> listatodo = (List<Carrera>) service.findCarreraByNombreContains(nombre);
        if(listatodo.isEmpty()){
            throw new BadRequestException(String.format("No se ha encontrado carrera llamada %s",nombre));
        }
        return listatodo;
    }

    @GetMapping("/carrera-nombre-ignorecase")
    public List<Carrera> encontrarCarreraPorNombreIgnoreCase(@RequestParam String nombre){
        List<Carrera> listatodo = (List<Carrera>) service.findCarreraByNombreContainsIgnoreCase(nombre);
        if(listatodo.isEmpty()){
            throw new BadRequestException(String.format("No se ha encontrado carrera llamada %s",nombre));
        }
        return listatodo;
    }

    @GetMapping("/carrera-anos/{anos}")
    public List<Carrera> encontrarCarreraPorAnos(@PathVariable Integer anos){
        List<Carrera> listatodo = (List<Carrera>) service.findCarreraByCantidadAniosAfter(anos);
        if(listatodo.isEmpty()){
            throw new BadRequestException(String.format("No se ha encontrado carrera llamada %s",anos));
        }
        return listatodo;
    }

    @GetMapping("/carrera-profesor")
    public List<Carrera> encontrarCarreraPorProfesor(@RequestParam String nombre,@RequestParam String apellido){
        List<Carrera> listatodo = (List<Carrera>) service.buscarCarrerasPorProfesorNombreYApellido(nombre,apellido);
        if(listatodo.isEmpty()){
            throw new BadRequestException(String.format("No se ha encontrado carrera con profesores llamados %s %s",nombre,apellido));
        }
        return listatodo;
    }

    /*@RequestMapping(value = "/{codigo}")
    public Carrera obtenerPorId(@PathVariable(value = "codigo",required = false)Integer id){
        Optional<Carrera> oCarrera = service.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe",id));
        }
        return oCarrera.get();
    }*/
    /*@RequestMapping(method = RequestMethod.POST)
    public Carrera ingresarCarrera(@RequestBody Carrera carrera){

        if(carrera.getCantidadAnios()<0){
            throw new BadRequestException("El campo no puede ser menor a 0");
        }
        if(carrera.getCantidadMaterias()<0){
            throw new BadRequestException("El campo no puede ser menor a cero");
        }

        return  service.save(carrera);

        /*try{
            Carrera c =carreraDAO.save(carrera);
            return ResponseEntity.status(HttpStatus.OK).body(c);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new String());
    }*/



    /*@DeleteMapping(value = "/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        service.deleteById(id);
    }*/
}
