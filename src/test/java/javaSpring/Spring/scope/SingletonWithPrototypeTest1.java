package javaSpring.Spring.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addcount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addcount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

    }

    @Test
    @DisplayName("싱글톤 내부에 프로토 타입 빈이 있다면?")
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isNotEqualTo(1);

    }
    @Scope("singleton") // 싱글톤 내부에 프로토타입 빈이 주입되면 bean 생성시 프로토타입의 bean을 계속해서 사용하게 된다.
    static class ClientBean{

        private final PrototypeBean prototypeBean; // 생성시점에 주입된다.

        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic(){
            prototypeBean.addcount();
            int count = prototypeBean.getCount();
            return count;

        }
    }



    @Scope("prototype")
    static class PrototypeBean{
        private int count = 0;

        public void addcount(){
            count = count + 1;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init" + this.count);

        }
        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy" + this.count);
        }
    }


}
