package cn.moexc.ddd.domain.aggregate.contract;

public interface ContractRepository {

    ContractAR byId(String contractId);

    void save(ContractAR contractAR);
}
