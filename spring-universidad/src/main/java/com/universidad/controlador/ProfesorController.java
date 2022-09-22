package com.universidad.controlador;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.Profesor;
import com.universidad.servicios.contratos.CarreraDAO;
import com.universidad.servicios.contratos.PersonaDAO;
import com.universidad.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/profesores")
public class ProfesorController extends PersonaController{

    private final CarreraDAO carreraDAO;

    public ProfesorController(@Qualifier("profesorDAOImpl") PersonaDAO service, CarreraDAO carreraDAO) {
        super(service);

        this.carreraDAO = carreraDAO;
    }

    @GetMapping("/carrera/{carrera}")
    public List<Persona> encontrarProfesorPorCarrera(@PathVariable String carrera){
        List<Persona> listatodo = (List<Persona>) ((ProfesorDAO)service).findProfesoresByCarrera(carrera);
        if(listatodo.isEmpty()){
            throw new BadRequestException(String.format("No se ha encontrado profesor con %ss",carrera));
        }
        return listatodo;
    }


    @PutMapping("/{idProfesor}/carrera/{idCarrera}")
    public Persona asignarCarreraProfesor(@PathVariable Integer idProfesor,@PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = service.findById(idProfesor);
        if(!oAlumno.isPresent()){
            throw  new BadRequestException(String.format("El alumno con id %d no existe",idProfesor));
        }
        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if(!oCarrera.isPresent()){
            throw  new BadRequestException(String.format("La carrera con id %d no existe",idCarrera));
        }
        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();
        Set<Carrera> carreras = new HashSet<>();
        carreras.add(carrera);
        ((Profesor)alumno).setCarreras(carreras);
        return service.save(alumno);
    }
}
