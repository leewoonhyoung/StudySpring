package javaSpring.Spring.Order;

import javaSpring.Spring.Discount.DiscountPolicy;
import javaSpring.Spring.Discount.FixDiscountPolicy;
import javaSpring.Spring.Member.InterFace.MemberRepository;
import javaSpring.Spring.Member.InterFace.MemberService;
import javaSpring.Spring.Member.MemberServiceImpl;
import javaSpring.Spring.Member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {



//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
    @Bean
    public MemberService memberService(){
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }


    @Bean
    public OrderService orderService(){
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        System.out.println("Call AppConfig.discountPolicy");
        return new FixDiscountPolicy();
    }
}
