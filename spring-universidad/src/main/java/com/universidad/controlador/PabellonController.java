package com.universidad.controlador;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.Pabellon;
import com.universidad.servicios.contratos.PabellonDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pabellones")
public class PabellonController extends GenericController<Pabellon, PabellonDAO>{
    public PabellonController(PabellonDAO service) {
        super(service);
    }

    @GetMapping("/aulas-pizarron/{localidad}")
    public List<Pabellon> buscarPabellonesPorLocalidad(@PathVariable String localidad){
        List<Pabellon> pabellon = (List<Pabellon>) service.findByDireccionLocalidad(localidad);
        if(pabellon.isEmpty()){
            throw new BadRequestException(String.format("No se ha encontrado ningun pabellon con localidad%s",localidad));
        }
        return pabellon;
    }

    @GetMapping("/aulas-nombre/{nombre}")
    public List<Pabellon> findPabellonByNombreIgnoreCase(@PathVariable String nombre){
        List<Pabellon> pabellon = (List<Pabellon>) service.findByNombre(nombre);
        if(pabellon.isEmpty()){
            throw new BadRequestException(String.format("No se ha encontrado ningun pabellon con ese nombre %s",nombre));
        }
        return pabellon;
    }
}
