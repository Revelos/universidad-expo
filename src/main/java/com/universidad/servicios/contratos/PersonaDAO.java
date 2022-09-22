package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericDAO<Persona>{
    Optional<Persona> buscarPorNombreYApellido(String nombre,String apellido);

    Optional<Persona> buscarPorDni(String dni);

    Optional<Persona> buscarPersonaPorApellido(String apellido);
}
