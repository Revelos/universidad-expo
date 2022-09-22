package com.universidad.repositorios;

import com.universidad.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesor")
public interface ProfesorRepository extends PersonaRespository{

    @Override
    @Query("select p from Profesor p inner join Persona a on p.id=a.id")
    Iterable<Persona> findAll();

    @Query("select p from Profesor p  join fetch p.carreras c where c.nombre=?1")
    Iterable<Persona>  findProfesoresByCarrera(String carrera);
}
