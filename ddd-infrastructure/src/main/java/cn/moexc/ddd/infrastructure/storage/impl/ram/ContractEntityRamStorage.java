package cn.moexc.ddd.infrastructure.storage.impl.ram;

import cn.moexc.ddd.domain.entity.ContractEntity;
import cn.moexc.ddd.infrastructure.config.RamStorageConditional;
import cn.moexc.ddd.infrastructure.storage.ContractEntityStorage;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
@Conditional(RamStorageConditional.class)
public class ContractEntityRamStorage implements ContractEntityStorage {

    private static Map<String, ContractEntity> contractEntityMap = new HashMap<>();
    static {
        ContractEntity entity = new ContractEntity();
        entity.setContractId("1");
        entity.setContractNumber("HTH202101010001");
        entity.setContractPrice(new BigDecimal("100"));
        entity.setContractWeight(new BigDecimal("300"));
        entity.setContractPayAmount(BigDecimal.ZERO);
        contractEntityMap.put(entity.getContractId(), entity);
    }

    @Override
    public int insertSelective(ContractEntity record) {
        contractEntityMap.put(record.getContractId(), record);
        return 1;
    }

    @Override
    public ContractEntity selectByPrimaryKey(String contractId) {
        return contractEntityMap.get(contractId);
    }

    @Override
    public int updateByPrimaryKeySelective(ContractEntity record) {
        contractEntityMap.put(record.getContractId(), record);
        return 1;
    }
}
