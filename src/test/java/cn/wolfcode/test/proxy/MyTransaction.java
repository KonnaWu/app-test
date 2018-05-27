package cn.wolfcode.test.proxy;

public class MyTransaction {

    public void before(){
        System.out.println("before=================");
    }

    public void after(){
        System.out.println("after=================");
    }
}
