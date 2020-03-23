package com.springbook.rice.mapper;

import com.springbook.rice.common.domain.PrinterNew;
import com.springbook.rice.common.domain.PrinterNewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrinterNewMapper {
    long countByExample(PrinterNewExample example);

    int deleteByExample(PrinterNewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrinterNew record);

    int insertSelective(PrinterNew record);

    List<PrinterNew> selectByExample(PrinterNewExample example);

    PrinterNew selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrinterNew record, @Param("example") PrinterNewExample example);

    int updateByExample(@Param("record") PrinterNew record, @Param("example") PrinterNewExample example);

    int updateByPrimaryKeySelective(PrinterNew record);

    int updateByPrimaryKey(PrinterNew record);
}