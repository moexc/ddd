package cn.moexc.ddd.domain.entity;

import cn.moexc.ddd.domain.aggregate.contract.PayDetail;

import java.math.BigDecimal;
import java.util.Date;

/**
    * 付款记录
    */
public class PaymentRecordsEntity {
    /**
    * 付款记录ID
    */
    private String paymentId;

    /**
    * 合同ID
    */
    private String contractId;

    /**
    * 付款单号
    */
    private String paymentNumber;

    /**
    * 付款金额
    */
    private BigDecimal paymentMoney;

    /**
    * 付款时间
    */
    private Date paymentTime;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}