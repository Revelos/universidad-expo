package com.universidad.servicios.implementaciones;

import com.universidad.modelo.entidades.Persona;
import com.universidad.repositorios.PersonaRespository;
import com.universidad.repositorios.ProfesorRepository;
import com.universidad.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {
    public ProfesorDAOImpl(@Qualifier("repositorioProfesor") PersonaRespository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> findProfesoresByCarrera(String carrera) {
        return ((ProfesorRepository)repository).findProfesoresByCarrera(carrera);
    }
}
