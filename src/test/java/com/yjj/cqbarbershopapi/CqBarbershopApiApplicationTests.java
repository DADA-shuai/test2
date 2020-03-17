package com.yjj.cqbarbershopapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Persistence;

@SpringBootTest
class CqBarbershopApiApplicationTests {

    @Test
    void contextLoads() {

    }

    /**
     * 测试jpa的保存
     */
    @Test
    public void testSave(){
        Persistence.createEntityManagerFactory("");
    }

}
