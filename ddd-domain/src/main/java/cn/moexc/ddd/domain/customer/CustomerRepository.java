package cn.moexc.ddd.domain.customer;

public interface CustomerRepository {
    Customer byId(String id);
    void save(Customer customer);
}
