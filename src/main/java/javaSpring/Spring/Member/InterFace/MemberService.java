package javaSpring.Spring.Member.InterFace;

import javaSpring.Spring.Member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
