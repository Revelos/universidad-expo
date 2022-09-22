package com.universidad.servicios.implementaciones;

import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.enumeradores.TipoEmplado;
import com.universidad.repositorios.EmpleadoRepository;
import com.universidad.repositorios.PersonaRespository;
import com.universidad.servicios.contratos.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {


    public EmpleadoDAOImpl(@Qualifier("repositorioEmpleado") PersonaRespository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmplado tipoEmpleado) {
        return ((EmpleadoRepository)repository).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }
}
