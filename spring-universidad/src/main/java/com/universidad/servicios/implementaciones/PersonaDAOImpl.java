package com.universidad.servicios.implementaciones;

import com.universidad.modelo.entidades.Persona;
import com.universidad.repositorios.PersonaRespository;
import com.universidad.servicios.contratos.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends GenericDAOImpl<Persona, PersonaRespository> implements PersonaDAO {

    public PersonaDAOImpl(PersonaRespository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return repository.findByNombreAndApellido(nombre,apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDni(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPersonaPorApellido(String apellido) {
        return repository.buscarPersonaPorApellido(apellido);
    }
}
