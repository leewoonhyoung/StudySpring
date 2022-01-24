package javaSpring.Spring.Member;

import javaSpring.Spring.Member.InterFace.MemberRepository;
import javaSpring.Spring.Member.InterFace.MemberService;

public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
