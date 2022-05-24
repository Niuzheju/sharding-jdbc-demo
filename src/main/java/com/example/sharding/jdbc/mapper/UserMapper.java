package com.example.sharding.jdbc.mapper;

import com.example.sharding.jdbc.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author niuzheju
 * @date 17:03 2022/5/23
 */
@Mapper
@Repository
public interface UserMapper {
    int addUser(UserEntity userEntity);

    UserEntity getById(Long id);

    List<UserEntity> getAll();

    long countUser();
}
