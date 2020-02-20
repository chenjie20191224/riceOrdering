package com.springbook.rice.mapper;

import com.springbook.rice.common.domain.Business;
import com.springbook.rice.common.domain.BusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessMapper {
    long countByExample(BusinessExample example);

    int deleteByExample(BusinessExample example);

    int deleteByPrimaryKey(Integer businessId);

    int insert(Business record);

    int insertSelective(Business record);

    List<Business> selectByExample(BusinessExample example);

    Business selectByPrimaryKey(Integer businessId);

    int updateByExampleSelective(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByExample(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
}