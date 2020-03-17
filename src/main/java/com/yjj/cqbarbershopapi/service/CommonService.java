package com.yjj.cqbarbershopapi.service;

import java.util.List;

public interface CommonService<T> {
    public T save(T t);

    public void deleteById(Integer id);

    public T findById(Integer id);

    public List<T> findAll();

    public T update(T t);
}
