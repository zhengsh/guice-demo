package cn.edu.cqvie.guice.service.impl;

import cn.edu.cqvie.guice.service.OrderService;
import cn.edu.cqvie.guice.service.PriceService;
import cn.edu.cqvie.guice.service.ServiceModule;
import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.inject.util.Modules;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;


class PriceServiceMock extends PriceServiceImpl {

    @Inject
    public PriceServiceMock(Set<String> supportedCurrencies, Cache<String, String> cache) {
        super(supportedCurrencies, cache);
    }

    @Override
    public long getPrice(long orderId) {
        return 467L;
    }
}

public class OrderServiceImplTest {

    @Inject
    private OrderService orderService;
    @Inject
    private PriceService priceService;
//    @Inject
//    @Named("supportedCurrencies")
//    private List<String> supportedCurrencies;

    @Before
    public void setUp() {
        Guice.createInjector(Modules.override(new ServiceModule()).with(new AbstractModule() {
            @Override
            protected void configure() {
                bind(PriceService.class).to(PriceServiceMock.class);
            }
        })).injectMembers(this);
    }

    @Test
    public void sendToPayment() {
        orderService.sendToPayment(789L);
    }

    @Test
    public void testSupportedCurrencies() {
        throw new RuntimeException(
                priceService.getSupportedCurrencies().toString());
    }
}
