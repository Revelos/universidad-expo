package com.universidad.controlador;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.modelo.entidades.Persona;
import com.universidad.servicios.contratos.AlumnoDAO;
import com.universidad.servicios.contratos.CarreraDAO;
import com.universidad.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/alumno")
public class AlumnoController extends PersonaController{

    private final CarreraDAO carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl")PersonaDAO alumnoDAO, CarreraDAO carreraDAO) {
        super(alumnoDAO);
        this.carreraDAO = carreraDAO;
        super.nombreEntidad="Alumno";
    }
   /* @GetMapping
    public List<Persona> obtenerTodos(){
        List<Persona> carreras = (List<Persona>) ((AlumnoDAO)alumnoDAO).findAll();
        if(carreras.isEmpty()){
            throw new BadRequestException("No existen alumnos");
        }
        return carreras;
    }

    @GetMapping(value = "/{codigo}")
    public Persona obtenerPorId(@PathVariable(value = "codigo",required = false)Integer id){
        Optional<Persona> oPersona = alumnoDAO.findById(id);
        if(!oPersona.isPresent()){
            throw new BadRequestException(String.format("El alumno con id %d no existe",id));
        }
        return oPersona.get();
    }

    @PostMapping
    public Persona altaAlumno(@RequestBody Persona alumno){
        return alumnoDAO.save(alumno);
    }

    @PutMapping("/{id}")
    public Persona actualizarCarrera(@PathVariable(value = "id") Integer id,@RequestBody Persona alumno){
        Persona alumnoUpdate=null;
        Optional<Persona> oAlumno = alumnoDAO.findById(id);
        if(!oAlumno.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe",id));
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return alumnoDAO.save(alumnoUpdate);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        alumnoDAO.deleteById(id);
    }*/



    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona asignarCarreraAlumno(@PathVariable Integer idAlumno,@PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = service.findById(idAlumno);
        if(!oAlumno.isPresent()){
            throw  new BadRequestException(String.format("El alumno con id %d no existe",idAlumno));
        }
        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if(!oCarrera.isPresent()){
            throw  new BadRequestException(String.format("La carrera con id %d no existe",idCarrera));
        }
        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();
        ((Alumno)alumno).setCarrera(carrera);
        return service.save(alumno);
    }
}
