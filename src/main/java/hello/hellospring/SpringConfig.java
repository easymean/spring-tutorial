package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    /**
     * annotation(컴포넌트 스캔)을 사용하지 않고 spring bean을 등록합니다.
     * <p>
     * 장점: 구현 클래스 변경이 쉽다.
     * 컴포넌트 스캔을 사용할 경우 구현 클래스 변경이 어렵다.
     */

    private final MemberRepository memberRepository;

    private DataSource dataSource;
    private EntityManager em;


    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository) {
        this.dataSource = dataSource;
        this.em = em;
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
    // 새로운 repository 등록 가능
//   }
}
