package com.universidad.repositorios;

import com.universidad.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface PersonaRespository extends CrudRepository<Persona,Integer> {

    Optional<Persona> findByNombreAndApellido(String nombre, String apellido);

    Optional<Persona> findByDni(String dni);

    @Query("select p from Persona p where p.apellido like %?1%")
    Optional<Persona> buscarPersonaPorApellido(String apellido);

}
