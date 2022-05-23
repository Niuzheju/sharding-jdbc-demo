package com.example.sharding.jdbc;

import com.alibaba.fastjson2.JSON;
import com.example.sharding.jdbc.bean.IdWorker;
import com.example.sharding.jdbc.entity.OrderEntity;
import com.example.sharding.jdbc.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class ShardingJdbcDemoApplicationTests {

    @Autowired
    private OrderMapper orderMapper;


    /**
     * 测试自定义分表
     */
    @Test
    void contextLoads() {
        IdWorker idWorker = new IdWorker(1, 1, 1);
        Random random = new Random();
        Long storeNo1 = (long) random.nextInt(10000);
        for (int i = 0; i < 10; i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setId(idWorker.nextId());
            orderEntity.setStoreNo(storeNo1);
            orderEntity.setDesc("描述");
            int existTable = orderMapper.existTable(storeNo1);
            if (existTable == 0) {
                orderMapper.createNewTable(storeNo1);
            }
            orderMapper.addOrder(orderEntity);
        }

        Long storeNo2 = (long) random.nextInt(10000);
        for (int i = 10; i < 20; i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setId(idWorker.nextId());
            orderEntity.setStoreNo(storeNo2);
            orderEntity.setDesc("描述");
            int existTable = orderMapper.existTable(storeNo2);
            if (existTable == 0) {
                orderMapper.createNewTable(storeNo2);
            }
            orderMapper.addOrder(orderEntity);
        }
    }

    /**
     * 查询
     */
    @Test
    void test02() {
        OrderEntity entity = orderMapper.getById(944L, 39427325956096L);
        System.out.println(JSON.toJSONString(entity));

        List<OrderEntity> list = orderMapper.getAll(944L);
        System.out.println(JSON.toJSONString(list));

        long count = orderMapper.countOrder(944L);
        System.out.println(count);
    }


}
