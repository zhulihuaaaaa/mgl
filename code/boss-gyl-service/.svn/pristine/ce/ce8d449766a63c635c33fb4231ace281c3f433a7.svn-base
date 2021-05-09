package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.InvInventory;
import com.maigangle.gyl.facade.entity.InvInventoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvInventoryMapper {
    int deleteByPrimaryKey(String inventoryId);

    int insert(InvInventory record);

    int insertSelective(InvInventory record);

    List<InvInventory> selectByExample(InvInventoryExample example);

    InvInventory selectByPrimaryKey(String inventoryId);

    int updateByExampleSelective(@Param("record") InvInventory record, @Param("example") InvInventoryExample example);

    int updateByExample(@Param("record") InvInventory record, @Param("example") InvInventoryExample example);

    int updateByPrimaryKeySelective(InvInventory record);

    int updateByPrimaryKey(InvInventory record);
}