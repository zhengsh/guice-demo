package cn.edu.cqvie.guice.service;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * @author ZAKJ_ASUS
 */
public class ChinaModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder.newSetBinder(binder(), String.class)
                .addBinding().toInstance("CNY");
    }
}
