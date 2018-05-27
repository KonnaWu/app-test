package cn.wolfcode.test.test;

import org.junit.Test;

import java.util.Scanner;

public class Demo {

    @Test
    public void test1() {
        int a = 10;
        int b = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < i + 1; j++) {
                b++;
            }
        }
        System.out.println(b);
    }

    @Test
    public void test2() {
        double n = 0;
        double x = 100;
        int z = 10;
        for (int m = 1; m < (z + 1); m++) {
            n = n + x * 2;
            x = x / 2;
            if (m == z) {
                System.out.println("第" + m + "次反弹高度为：" + x);
                System.out.println("第" + m + "次落地共经过为：" + (n - 100));
            }
        }
    }

    @Test
    public void test3() {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        System.out.println(next);
        if ("abc".equals(next)) {
        }
    }

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String next = sc.next();
            if ("abc".equals(next)) {
                throw new RuntimeException();
            }
        }
    }
}
