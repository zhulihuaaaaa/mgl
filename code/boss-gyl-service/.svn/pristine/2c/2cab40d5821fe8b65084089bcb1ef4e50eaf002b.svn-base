package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.SysApprovalFlow;
import com.maigangle.gyl.facade.entity.SysApprovalFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysApprovalFlowMapper {
    int deleteByPrimaryKey(String approvalFlowId);

    int insert(SysApprovalFlow record);

    int insertSelective(SysApprovalFlow record);

    List<SysApprovalFlow> selectByExample(SysApprovalFlowExample example);

    SysApprovalFlow selectByPrimaryKey(String approvalFlowId);

    int updateByExampleSelective(@Param("record") SysApprovalFlow record, @Param("example") SysApprovalFlowExample example);

    int updateByExample(@Param("record") SysApprovalFlow record, @Param("example") SysApprovalFlowExample example);

    int updateByPrimaryKeySelective(SysApprovalFlow record);

    int updateByPrimaryKey(SysApprovalFlow record);
}