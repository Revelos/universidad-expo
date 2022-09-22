package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Persona;
import org.springframework.stereotype.Service;


public interface ProfesorDAO extends PersonaDAO{
    Iterable<Persona> findProfesoresByCarrera(String carrera);
}
