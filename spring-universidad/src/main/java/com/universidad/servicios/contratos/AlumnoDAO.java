package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlumnoDAO extends PersonaDAO{


    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);


}
