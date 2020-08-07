package cn.edu.cqvie.guice.service.impl;

import cn.edu.cqvie.guice.annotaion.Logged;
import cn.edu.cqvie.guice.service.OrderService;
import cn.edu.cqvie.guice.service.PaymentService;
import cn.edu.cqvie.guice.service.PriceService;
import com.google.inject.Inject;

/**
 * @author ZAKJ_ASUS
 */
public class OrderServiceImpl implements OrderService {

    @Inject
    private PriceService priceService;
    @Inject
    private PaymentService paymentService;
    @Inject
    private SessionManager sessionManager;

    private Long ordersPaid = 0L;


    @Override
    @Logged
    public void sendToPayment(long orderId) throws RuntimeException {
        long price = priceService.getPrice(orderId);
        paymentService.pay(orderId, price, sessionManager.getSessionId());
        ordersPaid = ordersPaid + 1;
        throw new RuntimeException("Price=" + price + "SessionId=" + sessionManager.getSessionId() + ",orderPaid=" + ordersPaid);
    }
}
