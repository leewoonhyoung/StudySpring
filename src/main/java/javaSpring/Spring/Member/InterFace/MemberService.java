package javaSpring.Spring.Member.InterFace;

import javaSpring.Spring.Member.Member;
import org.springframework.stereotype.Service;


public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
