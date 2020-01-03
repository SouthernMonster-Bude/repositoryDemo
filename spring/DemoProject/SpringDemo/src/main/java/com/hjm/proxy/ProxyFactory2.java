package com.hjm.proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class ProxyFactory2 {
    //维护目标对象
    private static Object target;
    //维护关键点代码的类
    private static AOP aop;

    public static Object getProxyInstance(Object target_, AOP aop_) {
        //目标对象和关键点代码的类都是通过外界传递进来
        target = target_;
        aop = aop_;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aop.begin();
                        Object returnValue = method.invoke(target, args);
                        aop.close();
                        return returnValue;
                    }
                }
        );
    }
}
