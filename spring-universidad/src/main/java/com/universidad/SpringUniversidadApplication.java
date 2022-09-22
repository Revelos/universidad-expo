package com.universidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringUniversidadApplication {
   /* @Autowired
    private AlumnoDAO servicio;
    @Autowired
    private CarreraDAO serv;*/

    public static void main(String[] args) {
        String[] beanDefinitionNames = SpringApplication.run(SpringUniversidadApplication.class, args).getBeanDefinitionNames();
       /* for (String  str: beanDefinitionNames){
            System.out.println(str);
        }*/
    }
/*
    @Bean
    public CommandLineRunner runner(){

        return args -> {
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

            /*List<Persona> alumnos = (List<Persona>) servicio.findAll();
            alumnos.forEach(System.out::println);
        };
        };
    */
    }


