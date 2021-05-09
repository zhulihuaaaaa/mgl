package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.InApplyRemitDetail;
import com.maigangle.gyl.facade.entity.InApplyRemitDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InApplyRemitDetailMapper {
    int deleteByPrimaryKey(String applyRemitDetailId);

    int insert(InApplyRemitDetail record);

    int insertSelective(InApplyRemitDetail record);

    List<InApplyRemitDetail> selectByExample(InApplyRemitDetailExample example);

    InApplyRemitDetail selectByPrimaryKey(String applyRemitDetailId);

    int updateByExampleSelective(@Param("record") InApplyRemitDetail record, @Param("example") InApplyRemitDetailExample example);

    int updateByExample(@Param("record") InApplyRemitDetail record, @Param("example") InApplyRemitDetailExample example);

    int updateByPrimaryKeySelective(InApplyRemitDetail record);

    int updateByPrimaryKey(InApplyRemitDetail record);
}