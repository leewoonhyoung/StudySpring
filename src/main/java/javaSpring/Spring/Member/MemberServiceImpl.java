package javaSpring.Spring.Member;

import javaSpring.Spring.Member.InterFace.MemberRepository;
import javaSpring.Spring.Member.InterFace.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Component;

@Component // componentScan시 @Bean으로 들록된 아이들을 모두다 올려준다.
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    @Autowired // 자동으로 memberRespository에 대한 의존관계 주입을 시켜준다. //ac.getBean(MemberRespository.class) 같은 역할
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //TEst용도

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
