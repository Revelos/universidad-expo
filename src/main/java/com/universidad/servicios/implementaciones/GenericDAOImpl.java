package com.universidad.servicios.implementaciones;

import com.universidad.servicios.contratos.GenericDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericDAOImpl<T,R extends CrudRepository<T,Integer>> implements GenericDAO<T> {


    protected final R repository;


    public GenericDAOImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(Integer id) {
        return Optional.ofNullable(repository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
