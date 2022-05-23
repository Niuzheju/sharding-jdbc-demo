package com.example.sharding.jdbc.bean;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author niuzheju
 * @date 17:57 2022/5/17
 */
public class CustomTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {


    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        // getLogicTableName 逻辑表, getValue分片列的值
        return shardingValue.getLogicTableName() + shardingValue.getValue();
    }
}
