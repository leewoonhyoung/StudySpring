package javaSpring.Spring.MYTEST;

public class StaticExample_Test {

    public static void main(String[] args){
        int a = StaticExample.a;
        int b = StaticExample.b;
        int result = StaticExample.multi(a, b);
        System.out.println("result = " + result);
    }
    class SuperClass{
        public final void work(){

        }
    }

    public class Sub extends SuperClass{
        // 위에 정의되어 SuperClass에 정의되어있는 work 메소드를 사용할수 없다.
    }

}
