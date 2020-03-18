package com.yjj.cqbarbershopapi.service.impl;

import com.yjj.cqbarbershopapi.dao.VipRepository;
import com.yjj.cqbarbershopapi.entity.VIP;
import com.yjj.cqbarbershopapi.service.VipService;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VipServiceimpl implements VipService {

    @Autowired
    VipRepository vipRepository;

    @Override
    public boolean save(VIP vip) {
        if (vip.getName()!=null){
            ExampleMatcher matcher = ExampleMatcher.matching().
                    withIgnorePaths("id").withIgnorePaths("pass").
                    withIgnorePaths("tel").withIgnorePaths("create_date").
                    withIgnorePaths("balance").withIgnorePaths("card_no");
            Example<VIP> example = Example.of(vip, matcher);
            Optional<VIP> vip1 = vipRepository.findOne(example);
            if (vip1.isPresent()){
                return false;
            }else{
                vipRepository.save(vip);
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteById(List<Integer> ids) {
        for (Integer id : ids){
            vipRepository.deleteById(id);
        }
    }

    @Override
    public VIP findById(Integer id) {
       return vipRepository.findById(id).get();
//        return vipRepository.getOne(id);
    }

    @Override
    public Page<VIP> findAll(int page,int size,String username) {
        VIP vip =new VIP();
        vip.setName(username);
        ExampleMatcher matcher = ExampleMatcher.matching().
                withMatcher("name", match->match.startsWith()).
                withIgnorePaths("id").withIgnorePaths("pass");
        Example<VIP> example = Example.of(vip, matcher);
        PageRequest pageRequest = PageRequest.of(page, size , JpaSort.unsafe(Sort.Direction.DESC,"id"));
        return vipRepository.findAll(example,pageRequest);
    }

    @Override
    public boolean update(VIP vip) {
        if (vip.getId()!=null){
            int id = vip.getId();
            VIP vip1 = vipRepository.findById(id).get();
            if (vip1==null){
                return false;
            }
            vip1.setTel(vip.getTel());
            vip1.setPass(vip.getPass());
            vipRepository.save(vip1);
            return true;
        }
        return false;
    }

}
