package javaSpring.Spring.Order;

import javaSpring.Spring.Discount.DiscountPolicy;
import javaSpring.Spring.Discount.FixDiscountPolicy;
import javaSpring.Spring.Member.InterFace.MemberRepository;
import javaSpring.Spring.Member.InterFace.MemberService;
import javaSpring.Spring.Member.MemberServiceImpl;
import javaSpring.Spring.Member.MemoryMemberRepository;

public class AppConfig {



//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }



    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
