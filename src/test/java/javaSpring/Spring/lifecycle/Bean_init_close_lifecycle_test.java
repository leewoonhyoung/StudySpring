package javaSpring.Spring.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Bean_init_close_lifecycle_test {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(BeanLifeCycleTest.LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();


    }

    @Configuration
    static class LifeCycleConfig{

        @Bean(initMethod = "init", destroyMethod = "close")
        public Bean_init_close_lifecycle beanInitCloseLifecycle(){
            Bean_init_close_lifecycle bean_init_close_lifecycle = new Bean_init_close_lifecycle();
            bean_init_close_lifecycle.setUrl("https://hello-spring.dev");
            return bean_init_close_lifecycle;
        }

    }
}
