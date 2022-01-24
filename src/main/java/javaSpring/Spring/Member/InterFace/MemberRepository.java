package javaSpring.Spring.Member.InterFace;

import javaSpring.Spring.Member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
