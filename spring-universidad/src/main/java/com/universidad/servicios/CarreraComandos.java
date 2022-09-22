package com.universidad.servicios;

import com.universidad.modelo.entidades.Carrera;
import com.universidad.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarreraComandos implements CommandLineRunner {


    @Autowired
    private CarreraDAO servicio;

    @Override
    public void run(String... args) throws Exception {


        //Carrera ingSistemas = new Carrera(null,"Ingeneria en Sistemas ",44,5);
       /* Carrera ingIndustrial = new Carrera(null,"Ingeneria Industrial ",44,5);
        Carrera ingAlimentos = new Carrera(null,"Ingeneria en Alimentos ",44,5);
        Carrera ingElectronica = new Carrera(null,"Ingeneria Electronica ",44,5);
        Carrera licSistemas = new Carrera(null,"Licenciatura en Sistemas ",44,5);
        Carrera licCienciasDatos = new Carrera(null,"Licenciatura en ciencias de datos ",44,5);
        Carrera licAdminEmp = new Carrera(null,"Licenciatura en administraccion de empresas ",44,5);
        Carrera licIdiomas = new Carrera(null,"Licenciatura en Idiomas ",44,5);


        //servicio.save(ingSistemas);
        servicio.save(ingIndustrial);
        servicio.save(ingAlimentos);
        servicio.save(ingElectronica);
        servicio.save(licSistemas);
        servicio.save(licCienciasDatos);
        servicio.save(licAdminEmp);
        servicio.save(licIdiomas);*/



        /*List<Carrera> carreras = (List<Carrera>) servicio.findCarreraByNombreContains("temas");
        List<Carrera> carrerasIgnore = (List<Carrera>) servicio.findCarreraByCantidadAniosAfter(5);
        carrerasIgnore.forEach(System.out::println);*/


        //EJERCICIO 3

        //Iterable<Carrera> c = servicio.buscarCarrerasPorProfesorNombreYApellido("Henry","Nuñez");
        //c.forEach(System.out::println);



        /* Carrera ingSistemas = new Carrera(null,"Ingeneria en Sistemas ",44,5);
            Carrera car = serv.save(ingSistemas);
            //System.out.println(save.toString());*/


        //Carrera carrera = new Carrera(1,"Ingenieria",25,25);
            /*Direccion direccion = new Direccion("calle pte","23","123-8","San Salvador","6","3");
            Persona alumno = new Alumno(null,"Cristian","Revelo","1234567", direccion);
            //Alumno a = (Alumno) alumno;
            //a.setCarrera(car);
            Alumno save = (Alumno) servicio.save(alumno);
            System.out.println(save.toString());*/


        /*Carrera carrera = null;


        Optional<Carrera> carreras = servicio.findById(1);

        if(carreras.isPresent()){
            carrera = carreras.get();
            System.out.println(carrera.toString());
        }else{
            System.out.println("No existe la carrera con ese Id");
        }
        carrera.setCantidadMaterias(55);
        carrera.setCantidadAnios(6);

        servicio.save(carrera);
        Direccion direccion = new Direccion("calle pte","23","123-8","San Salvador","6","3");
        Persona alumno = new Alumno(null,"Cristian","Revelo","1234567", direccion);
        Alumno a = (Alumno) alumno;
        a.setCarrera(carrera);
        Alumno save = (Alumno) serv.save(alumno);
        System.out.println(servicio.findById(1).orElse(new Carrera()));
        servicio.deleteById(1);
        System.out.println(servicio.findById(1).orElse(new Carrera()));*/


    }
}
