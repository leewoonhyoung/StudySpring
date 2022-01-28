package javaSpring.Spring.scan;

import javaSpring.Spring.Member.InterFace.MemberRepository;
import javaSpring.Spring.Member.InterFace.MemberService;
import javaSpring.Spring.Order.AutoAppConfig;
import javaSpring.Spring.Order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();

        System.out.println("memberRepository = " + memberRepository);

    }
}
