package cn.edu.cqvie.guice.service.impl;

import cn.edu.cqvie.guice.annotaion.Logged;
import cn.edu.cqvie.guice.service.PaymentService;
import com.google.common.cache.Cache;
import com.google.inject.Inject;

/**
 * @author ZAKJ_ASUS
 */
public class PaymentServiceImpl implements PaymentService {

    private final Cache<String, String> cache;

    @Inject
    public PaymentServiceImpl(Cache<String, String> cache) {
        this.cache = cache;
    }

    @Override
    @Logged
    public void pay(long orderId, long price, Long sessionId) {

    }

    public void putCache(String key, String value) {
        cache.put(key, value);
    }
}
