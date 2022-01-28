package javaSpring.Spring.Order;

import javaSpring.Spring.Discount.DiscountPolicy;
import javaSpring.Spring.Member.InterFace.MemberRepository;
import javaSpring.Spring.Member.Member;
import javaSpring.Spring.Member.MemoryMemberRepository;
import javaSpring.Spring.annotation.MainDiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
//@RequiredArgsConstructor // final 붙은 녀석  생성자 만들어줌
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired //ac.getBean(DiscountPolicy.class 와 유사한 기능)
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
    //TEST용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


    //    //Test setter @Autowired 주입
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;
//
//    public OrderServiceImpl() {
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//////Test code전용 Sample끝


    //@RequiredArgsConstructor로 대체됨
//    @Autowired//ac.getBean(DiscountPolicy.class 와 유사한 기능)
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = rateDiscountPolicy;
//    }


}
