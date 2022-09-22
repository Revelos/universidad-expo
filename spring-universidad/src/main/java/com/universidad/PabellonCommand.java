package com.universidad;

import com.universidad.modelo.entidades.Direccion;
import com.universidad.modelo.entidades.Pabellon;
import com.universidad.repositorios.PabellonRepository;
import com.universidad.servicios.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class PabellonCommand implements CommandLineRunner {

    @Autowired
    private PabellonDAO service;


    @Override
    public void run(String... args) throws Exception {
        Direccion direccion = new Direccion("calle pte","23","123-8","San Salvador","6","3");
        Direccion direccion2 = new Direccion("calle pte","23","123-8","San Salvador","6","4");
        Direccion direccion3 = new Direccion("calle pte","23","123-8","San Salvador","6","5");

        //Pabellon p = new Pabellon(null,25.3,"Pabellon 4",direccion);

        //Pabellon p2 = new Pabellon(null,25.3,"Pabellon 5",direccion2);
        //Pabellon p3 = new Pabellon(null,25.3,"Pabellon 6",direccion3);

        //service.save(p3);

        //System.out.println(service.findByNombre("Pabellon 4"));
        //System.out.println(service.findByDireccionLocalidad("5"));
    }
}
