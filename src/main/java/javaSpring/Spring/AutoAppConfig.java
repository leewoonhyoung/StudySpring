package javaSpring.Spring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


//Configuration으로 싱글톤화 시킨 후에 @ComponentScan 으로 @component된 녀석들을 다 흡수, 흡수된 애들은 Bean으로 변하게 된다.
@Configuration
@ComponentScan(
      excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Autowired
//    MemberRepository memberRepository;
//    @Autowired
//    DiscountPolicy discountPolicy;




// ComponentScan 충돌 TEst
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

}
