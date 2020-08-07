package cn.edu.cqvie.guice.service;

import java.util.List;
import java.util.Set;

/**
 * @author ZAKJ_ASUS
 */
public interface PriceService {
    long getPrice(long orderId);

    Set<String> getSupportedCurrencies();
}
