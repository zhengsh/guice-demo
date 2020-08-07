package cn.edu.cqvie.guice.cache;

import com.google.common.cache.AbstractCache;
import com.google.inject.Singleton;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZAKJ_ASUS
 */
@Singleton
public class GuiceDemoCache extends AbstractCache<String, String> {

    private final Map<String, String> keyValues = new ConcurrentHashMap<>(1 << 4);

    @NullableDecl
    @Override
    public String getIfPresent(Object key) {
        return keyValues.get(key);
    }

    @Override
    public void put(String key, String value) {
        keyValues.put(key, value);
    }
}
