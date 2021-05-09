package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.BaseProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(BaseProduct record);

    int insertSelective(BaseProduct record);

    List<BaseProduct> selectByExample(BaseProductExample example);

    BaseProduct selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") BaseProduct record, @Param("example") BaseProductExample example);

    int updateByExample(@Param("record") BaseProduct record, @Param("example") BaseProductExample example);

    int updateByPrimaryKeySelective(BaseProduct record);

    int updateByPrimaryKey(BaseProduct record);
}