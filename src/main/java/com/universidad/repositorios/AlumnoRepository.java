package com.universidad.repositorios;

import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRespository{

    List<Alumno> findByNombre(String nombre);

    @Override
    @Query("select p from Alumno p inner join Persona a on p.id=a.id")
    Iterable<Persona> findAll();

    @Query("select a from Alumno  a join fetch a.carrera c where a.carrera.nombre=?1")
    Iterable<Persona> buscarAlumnoPorCarrera(String nombre);
}
