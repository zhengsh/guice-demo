package cn.edu.cqvie.guice.service.impl;

import cn.edu.cqvie.guice.service.ServiceModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionManagerTest {

    @Inject
    private SessionManager sessionManager;

    @Before
    public void setUp() {
        Guice.createInjector(new ServiceModule()).injectMembers(this);
    }

    @Test
    public void getSessionId() throws InterruptedException {
        Long sessionId1 = sessionManager.getSessionId();
        System.out.println(sessionId1);
        Thread.sleep(1000);
        Long sessionId2 = sessionManager.getSessionId();
        assertNotEquals(sessionId1, sessionId2);
    }
}