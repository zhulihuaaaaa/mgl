package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.SysApprovalModule;
import com.maigangle.gyl.facade.entity.SysApprovalModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysApprovalModuleMapper {
    int deleteByPrimaryKey(String approvalModuleId);

    int insert(SysApprovalModule record);

    SysApprovalModule insertSelective(SysApprovalModule record);

    List<SysApprovalModule> selectByExample(SysApprovalModuleExample example);

    SysApprovalModule selectByPrimaryKey(String approvalModuleId);

    int updateByExampleSelective(@Param("record") SysApprovalModule record, @Param("example") SysApprovalModuleExample example);

    int updateByExample(@Param("record") SysApprovalModule record, @Param("example") SysApprovalModuleExample example);

    int updateByPrimaryKeySelective(SysApprovalModule record);

    int updateByPrimaryKey(SysApprovalModule record);
}