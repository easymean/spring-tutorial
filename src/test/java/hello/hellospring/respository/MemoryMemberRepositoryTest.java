package hello.hellospring.respository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트 한 개가 종료될 떄마다 실행되는
    @AfterEach
    public void afterEach(){
repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //Assertions.assertEquals(member, result); // org.junit.jupiter
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("hello");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hello2");
        repository.save(member2);

        Member result = repository.findByName("hello").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
