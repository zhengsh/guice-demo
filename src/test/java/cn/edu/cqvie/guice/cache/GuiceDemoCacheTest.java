package cn.edu.cqvie.guice.cache;

import cn.edu.cqvie.guice.service.PaymentService;
import cn.edu.cqvie.guice.service.ServiceModule;
import cn.edu.cqvie.guice.service.impl.PaymentServiceImpl;
import cn.edu.cqvie.guice.service.impl.PriceServiceImpl;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.Service;

import static org.junit.Assert.*;

public class GuiceDemoCacheTest {

    @Inject
    PaymentServiceImpl paymentService;
    @Inject
    PriceServiceImpl priceService;

    @Before
    public void setUp() {
        Guice.createInjector(new ServiceModule()).injectMembers(this);
    }

    @Test
    public void test() {
        paymentService.putCache("testKey", "testValue");
        String testValue = priceService.getCacheValue("testKey");
        assertEquals("testValue", testValue);
    }
}