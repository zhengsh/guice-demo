package cn.edu.cqvie.guice.service;

/**
 * @author ZAKJ_ASUS
 */
public interface PaymentService {
    void pay(long orderId, long price, Long sessionId);
}
