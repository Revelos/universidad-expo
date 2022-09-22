package com.universidad.servicios.implementaciones;

import com.universidad.modelo.entidades.Carrera;
import com.universidad.repositorios.CarreraRepository;
import com.universidad.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CarreraDAOImpl extends GenericDAOImpl<Carrera,CarreraRepository> implements CarreraDAO {

    @Autowired
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }


    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByNombreContains(String nombre) {

        return repository.findCarreraByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarreraByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByCantidadAniosAfter(Integer cantidadAnios) {
        return repository.findCarreraByCantidadAniosAfter(cantidadAnios);
    }

    @Override
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido) {
        return repository.buscarCarrerasPorProfesorNombreYApellido(nombre,apellido);
    }
}
