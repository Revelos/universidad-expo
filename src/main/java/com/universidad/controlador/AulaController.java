package com.universidad.controlador;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.enumeradores.Pizarron;
import com.universidad.servicios.contratos.AulaDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aulas")
public class AulaController extends GenericController<Aula, AulaDAO> {

    public AulaController(AulaDAO service) {
        super(service);
    }

    @GetMapping("/aulas-pizarron")
    public ResponseEntity<?> listarAulasPorTipoPizarron(@RequestParam String pizarron){
        List<Aula> aulas=null;
        try{
            aulas = (List<Aula>) service.findAulaByPizarron(Pizarron.valueOf(pizarron));
            if(aulas.isEmpty()){
                return ResponseEntity.badRequest().body(new BadRequestException(String.format("No se ha encontrado aulas con este tipo  de pizarra %s",pizarron)));
            }
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(new BadRequestException(String.format("No existe el tipo de pizarron %s",pizarron))) ;
        }

        return ResponseEntity.ok().body(aulas);
    }

    @GetMapping("/aulas-pizarron/{pabellon_nombre}")
    public ResponseEntity<?> listarAulasPorPabellonNombre(@PathVariable String pabellon_nombre){
        List<Aula> aulas=null;

            aulas = (List<Aula>) service.findAulaByPabellonNombre(pabellon_nombre);
            if(aulas.isEmpty()){
                return ResponseEntity.badRequest().body(new BadRequestException(String.format("No se ha encontrado ningun aulas con este tipo de pabellon%s",pabellon_nombre))) ;
            }


        return ResponseEntity.ok().body(aulas);
    }

    @GetMapping("/aulas-pizarron/")
    public ResponseEntity<?> listarAulasPorNroAula(@RequestParam Integer nro_aula){

        Optional<Aula> aulas =  service.findByNroAula(nro_aula);
        if(aulas.isEmpty()){
            return ResponseEntity.badRequest().body(new BadRequestException(String.format("No se ha encontrado ningun aula con numero%s",nro_aula))) ;
        }
        return ResponseEntity.ok().body(aulas.get());
    }


}
