package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.SysApprovalProcess;
import com.maigangle.gyl.facade.entity.SysApprovalProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysApprovalProcessMapper {
    int deleteByPrimaryKey(String approvalProcessId);

    int insert(SysApprovalProcess record);

    int insertSelective(SysApprovalProcess record);

    List<SysApprovalProcess> selectByExample(SysApprovalProcessExample example);

    SysApprovalProcess selectByPrimaryKey(String approvalProcessId);

    int updateByExampleSelective(@Param("record") SysApprovalProcess record, @Param("example") SysApprovalProcessExample example);

    int updateByExample(@Param("record") SysApprovalProcess record, @Param("example") SysApprovalProcessExample example);

    int updateByPrimaryKeySelective(SysApprovalProcess record);

    int updateByPrimaryKey(SysApprovalProcess record);
}