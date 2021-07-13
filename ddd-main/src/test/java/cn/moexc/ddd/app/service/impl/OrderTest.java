package cn.moexc.ddd.app.service.impl;

import cn.moexc.ddd.app.cmd.PayCmd;
import cn.moexc.ddd.app.service.ContractService;
import cn.moexc.ddd.main.Start;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest(classes = Start.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderTest {

    @Autowired
    private ContractService contractService;

    @Test
    public void pay(){
        PayCmd payCmd = new PayCmd();
        payCmd.setContractId("1");
        payCmd.setMoney(new BigDecimal("100"));
        contractService.pay(payCmd);
    }
}