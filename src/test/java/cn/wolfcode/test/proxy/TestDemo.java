package cn.wolfcode.test.proxy;

import cn.wolfcode.test.classforname_classloader.Demo2;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestDemo {

    public static final List<String> LIST = Arrays.asList("AAA","BBB");

    @Test
    public void test() throws ClassNotFoundException {
        Class<?> clz = Thread.currentThread().getContextClassLoader().loadClass("cn.wolfcode.test.classforname_classloader.Demo2");
        //Class<?> aClass = Class.forName("cn.wolfcode.test.classforname_classloader.Demo2");
        Demo2.show();
        //MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new UserServiceImpl());
        //IUserService proxy = (IUserService) myInvocationHandler.getProxy();
        //proxy.save();
        //
        //LIST.set(1,"DDD");
        //
        //System.out.println(LIST);
    }
}


