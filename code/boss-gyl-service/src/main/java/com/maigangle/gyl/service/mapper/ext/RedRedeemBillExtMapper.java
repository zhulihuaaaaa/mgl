package com.maigangle.gyl.service.mapper.ext;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.RedRedeemBill;
import com.maigangle.gyl.facade.entity.RedRedeemBillExample;
import com.maigangle.gyl.facade.entity.dto.InvoiceGoodsConditionDto;
import com.maigangle.gyl.facade.entity.vo.InvoiceGoodsConditionVo;
import com.maigangle.gyl.facade.entity.vo.RedRedeemGoodsVo;
import com.maigangle.gyl.facade.entity.vo.RedRedeemVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RedRedeemBillExtMapper {

    List<RedRedeemVo> selectByExample(RedRedeemBillExample example);
    /**
     * 根据客户及仓库获取待出货货物列表
     * @param buyerId
     * @param storageId
     * @return
     */
    List<RedRedeemGoodsVo> selectNextOutstockGoods(@Param("buyerId") String buyerId, @Param("storageId") String storageId);
    /**
     * 查询仓库货物不为0合同
     * @param buyerId
     * @param storageId
     * @return
     */
    List<RedRedeemGoodsVo> selectQuantityqGoods(@Param("contractId") String contractId);
    /**
     * 查询发票出销
     * @param redBillId
     * @return
     */
    List<InvoiceGoodsConditionVo> getInvoiceGoodsOut(@Param("dto") InvoiceGoodsConditionDto dto); 
}