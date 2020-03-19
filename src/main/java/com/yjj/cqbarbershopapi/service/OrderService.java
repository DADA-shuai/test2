package com.yjj.cqbarbershopapi.service;

import com.yjj.cqbarbershopapi.entity.ORDER;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {
    public Page<ORDER> findByPage(int page,int size,int id);

    public List<ORDER> findAll();

    public boolean reChange(int id,int amount);
}
