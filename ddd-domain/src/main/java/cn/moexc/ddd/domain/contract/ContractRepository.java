package cn.moexc.ddd.domain.contract;

public interface ContractRepository {

    ContractAR byId(String contractId);

    void save(ContractAR contractAR);
}
