package com.universidad;

import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.modelo.entidades.Persona;
import com.universidad.servicios.contratos.AlumnoDAO;
import com.universidad.servicios.contratos.CarreraDAO;
import com.universidad.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnosCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;

    @Autowired
    private CarreraDAO carreraDAO;

    @Override
    public void run(String... args) throws Exception {
        /*Optional<Carrera> carrera = carreraDAO.findById(7);

        Iterable<Persona> alumnos = personaDAO.findAll();

        alumnos.forEach(alumno -> ((Alumno) alumno).setCarrera(carrera.get()));
        alumnos.forEach(alumno -> personaDAO.save(alumno));*/

        /*Optional<Persona> alumno1 = personaDAO.findById(2);
        Optional<Persona> personNomApe = personaDAO.buscarPorNombreYApellido(alumno1.get().getNombre(),alumno1.get().getApellido());
        System.out.println(personNomApe.get());*/


        /*Optional<Persona> alumno = personaDAO.buscarPorNombreYApellido("Cristian","Revelo");
        System.out.println(alumno.toString());*/
        /*Optional<Carrera> carrera = carreraDAO.findById(7);

        Iterable<Persona> alumnosCarreras=((AlumnoDAO)personaDAO).buscarAlumnosPorNombreCarrera(carrera.get().getNombre());
        alumnosCarreras.forEach(System.out::println);*/

    }
}
