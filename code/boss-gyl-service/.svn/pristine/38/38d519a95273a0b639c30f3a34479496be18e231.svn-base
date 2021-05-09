package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.InvCheckInvDetail;
import com.maigangle.gyl.facade.entity.InvCheckInvDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvCheckInvDetailMapper {
    int deleteByPrimaryKey(String checkInvDetailId);

    int insert(InvCheckInvDetail record);

    int insertSelective(InvCheckInvDetail record);

    List<InvCheckInvDetail> selectByExample(InvCheckInvDetailExample example);

    InvCheckInvDetail selectByPrimaryKey(String checkInvDetailId);

    int updateByExampleSelective(@Param("record") InvCheckInvDetail record, @Param("example") InvCheckInvDetailExample example);

    int updateByExample(@Param("record") InvCheckInvDetail record, @Param("example") InvCheckInvDetailExample example);

    int updateByPrimaryKeySelective(InvCheckInvDetail record);

    int updateByPrimaryKey(InvCheckInvDetail record);
}