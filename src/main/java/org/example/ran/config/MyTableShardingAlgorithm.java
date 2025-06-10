package org.example.ran.config;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * 表分片算法
 * 根据user_id % 2决定表
 */
public class MyTableShardingAlgorithm implements StandardShardingAlgorithm<Long> {
    private Properties props = new Properties();

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        // 获取分片键的值
        Long userId = shardingValue.getValue();
        
        // 计算分片结果：user_id % 2
        long shardingResult = userId % 2;
        
        // 构建目标表名
        String logicTableName = shardingValue.getLogicTableName();
        String targetTable = logicTableName + "_" + shardingResult;
        
        // 确保目标表在可用的表列表中
        if (availableTargetNames.contains(targetTable)) {
            return targetTable;
        }
        
        throw new UnsupportedOperationException("找不到匹配的表: " + targetTable);
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        // 范围查询时返回所有可用的表
        // 注意：这种实现会导致广播到所有表，可能影响性能
        return availableTargetNames;
    }



    @Override
    public String getType() {
        return "MyTableShardingAlgorithm";
    }
    

}