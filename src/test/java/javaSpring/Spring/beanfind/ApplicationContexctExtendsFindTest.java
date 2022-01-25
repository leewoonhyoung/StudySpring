package javaSpring.Spring.beanfind;

import javaSpring.Spring.Discount.DiscountPolicy;
import javaSpring.Spring.Discount.FixDiscountPolicy;
import javaSpring.Spring.Discount.RateDiscountPolicy;
import javaSpring.Spring.Order.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContexctExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
//    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Configuration
    public static class TestConfig{

        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 중복 오류가 발생한다.")
    public void findBeanByParentTypeDuplication(){
//        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class ,() -> ac.getBean(DiscountPolicy.class));
    }
}
