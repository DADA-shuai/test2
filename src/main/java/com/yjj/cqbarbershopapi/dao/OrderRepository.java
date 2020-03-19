package com.yjj.cqbarbershopapi.dao;

import com.yjj.cqbarbershopapi.entity.ORDER;
import com.yjj.cqbarbershopapi.entity.VIP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface OrderRepository extends JpaRepository<ORDER,Integer>, JpaSpecificationExecutor<ORDER> {

}
