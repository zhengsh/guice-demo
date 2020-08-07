package cn.edu.cqvie.guice.service.impl;

import cn.edu.cqvie.guice.annotaion.SessionId;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author ZAKJ_ASUS
 */
public class SessionManager {

    private final Provider<Long> sessionIdProvider;

    @Inject
    public SessionManager(@SessionId Provider<Long> sessionIdProvider) {
        this.sessionIdProvider = sessionIdProvider;
    }


    public Long getSessionId() {
        return this.sessionIdProvider.get();
    }
}
