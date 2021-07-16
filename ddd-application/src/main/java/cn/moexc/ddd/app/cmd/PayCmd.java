package cn.moexc.ddd.app.cmd;

import java.math.BigDecimal;

public class PayCmd {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 合同ID
     */
    private String contractId;

    /**
     * 支付金额
     */
    private BigDecimal money;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
