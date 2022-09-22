package com.universidad.servicios.implementaciones;

import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.enumeradores.Pizarron;
import com.universidad.repositorios.AulaRepository;
import com.universidad.servicios.contratos.AulaDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AulaDAOImpl extends GenericDAOImpl<Aula, AulaRepository> implements AulaDAO {
    public AulaDAOImpl(AulaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Aula> findAulaByPizarron(Pizarron pizarron) {
        return repository.findAulaByPizarron(pizarron);
    }

    @Override
    public Iterable<Aula> findAulaByPabellonNombre(String pabellon) {
        return repository.findAulaByPabellon_Nombre(pabellon);
    }

    @Override
    public Optional<Aula> findByNroAula(Integer nroAula) {
        return repository.findByNroAula(nroAula);
    }
}
