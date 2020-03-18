package com.yjj.cqbarbershopapi.service;

import com.yjj.cqbarbershopapi.entity.VIP;
import org.springframework.data.domain.Page;

import javax.persistence.criteria.CriteriaBuilder;
import javax.print.DocFlavor;
import java.util.List;

public interface CommonService<T> {
    public boolean save(T t);

    public void deleteById(List<Integer> id);

    public T findById(Integer id);

    public Page<VIP> findAll(int page, int size,String username);

    public boolean update(T t);

}
