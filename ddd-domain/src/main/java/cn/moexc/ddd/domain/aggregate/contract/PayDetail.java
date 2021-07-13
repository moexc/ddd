package cn.moexc.ddd.domain.aggregate.contract;



import cn.moexc.ddd.domain.entity.PaymentRecordsEntity;

import java.math.BigDecimal;
import java.util.Date;

public class PayDetail {
    /**
     * 付款ID
     */
    private String payId;
    /**
     * 付款单号
     */
    private String payNumber;
    /**
     * 付款金额
     */
    private BigDecimal money;

    /**
     * 时间
     */
    private Date time;

    public PayDetail(String payId, String payNumber, BigDecimal money) {
        this.payId = payId;
        this.payNumber = payNumber;
        this.money = money;
        this.time = new Date();
    }

    public PaymentRecordsEntity getEntity(String contractId){
        PaymentRecordsEntity entity = new PaymentRecordsEntity();
        entity.setPaymentId(this.payId);
        entity.setContractId(contractId);
        entity.setPaymentNumber(this.payNumber);
        entity.setPaymentMoney(this.money);
        entity.setPaymentTime(this.time);
        return entity;
    }

    public PayDetail(PaymentRecordsEntity payDetailEntity){
        this.payId = payDetailEntity.getPaymentId();
        this.payNumber = payDetailEntity.getPaymentNumber();
        this.money = payDetailEntity.getPaymentMoney();
        this.time = payDetailEntity.getPaymentTime();
    }

}
