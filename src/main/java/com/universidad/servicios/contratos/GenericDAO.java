package com.universidad.servicios.contratos;

import java.util.Optional;

public interface GenericDAO<T> {

    Optional<T> findById(Integer id);

    T save(T t);

    Iterable<T> findAll();

    void deleteById(Integer id);

}
