package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.BaseCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCompanyMapper {
    int deleteByPrimaryKey(String companyId);

    int insert(BaseCompany record);

    int insertSelective(BaseCompany record);

    List<BaseCompany> selectByExample(BaseCompanyExample example);

    BaseCompany selectByPrimaryKey(String companyId);

    int updateByExampleSelective(@Param("record") BaseCompany record, @Param("example") BaseCompanyExample example);

    int updateByExample(@Param("record") BaseCompany record, @Param("example") BaseCompanyExample example);

    int updateByPrimaryKeySelective(BaseCompany record);

    int updateByPrimaryKey(BaseCompany record);
}