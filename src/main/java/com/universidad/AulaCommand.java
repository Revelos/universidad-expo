package com.universidad;

import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.enumeradores.Pizarron;
import com.universidad.servicios.contratos.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class AulaCommand implements CommandLineRunner {

    @Autowired
    private AulaDAO servicio;
    @Override
    public void run(String... args) throws Exception {
        /*Aula aula = new Aula(null,5,"24x12",13, Pizarron.PIZARRA_BLANCA);
        System.out.println(servicio.save(aula));*/

        /*Iterable<Aula> aulas = servicio.findAll();
        aulas.forEach(System.out::println);*/

        /*Iterable<Aula> aulasFiltro= servicio.findAulaByPizarron(Pizarron.PIZARRA_TIZA);
        aulasFiltro.forEach(System.out::println);*/

        /*Optional<Aula> aulasNroAula= servicio.findByNroAula(6);
        aulasNroAula.map(aula -> System.out.printf(aula.toString()));*/

         Iterable<Aula> aulasFiltro= servicio.findAulaByPabellonNombre("Pabellon 5");
        aulasFiltro.forEach(System.out::println);

    }
}
