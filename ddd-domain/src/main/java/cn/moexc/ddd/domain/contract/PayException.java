package cn.moexc.ddd.domain.contract;

public class PayException extends RuntimeException{
    public PayException(String message) {
        super(message);
    }
}
