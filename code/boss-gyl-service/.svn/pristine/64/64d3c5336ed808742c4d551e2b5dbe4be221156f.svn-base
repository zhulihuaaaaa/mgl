package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.ConPaymentDetail;
import com.maigangle.gyl.facade.entity.ConPaymentDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConPaymentDetailMapper {
    int deleteByPrimaryKey(String paymentDetailId);

    int insert(ConPaymentDetail record);

    int insertSelective(ConPaymentDetail record);

    List<ConPaymentDetail> selectByExample(ConPaymentDetailExample example);

    ConPaymentDetail selectByPrimaryKey(String paymentDetailId);

    int updateByExampleSelective(@Param("record") ConPaymentDetail record, @Param("example") ConPaymentDetailExample example);

    int updateByExample(@Param("record") ConPaymentDetail record, @Param("example") ConPaymentDetailExample example);

    int updateByPrimaryKeySelective(ConPaymentDetail record);

    int updateByPrimaryKey(ConPaymentDetail record);
}