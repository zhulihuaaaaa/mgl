package com.maigangle.gyl.service.mapper.ext;

import com.maigangle.gyl.facade.entity.OverdueDefer;
import com.maigangle.gyl.facade.entity.OverdueDeferExample;
import com.maigangle.gyl.facade.entity.vo.OverdueDeferVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OverdueDeferExtMapper {
    int deleteByPrimaryKey(String overdueDeferId);

    int insert(OverdueDefer record);

    int insertSelective(OverdueDefer record);

    List<OverdueDeferVo> selectByExample(OverdueDeferExample example);

    OverdueDefer selectByPrimaryKey(String overdueDeferId);

    int updateByExampleSelective(@Param("record") OverdueDefer record, @Param("example") OverdueDeferExample example);

    int updateByExample(@Param("record") OverdueDefer record, @Param("example") OverdueDeferExample example);

    int updateByPrimaryKeySelective(OverdueDefer record);

    int updateByPrimaryKey(OverdueDefer record);
}