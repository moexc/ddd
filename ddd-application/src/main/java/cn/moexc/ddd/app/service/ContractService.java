package cn.moexc.ddd.app.service;

import cn.moexc.ddd.app.cmd.PayCmd;

public interface ContractService {
    void pay(PayCmd payCmd);
}
