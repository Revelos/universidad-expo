package com.universidad.controlador;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Empleado;
import com.universidad.modelo.entidades.Pabellon;
import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.enumeradores.TipoEmplado;
import com.universidad.servicios.contratos.EmpleadoDAO;
import com.universidad.servicios.contratos.PabellonDAO;
import com.universidad.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController extends PersonaController{

    private final PabellonDAO pabellonDAO;

    public EmpleadoController(@Qualifier("empleadoDAOImpl") PersonaDAO service, PabellonDAO pabellonDAO) {
        super(service);
        this.pabellonDAO = pabellonDAO;
    }

    @GetMapping("/tipo")
    public List<Persona> encontrarEmpleadoPorTipo(@RequestParam String tipoEmpleado){
        List<Persona> listatodo=null;
        try{
        listatodo = (List<Persona>) ((EmpleadoDAO)service).findEmpleadoByTipoEmpleado(TipoEmplado.valueOf(tipoEmpleado));
        if(listatodo.isEmpty()){
            throw new BadRequestException(String.format("No se ha encontrado ningun empleado con este tipo %s",tipoEmpleado));
        }
        }catch (IllegalArgumentException e){
            throw new BadRequestException(String.format("Tipo de empleado %s incorrecto",tipoEmpleado));
        }
        return listatodo;
    }

    @PutMapping("/{idEmpleado}/carrera/{idPabellon}")
    public Persona asignarEmpleadosPabellon(@PathVariable Integer idEmpleado, @PathVariable Integer idPabellon){
        Optional<Persona> oAlumno = service.findById(idEmpleado);
        if(!oAlumno.isPresent()){
            throw  new BadRequestException(String.format("El empleado con id %d no existe",idEmpleado));
        }
        Optional<Pabellon> oPabellon = pabellonDAO.findById(idPabellon);
        if(!oPabellon.isPresent()){
            throw  new BadRequestException(String.format("El pabellon con id %d no existe",idPabellon));
        }
        Persona empleado = oAlumno.get();
        Pabellon pabellon = oPabellon.get();
        ((Empleado)empleado).setPabellon(pabellon);
        return service.save(empleado);
    }

}
