package cn.wolfcode.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    private MyTransaction myTransaction = new MyTransaction();

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
                ,target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        myTransaction.before();
        Object invoke = method.invoke(target, args);
        myTransaction.after();
        return invoke;
    }
}
