package com.springbook.rice.mapper;

import com.springbook.rice.common.domain.CategoryFood;
import com.springbook.rice.common.domain.CategoryFoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryFoodMapper {
    long countByExample(CategoryFoodExample example);

    int deleteByExample(CategoryFoodExample example);

    int deleteByPrimaryKey(Integer sort);

    int insert(CategoryFood record);

    int insertSelective(CategoryFood record);

    List<CategoryFood> selectByExample(CategoryFoodExample example);

    CategoryFood selectByPrimaryKey(Integer sort);

    int updateByExampleSelective(@Param("record") CategoryFood record, @Param("example") CategoryFoodExample example);

    int updateByExample(@Param("record") CategoryFood record, @Param("example") CategoryFoodExample example);

    int updateByPrimaryKeySelective(CategoryFood record);

    int updateByPrimaryKey(CategoryFood record);
}