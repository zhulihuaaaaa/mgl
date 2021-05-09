package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.InvCheckInv;
import com.maigangle.gyl.facade.entity.InvCheckInvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvCheckInvMapper {
    int deleteByPrimaryKey(String checkInvId);

    int insert(InvCheckInv record);

    int insertSelective(InvCheckInv record);

    List<InvCheckInv> selectByExample(InvCheckInvExample example);

    InvCheckInv selectByPrimaryKey(String checkInvId);

    int updateByExampleSelective(@Param("record") InvCheckInv record, @Param("example") InvCheckInvExample example);

    int updateByExample(@Param("record") InvCheckInv record, @Param("example") InvCheckInvExample example);

    int updateByPrimaryKeySelective(InvCheckInv record);

    int updateByPrimaryKey(InvCheckInv record);
}