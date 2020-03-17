package com.yjj.cqbarbershopapi.controller;

import com.yjj.cqbarbershopapi.entity.VIP;
import com.yjj.cqbarbershopapi.response.BaseResult;
import com.yjj.cqbarbershopapi.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
public class VipController {

    @Autowired
    VipService vipService;

    @GetMapping("/vip/list")
    public List<VIP> list(){
        return vipService.findAll();
    }

    @PostMapping("/vip")
    public VIP save(VIP vip){
        vip.setBalance(new BigDecimal("0"));
        vip.setCard_no("vip000006");
        vip.setCreate_date(new Date());
        return vipService.save(vip);
    }

    @GetMapping("/vip/{id}")
    public VIP findById(@PathVariable("id") Integer id){
        System.out.println("test:"+id);
        return vipService.findById(id);
    }

    @DeleteMapping("/vip/{id}")
    public BaseResult delete(@PathVariable("id") Integer id){
        vipService.deleteById(id);
        return new BaseResult(true,"chenggong");
    }

    @PutMapping("/vip")
    public VIP update(VIP vip){
        return vipService.update(vip);
    }
}
