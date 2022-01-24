package javaSpring.Spring.Order;

import javaSpring.Spring.Member.Grade;
import javaSpring.Spring.Member.InterFace.MemberService;
import javaSpring.Spring.Member.Member;
import javaSpring.Spring.Member.MemberServiceImpl;

public class OrderApp {


    public static void main(String[] args){

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
