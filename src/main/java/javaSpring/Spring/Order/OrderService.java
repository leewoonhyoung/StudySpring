package javaSpring.Spring.Order;

import org.springframework.stereotype.Service;


public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
