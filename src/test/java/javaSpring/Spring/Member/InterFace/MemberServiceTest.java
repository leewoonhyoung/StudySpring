package javaSpring.Spring.Member.InterFace;

import javaSpring.Spring.Member.Grade;
import javaSpring.Spring.Member.Member;
import javaSpring.Spring.Member.MemberServiceImpl;
import javaSpring.Spring.Order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService;

//    AppConfig appConfig = new AppConfig();
//    MemberService memberService;

    @BeforeEach
    public void beforeEach(){

        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given

        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

        }


}