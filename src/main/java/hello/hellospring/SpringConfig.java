package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /**
     * annotation(컴포넌트 스캔)을 사용하지 않고 spring bean을 등록합니다.
     * <p>
     * 장점: 구현 클래스 변경이 쉽다.
     * 컴포넌트 스캔을 사용할 경우 구현 클래스 변경이 어렵다.
     */


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();

        // 새로운 repository 등록 가능
    }
}
