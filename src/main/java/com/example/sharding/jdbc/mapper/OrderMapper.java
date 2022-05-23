package com.example.sharding.jdbc.mapper;

import com.example.sharding.jdbc.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author niuzheju
 * @date 15:56 2022/5/16
 */
@Mapper
@Repository
public interface OrderMapper {

    int addOrder(OrderEntity orderEntity);

    OrderEntity getById(@Param("storeNo") Long storeNo, @Param("id") long id);

    List<OrderEntity> getAll(@Param("storeNo") Long storeNo);

    int createNewTable(Long storeNo);

    int existTable(Long storeNo);

    long countOrder(Long storeNo);
}
