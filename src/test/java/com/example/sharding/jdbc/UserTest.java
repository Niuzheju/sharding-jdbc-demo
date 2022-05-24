package com.example.sharding.jdbc;

import com.alibaba.fastjson2.JSON;
import com.example.sharding.jdbc.entity.UserEntity;
import com.example.sharding.jdbc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 测试取模分表
 *
 * @author niuzheju
 * @date 17:10 2022/5/23
 */
@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testAdd() {

        for (int i = 0; i < 20; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername("user" + i);
            userEntity.setPassword("123456");
            userEntity.setDesc("备注");
            userMapper.addUser(userEntity);
        }
    }

    @Test
    void testSelect() {
        List<UserEntity> list = userMapper.getAll();
        for (UserEntity userEntity : list) {
            System.out.println(JSON.toJSONString(userEntity));
        }

        UserEntity userEntity = userMapper.getById(735573315497754625L);
        System.out.println(JSON.toJSONString(userEntity));

        long count = userMapper.countUser();
        System.out.println(count);

    }


}
