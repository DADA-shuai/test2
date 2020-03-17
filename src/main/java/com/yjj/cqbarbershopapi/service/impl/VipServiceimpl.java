package com.yjj.cqbarbershopapi.service.impl;

import com.yjj.cqbarbershopapi.dao.VipRepository;
import com.yjj.cqbarbershopapi.entity.VIP;
import com.yjj.cqbarbershopapi.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VipServiceimpl implements VipService {

    @Autowired
    VipRepository vipRepository;

    @Override
    public VIP save(VIP vip) {
        return vipRepository.save(vip);
    }

    @Override
    public void deleteById(Integer id) {
        vipRepository.deleteById(id);
    }

    @Override
    public VIP findById(Integer id) {
       return vipRepository.findById(id).get();
//        return vipRepository.getOne(id);
    }

    @Override
    public List<VIP> findAll() {
        return vipRepository.findAll();
    }

    @Override
    public VIP update(VIP vip) {
        int id = vip.getId();
        VIP vip1 = vipRepository.findById(id).get();
        vip1.setTel(vip.getTel());
        vip1.setPass(vip.getPass());
        return vipRepository.save(vip1);
    }
}
