package com.yjj.cqbarbershopapi.dao;

import com.yjj.cqbarbershopapi.entity.VIP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface VipRepository extends JpaRepository<VIP,Integer>, JpaSpecificationExecutor<VIP> {

}
