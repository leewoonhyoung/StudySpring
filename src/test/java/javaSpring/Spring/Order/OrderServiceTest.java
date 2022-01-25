package javaSpring.Spring.Order;

import javaSpring.Spring.Member.Grade;
import javaSpring.Spring.Member.InterFace.MemberService;
import javaSpring.Spring.Member.Member;
import javaSpring.Spring.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
    }
//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder_Test(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

        Long memberId2 = 2L;
        Member member1 = new Member(memberId2, "memberB", Grade.BASIC);
        memberService.join(member);
        orderService.createOrder(memberId2, "itemB", 0);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(0);


    }



}