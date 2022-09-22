package com.universidad;

import com.universidad.modelo.entidades.Carrera;
import com.universidad.modelo.entidades.Direccion;
import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.Profesor;
import com.universidad.repositorios.ProfesorRepository;
import com.universidad.servicios.contratos.CarreraDAO;
import com.universidad.servicios.contratos.PersonaDAO;
import com.universidad.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.SecondaryTable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class ProfesorCommand implements CommandLineRunner {
    @Autowired
    @Qualifier("profesorDAOImpl")
    private PersonaDAO servicio;

    @Autowired
    private CarreraDAO servicioCarrera;

    @Override
    public void run(String... args) throws Exception {
       /* Direccion direccion = new Direccion("calle pte","23","123-8","San Salvador","6","3");

        Persona persona = new Profesor(null,"Henry","Nuñez","1234569-9", direccion,new BigDecimal(1000.56));


        Persona p = servicio.save(persona);

        //Optional<Carrera> c = servicioCarrera.findById(7);
        Optional<Carrera> c2 = servicioCarrera.findById(9);
        Set<Carrera> carreras = new HashSet<>();
        //carreras.add(c.get());
        carreras.add((c2.get()));
        ((Profesor)p).setCarreras(carreras);
        System.out.println(servicio.save(p));*/
        //Iterable<Persona> profesor = servicio.findAll();


        /*EJERCICIO 1*/
        //Iterable<Persona> profesor = ((ProfesorDAO)servicio).findProfesoresByCarrera("Ingeneria Industrial ");

        //profesor.forEach(perso -> System.out.println(perso));

    }
}
