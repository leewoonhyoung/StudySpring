package javaSpring.Spring.Member;

import javaSpring.Spring.Member.InterFace.MemberService;

public class MemberApp {
    public static void main(String[] args){

        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("findMember = " + member.getName());
        System.out.println("newMember = " + findMember.getName());
    }
}
