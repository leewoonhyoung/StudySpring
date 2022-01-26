package javaSpring.Spring.MYTEST;

public class UsedStaticExample {

    public static void main(String[] args){
        int a = StaticExample.circle_dot;
        int b = StaticExample.square_dot;
        int result = StaticExample.multi(a, b);
        System.out.println("result = " + result);
    }

}
