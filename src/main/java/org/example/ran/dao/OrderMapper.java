package org.example.ran.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.ran.model.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
