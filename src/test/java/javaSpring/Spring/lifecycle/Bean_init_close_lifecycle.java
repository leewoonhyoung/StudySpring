package javaSpring.Spring.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Bean_init_close_lifecycle {

    private String url;


    public Bean_init_close_lifecycle(){
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url){
        this.url =url;
    }
    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect = " + url);
    }

    public void call(String message){
        System.out.println("call = " + url +  "message = " + message);
    }
    //서비스 종료시 호출

    public void disconnect(){
        System.out.println("close = " + url);

    }

    public void init()   {
        System.out.println("Bean_init_close_lifecycle.init");
        connect();
        call("초기화 연결 메세지");

    }


    public void close()   {
        System.out.println("Bean_init_close_lifecycle.close");
        disconnect();

    }


}
