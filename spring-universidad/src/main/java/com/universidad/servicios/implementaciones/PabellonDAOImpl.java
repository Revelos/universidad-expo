package com.universidad.servicios.implementaciones;

import com.universidad.modelo.entidades.Pabellon;
import com.universidad.repositorios.PabellonRepository;
import com.universidad.servicios.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PabellonDAOImpl extends GenericDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO {

    @Autowired
    public PabellonDAOImpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Pabellon> findByDireccionLocalidad(String localidad) {
        return repository.findByDireccionLocalidad(localidad);
    }

    @Override
    public Iterable<Pabellon> findByNombre(String nombre) {
        return repository.findByNombreIgnoreCase(nombre);
    }
}
