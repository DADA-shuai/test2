package com.yjj.cqbarbershopapi.controller;

import com.yjj.cqbarbershopapi.dao.OrderRepository;
import com.yjj.cqbarbershopapi.entity.ORDER;
import com.yjj.cqbarbershopapi.response.BaseResult;
import com.yjj.cqbarbershopapi.service.OrderService;
import com.yjj.cqbarbershopapi.service.impl.OrderServiceimpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("order")
    @ApiOperation("带条件查询充值记录")
    public Page<ORDER> findByPage(int page,int size,String id){
        if (id==null){
            return null;
        }
        Page<ORDER> byPage = orderService.findByPage(page, size, Integer.parseInt(id));
        return byPage;
    }

    @GetMapping("order/list")
    @ApiOperation("充值记录")
    public List<ORDER> findAll(){
        List<ORDER> all = orderService.findAll();
        return all;
    }

    @PutMapping("order")
    @ApiOperation("充值入口")
    public BaseResult save(@ApiParam("vip的id") int id,@ApiParam("充值金额必须大于等于100") int amount){
        boolean b = orderService.reChange(id, amount);
        if (b){
            return new BaseResult(true,"充值成功");
        }else {
            return new BaseResult(false,"充值失败");
        }
    }
}
