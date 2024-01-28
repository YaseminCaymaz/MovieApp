package com.yasemin.utility;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T,ID> {

    T save(T entity);
    T update(T entity);
    Iterable<T> saveAll(Iterable<T> t);
    Optional<T> findById(ID id);
    List<T> findAll();
    T delete(T entity);
    T deleteById(ID id);
}
