package com.myapp.RESTful.service;

import java.util.*;

//At six, we need to create base Service interface/interfaces for @Service classes.
// Services are designed to create custom business logic for application.
// Services (@Service) and Repositories (@Repository) are basically Components (@Component).
// BUT they specify our LOGIC.
// So @Repository is for DATA BASE BOUND.
// @Service is for REST API.
// We need to do this, to simplify our businnes logic within further classes.
public interface BaseService <T> {
    List<T> findAll();
    T findById(int id);
    T save(T entity);
    void deleteById(int id);
}
