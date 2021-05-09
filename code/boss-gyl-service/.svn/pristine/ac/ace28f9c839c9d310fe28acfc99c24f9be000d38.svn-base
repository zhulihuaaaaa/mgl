package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.AttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttachMapper {
    int deleteByPrimaryKey(String attachId);

    int insert(Attach record);

    int insertSelective(Attach record);

    List<Attach> selectByExample(AttachExample example);

    Attach selectByPrimaryKey(String attachId);

    int updateByExampleSelective(@Param("record") Attach record, @Param("example") AttachExample example);

    int updateByExample(@Param("record") Attach record, @Param("example") AttachExample example);

    int updateByPrimaryKeySelective(Attach record);

    int updateByPrimaryKey(Attach record);
}