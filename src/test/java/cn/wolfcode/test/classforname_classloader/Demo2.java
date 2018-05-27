package cn.wolfcode.test.classforname_classloader;

public class Demo2 {
    static {
        System.out.println("static block");
    }

    public static void show(){
        System.out.println("static method");
    }
}
