package javaSpring.Spring.Member;

import javaSpring.Spring.Member.InterFace.MemberService;
import javaSpring.Spring.Order.AppConfig;

public class MemberApp {
    public static void main(String[] args){

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

//        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("findMember = " + member.getName());
        System.out.println("newMember = " + findMember.getName());
    }
}
