package javaSpring.Spring.Discount;

import javaSpring.Spring.Member.Member;

public interface DiscountPolicy {

    /**
     * @return이 할인 대상금액
     */

    int discount(Member member, int price);
}
