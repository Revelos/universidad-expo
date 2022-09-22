package com.universidad.repositorios;

import com.universidad.modelo.entidades.Pabellon;
import org.springframework.data.repository.CrudRepository;
/**
 * repositorio que contiene consultas por metodos
 * */
public interface PabellonRepository extends CrudRepository<Pabellon,Integer> {

    Iterable<Pabellon> findByDireccionLocalidad(String localidad);

    Iterable<Pabellon> findByNombreIgnoreCase(String nombre);
}
