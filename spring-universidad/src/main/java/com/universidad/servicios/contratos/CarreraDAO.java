package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Carrera;
import java.util.Optional;

public interface CarreraDAO extends GenericDAO<Carrera>{
    Iterable<Carrera> findCarreraByNombreContains(String nombre);
    Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarreraByCantidadAniosAfter(Integer cantidadAnios);

    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}
