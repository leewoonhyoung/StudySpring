package javaSpring.Spring.Member;

import javaSpring.Spring.Member.InterFace.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
//repositoryDao
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // Concurernt hashmap을 사용하자.
    private static final Long sequence =0L;

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
