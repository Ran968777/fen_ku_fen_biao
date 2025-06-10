package org.example.ran.config;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * 数据库分片算法
 * 根据order_id % 2决定库
 */
public class MyDatabaseShardingAlgorithm implements StandardShardingAlgorithm<Long> {
    private Properties props = new Properties();

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        // 获取分片键的值
        Long orderId = shardingValue.getValue();
        
        // 计算分片结果：order_id % 2
        long shardingResult = orderId % 2;
        
        // 构建目标数据源名称
        String targetDataSource = "ds" + shardingResult;
        
        // 确保目标数据源在可用的数据源列表中
        if (availableTargetNames.contains(targetDataSource)) {
            return targetDataSource;
        }
        
        throw new UnsupportedOperationException("找不到匹配的数据源: " + targetDataSource);
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        // 范围查询时返回所有可用的数据源
        // 注意：这种实现会导致广播到所有数据源，可能影响性能
        return availableTargetNames;
    }



    @Override
    public String getType() {
        return "MyDatabaseShardingAlgorithm";
    }
    

}