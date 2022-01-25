package javaSpring.Spring.Member;

import javaSpring.Spring.Member.InterFace.MemberService;
import javaSpring.Spring.Order.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

//        자바 객체 설계
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
    //DIP 위반 OCP 위반
//        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("findMember = " + member.getName());
        System.out.println("newMember = " + findMember.getName());
    }
}
