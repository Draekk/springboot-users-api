package com.draekk.springboot.springbootusersapi.repositories;

import java.util.List;

public interface IRepository<T> {

    void save(T t);
    void edit(T t);
    void delete(T t);
    T findById(Long id);
    T findByStr(String str);
    List<T> findAll();
    List<T> findByStrList(String str);
    int count();
    Long nextId();
}
