package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Pabellon;

public interface PabellonDAO extends GenericDAO<Pabellon> {

    Iterable<Pabellon> findByDireccionLocalidad(String localidad);

    Iterable<Pabellon> findByNombre(String nombre);
}
