package javaSpring.Spring.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class prototypeTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);


        System.out.println("find prototypeBean1");
        prototypeBean prototypeBean1 = ac.getBean(prototypeBean.class);
        System.out.println("find prototypeBean2");
        prototypeBean prototypeBean2 = ac.getBean(prototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean1 = " + prototypeBean2);

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();
    }

    @Scope("prototype")
    @Component
    static class prototypeBean{

        @PostConstruct
        public void init(){
            System.out.println("prototypeBean.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("prototypeBean.destory");
        }

    }
}
