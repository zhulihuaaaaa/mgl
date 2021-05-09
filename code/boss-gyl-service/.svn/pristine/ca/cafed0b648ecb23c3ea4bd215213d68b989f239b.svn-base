package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.GridConfig;
import com.maigangle.gyl.facade.entity.GridConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GridConfigMapper {
    int deleteByPrimaryKey(String gridId);

    int insert(GridConfig record);

    int insertSelective(GridConfig record);

    List<GridConfig> selectByExample(GridConfigExample example);

    GridConfig selectByPrimaryKey(String gridId);
    
    GridConfig selectByCode(@Param("code") String code,@Param("userId") String userId);

    int updateByExampleSelective(@Param("record") GridConfig record, @Param("example") GridConfigExample example);

    int updateByExample(@Param("record") GridConfig record, @Param("example") GridConfigExample example);

    int updateByPrimaryKeySelective(GridConfig record);

    int updateByPrimaryKey(GridConfig record);
}