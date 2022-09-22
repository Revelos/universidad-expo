package com.universidad.repositorios;

import com.universidad.modelo.entidades.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepository extends CrudRepository<Carrera,Integer>{



    Iterable<Carrera> findCarreraByNombreContains(String nombre);


    //El ignoreCase ayuda a ignorar la mayusculas
    Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(String nombre);

    Iterable<Carrera> findCarreraByCantidadAniosAfter(Integer cantidadAnios);

    @Query("select c from Carrera c join fetch c.profesores p where p.nombre=?1 and p.apellido=?2")
    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}
