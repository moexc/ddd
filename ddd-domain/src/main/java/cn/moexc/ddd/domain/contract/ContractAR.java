package cn.moexc.ddd.domain.contract;

import cn.moexc.ddd.domain.entity.ContractEntity;
import cn.moexc.ddd.domain.entity.PaymentRecordsEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContractAR {
    /**
     * 合同ID
     */
    private String contractId;
    /**
     * 合同编号
     */
    private String contractNumber;
    /**
     * 单价
     */
    private BigDecimal contractPrice;
    /**
     * 数量
     */
    private BigDecimal contractAmount;

    /**
     * 已付款
     */
    private BigDecimal contractPayAmount;
    /**
     * 付款明细
     */
    private List<PayDetail> payDetails = new ArrayList<>();

    public ContractAR(ContractEntity contractEntity, List<PaymentRecordsEntity> payDetailEntities) {
        this.contractId = contractEntity.getContractId();
        this.contractNumber = contractEntity.getContractNumber();
        this.contractPrice = contractEntity.getContractPrice();
        this.contractAmount = contractEntity.getContractWeight();
        this.contractPayAmount = contractEntity.getContractPayAmount();

        payDetailEntities.forEach(payDetailEntity -> this.payDetails.add(new PayDetail(payDetailEntity)));
    }

    public ContractEntity getContractEntity(){
        ContractEntity entity = new ContractEntity();
        entity.setContractId(this.contractId);
        entity.setContractNumber(this.contractNumber);
        entity.setContractPrice(this.contractPrice);
        entity.setContractWeight(this.contractAmount);
        entity.setContractPayAmount(this.contractPayAmount);
        return entity;
    }

    public List<PaymentRecordsEntity> getPayDetailEntites(){
        List<PaymentRecordsEntity> payDetailEntities = new ArrayList<>();
        this.payDetails.forEach(payDetail -> payDetailEntities.add(payDetail.getEntity(this.contractId)));
        return payDetailEntities;
    }

    /**
     * 付款
     * @param money 本次付款金额
     */
    public void pay(BigDecimal money){
        this.contractPayAmount = this.contractPayAmount.add(money);
        payDetails.add(new PayDetail(UUID.randomUUID().toString().replace("-", ""), this.nextPayNumber(), money));
    }

    /**
     * 计算付款单号
     * @return
     */
    private String nextPayNumber(){
        return "PAY_" + this.contractNumber + "_" + (this.payDetails.size() + 1);
    }

}
