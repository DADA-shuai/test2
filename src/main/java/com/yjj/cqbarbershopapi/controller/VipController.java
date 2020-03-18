package com.yjj.cqbarbershopapi.controller;

import com.yjj.cqbarbershopapi.entity.VIP;
import com.yjj.cqbarbershopapi.response.BaseResult;
import com.yjj.cqbarbershopapi.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class VipController {

    @Autowired
    VipService vipService;

    @GetMapping("/vip/list")
    public List<VIP> list(String page,String size, String name){
        //只对name进行查询
        if (page==null){
            page="0";
        }
        if (size==null){
            size="5";
        }
        List<VIP> list = new ArrayList<>();
        Page<VIP> vips = vipService.findAll(Integer.parseInt(page), Integer.parseInt(size),name);
        for (int i = 0; i < vips.getContent().size(); i++) {
            list.add(vips.getContent().get(i));
            System.out.println(vips.getContent().get(i));
            System.out.println(vips.getTotalElements());
        }
        return list;
    }

    @PostMapping("/vip")
    public BaseResult save(VIP vip){
        vip.setBalance(new BigDecimal("0"));
        vip.setCard_no("vip000006");
        vip.setCreate_date(new Date());
        boolean save = vipService.save(vip);
        if (save){
            return new BaseResult(save,"保存成功");
        }else {
            return new BaseResult(save,"名字没有或重复");
        }
    }

    @GetMapping("/vip/{id}")
    public VIP findById(@PathVariable("id") Integer id){
        System.out.println("test:"+id);
        return vipService.findById(id);
    }

    @DeleteMapping("/vip/{ids}")
    public BaseResult delete(@PathVariable("ids") String ids){
        String[] Ids = ids.split(",");
        // 将字符串数组转为List<Intger> 类型
        List<Integer> LString = new ArrayList<Integer>();
        for(String id : Ids){
            LString.add(new Integer(id));
        }
        vipService.deleteById(LString);
        return new BaseResult(true,"chenggong");
    }

    @PutMapping("/vip")
    public BaseResult update(@RequestBody VIP vip){
        System.out.println(vip);
        boolean update = vipService.update(vip);
        if (update){
            return new BaseResult(true,"chenggong");
        }
        return new BaseResult(false,"id输入有误");
    }



}
