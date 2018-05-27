package cn.wolfcode.test.test;

import org.junit.Test;

import java.util.LinkedList;

public class Stack {

    private LinkedList<Object> list = new LinkedList<>();

    public void add(Object object){
        list.addLast(object);
    }

    public void get(){
        list.getLast();
    }

    public void del(){
        list.pollLast();
    }

    public static void main(String[] args) {

    }
}
