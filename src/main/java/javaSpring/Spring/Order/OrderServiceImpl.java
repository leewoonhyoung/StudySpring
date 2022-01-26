package javaSpring.Spring.Order;

import javaSpring.Spring.Discount.DiscountPolicy;
import javaSpring.Spring.Discount.FixDiscountPolicy;
import javaSpring.Spring.Member.InterFace.MemberRepository;
import javaSpring.Spring.Member.Member;
import javaSpring.Spring.Member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
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
}
