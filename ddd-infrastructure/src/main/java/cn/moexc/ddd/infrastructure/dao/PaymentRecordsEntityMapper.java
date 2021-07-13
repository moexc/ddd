package cn.moexc.ddd.infrastructure.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import cn.moexc.ddd.domain.entity.PaymentRecordsEntity;

public interface PaymentRecordsEntityMapper {
    int deleteByPrimaryKey(String paymentId);

    int insert(PaymentRecordsEntity record);

    int insertSelective(PaymentRecordsEntity record);

    PaymentRecordsEntity selectByPrimaryKey(String paymentId);

    int updateByPrimaryKeySelective(PaymentRecordsEntity record);

    int updateByPrimaryKey(PaymentRecordsEntity record);

    List<PaymentRecordsEntity> selectByContractId(@Param("contractId")String contractId);


}