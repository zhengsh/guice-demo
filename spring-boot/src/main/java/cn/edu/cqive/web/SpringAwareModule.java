package cn.edu.cqive.web;

import cn.edu.cqive.dao.SampleDao;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.springframework.context.ApplicationContext;

public class SpringAwareModule extends AbstractModule {

    private final ApplicationContext applicationContext;

    @Override
    protected void configure() {
        bind(ApplicationContext.class).toInstance(applicationContext);
    }

    public SpringAwareModule(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    SampleDao getSampleDao(ApplicationContext context) {
        return context.getBean(SampleDao.class);
    }
}
