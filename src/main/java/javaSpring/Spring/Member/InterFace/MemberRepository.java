package javaSpring.Spring.Member.InterFace;

import javaSpring.Spring.Member.Member;
import org.springframework.stereotype.Repository;


public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
