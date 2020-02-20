package com.springbook.rice.mapper;

import com.springbook.rice.common.domain.OrderFood;
import com.springbook.rice.common.domain.OrderFoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderFoodMapper {
    long countByExample(OrderFoodExample example);

    int deleteByExample(OrderFoodExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderFood record);

    int insertSelective(OrderFood record);

    List<OrderFood> selectByExample(OrderFoodExample example);

    OrderFood selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderFood record, @Param("example") OrderFoodExample example);

    int updateByExample(@Param("record") OrderFood record, @Param("example") OrderFoodExample example);

    int updateByPrimaryKeySelective(OrderFood record);

    int updateByPrimaryKey(OrderFood record);
}