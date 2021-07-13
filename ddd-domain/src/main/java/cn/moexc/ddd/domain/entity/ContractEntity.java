package cn.moexc.ddd.domain.entity;

import java.math.BigDecimal;

/**
    * 合同
    */
public class ContractEntity {
    /**
    * 合同ID
    */
    private String contractId;

    /**
    * 合同编号
    */
    private String contractNumber;

    /**
    * 合同单价
    */
    private BigDecimal contractPrice;

    /**
    * 合同数量
    */
    private BigDecimal contractWeight;

    /**
    * 已付款金额
    */
    private BigDecimal contractPayAmount;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public BigDecimal getContractWeight() {
        return contractWeight;
    }

    public void setContractWeight(BigDecimal contractWeight) {
        this.contractWeight = contractWeight;
    }

    public BigDecimal getContractPayAmount() {
        return contractPayAmount;
    }

    public void setContractPayAmount(BigDecimal contractPayAmount) {
        this.contractPayAmount = contractPayAmount;
    }
}