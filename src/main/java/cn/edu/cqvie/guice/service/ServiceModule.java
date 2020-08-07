package cn.edu.cqvie.guice.service;

import cn.edu.cqvie.guice.annotaion.Logged;
import cn.edu.cqvie.guice.annotaion.SessionId;
import cn.edu.cqvie.guice.cache.GuiceDemoCache;
import cn.edu.cqvie.guice.interceptor.LoggerInterceptor;
import cn.edu.cqvie.guice.service.impl.OrderServiceImpl;
import cn.edu.cqvie.guice.service.impl.PaymentServiceImpl;
import cn.edu.cqvie.guice.service.impl.PriceServiceImpl;
import com.google.common.base.Joiner;
import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.google.inject.spi.TypeListener;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author ZAKJ_ASUS
 */
public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ChinaModule());
        install(new GlobalModule());

        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);

        bind(new TypeLiteral<Cache<String, String>>() {}).to(GuiceDemoCache.class);
        //.in(Singleton.class);

        LoggerInterceptor loggerInterceptor = new LoggerInterceptor();
        requestInjection(loggerInterceptor);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Logged.class), loggerInterceptor);

//        bind(Long.class).annotatedWith(SessionId.class)
//                .toInstance(System.currentTimeMillis());
//        bind(Long.class).annotatedWith(Names.named("appId"))
//                .toInstance(456L);

//        bind(new TypeLiteral<List<String>>() {})
//                .annotatedWith(Names.named("supportedCurrencies"))
//                .toInstance(Arrays.asList("CNY", "EUR", "USD"));
    }

    @Provides
    @SessionId
    Long generateSessionId() {
        return System.currentTimeMillis();
    }

    @Provides
    @Named("supportedCurrencies")
    Set<String> getSupportCurrencies(PriceService priceService) {
        return priceService.getSupportedCurrencies();
    }

//    @Provides @Singleton Cache<String, String> getCache() {
//        return new GuiceDemoCache();
//    }
}
