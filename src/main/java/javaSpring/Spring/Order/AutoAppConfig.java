package javaSpring.Spring.Order;


import javaSpring.Spring.Discount.DiscountPolicy;
import javaSpring.Spring.Discount.RateDiscountPolicy;
import javaSpring.Spring.Member.InterFace.MemberRepository;
import javaSpring.Spring.Member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

public class AutoAppConfig {

//    @Autowired
//    MemberRepository memberRepository;
//    @Autowired
//    DiscountPolicy discountPolicy;
//
//

    @Bean
    OrderService orderService(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy){
        return new OrderServiceImpl(memberRepository, rateDiscountPolicy);
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }


// ComponentScan 충돌 TEst
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

}
