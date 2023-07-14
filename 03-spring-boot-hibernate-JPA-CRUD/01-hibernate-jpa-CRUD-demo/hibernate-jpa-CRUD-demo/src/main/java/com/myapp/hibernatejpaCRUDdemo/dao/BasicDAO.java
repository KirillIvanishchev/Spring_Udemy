package com.myapp.hibernatejpaCRUDdemo.dao;

import java.util.List;

public interface BasicDAO<T> {
    void save(T object);
    void saveAll(List<T> objects);
    T findById(Integer id);

    List<T> findAll();

    List<T> findByLastName(String keyWord);
    void update (T object);

    int deleteAll();
    void deleteById(int id);
    int deleteByFirstName(String keyWord);
}
