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
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
