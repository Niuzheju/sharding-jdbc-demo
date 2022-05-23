package com.example.sharding.jdbc.bean;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.Optional;

/**
 * @author niuzheju
 * @date 16:46 2022/5/18
 */
public class CustomDbPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        Optional<String> first = availableTargetNames.stream().findFirst();
        return first.orElse("ds0");
    }
}
