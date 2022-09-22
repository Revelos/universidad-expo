package com.universidad.repositorios;

import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.enumeradores.Pizarron;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface AulaRepository extends CrudRepository<Aula, Integer> {

    Iterable<Aula> findAulaByPizarron(Pizarron pizarron);

    Iterable<Aula> findAulaByPabellon_Nombre(String pabellon);

    Optional<Aula> findByNroAula(Integer nroAula);
}
