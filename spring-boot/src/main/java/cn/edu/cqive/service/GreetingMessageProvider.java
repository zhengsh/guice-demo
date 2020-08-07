package cn.edu.cqive.service;

import cn.edu.cqive.dao.SampleDao;
import cn.edu.cqive.web.RequestParams;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class GreetingMessageProvider implements Provider<String> {

    private final RequestParams params;
    private final SampleDao dao;

    @Inject
    public GreetingMessageProvider(RequestParams params, SampleDao dao) {
        this.params = params;
        this.dao = dao;
    }

    @Override
    public String get() {
        String name = params.getGreetingName();
        dao.getPersonData(name);
        return "Hello " + name;
    }
}
