package cn.edu.cqvie.guice.service.impl;

import cn.edu.cqvie.guice.service.PriceService;
import com.google.common.cache.Cache;
import com.google.inject.Inject;

import java.util.Set;

/**
 * @author ZAKJ_ASUS
 */
public class PriceServiceImpl implements PriceService {
    private final Cache<String, String> cache;
    private final Set<String> supportedCurrencies;

    @Inject
    public PriceServiceImpl(
            Set<String> supportedCurrencies,
            Cache<String, String> cache) {
        this.supportedCurrencies = supportedCurrencies;
        this.cache = cache;
    }

    @Override
    public long getPrice(long orderId) {
        //return 456L;
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<String> getSupportedCurrencies() {
        return this.supportedCurrencies;
        //return Arrays.asList("CNY", "USD", "EUR");
    }

    public String getCacheValue(String key) {
        return cache.getIfPresent(key);
    }
}
