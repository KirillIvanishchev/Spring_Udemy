package com.myapp.RESTful.repository;

import java.util.*;

//Third create basic repository to form a behaviour for data exchange between Client and Service.
public interface DataAccessObject_BaseRepository<T> {
    List<T> findAll();
    T findById(int id);
    T save(T entity);
    void deleteById(int id);
}
