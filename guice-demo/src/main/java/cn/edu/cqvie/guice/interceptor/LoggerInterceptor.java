package cn.edu.cqvie.guice.interceptor;

import cn.edu.cqvie.guice.annotaion.SessionId;
import com.google.common.base.Joiner;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author ZAKJ_ASUS
 */
public class LoggerInterceptor implements MethodInterceptor {

    @Inject
    @SessionId
    private Provider<Long> sessionIdProvider;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Method method = methodInvocation.getMethod();
        System.out.println(String.format("In SessionId %d: Calling %s#%s(%s)",
                sessionIdProvider.get(),
                method.getDeclaringClass(),
                method.getName(),
                Joiner.on(",").join(methodInvocation.getArguments())));
        return methodInvocation.proceed();
    }
}
