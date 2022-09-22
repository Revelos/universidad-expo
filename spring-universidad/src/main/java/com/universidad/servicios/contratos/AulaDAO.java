package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.enumeradores.Pizarron;
import com.universidad.repositorios.AulaRepository;
import com.universidad.servicios.implementaciones.GenericDAOImpl;

import java.util.Optional;

public interface AulaDAO extends GenericDAO<Aula> {

    Iterable<Aula> findAulaByPizarron(Pizarron pizarron);

    Iterable<Aula> findAulaByPabellonNombre(String pabellon);

    Optional<Aula> findByNroAula(Integer nroAula);
}
