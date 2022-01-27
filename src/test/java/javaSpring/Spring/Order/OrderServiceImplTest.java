package javaSpring.Spring.Order;

import javaSpring.Spring.Discount.FixDiscountPolicy;
import javaSpring.Spring.Member.Grade;
import javaSpring.Spring.Member.Member;
import javaSpring.Spring.Member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);

    }

}