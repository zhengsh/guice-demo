package cn.edu.cqive.controller;

import cn.edu.cqive.persistence.SampleDao;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import org.springframework.context.ApplicationContext;

/**
 * @author ZAKJ_ASUS
 */
public class SpringAwareServletModule extends AbstractModule {

    private final ApplicationContext applicationContext;

    @Override
    protected void configure() {
        install(new ServletModule());
        bind(ApplicationContext.class).toInstance(applicationContext);
    }

    public SpringAwareServletModule(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    SampleDao getSampleDao(ApplicationContext context) {
        return context.getBean(SampleDao.class);
    }
}
