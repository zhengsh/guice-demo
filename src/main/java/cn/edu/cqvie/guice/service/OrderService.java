package cn.edu.cqvie.guice.service;

/**
 * @author ZAKJ_ASUS
 */
public interface OrderService {

    void sendToPayment(long orderId) throws RuntimeException;
}
