package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEachTest() {
//        memberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("member");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("memberff");
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setName("membefuxkBitch");
        memberRepository.save(member2);


        Member result = memberRepository.findByName("memberff").get();
        Member result2 = memberRepository.findByName("membefuxkBitch").get();

        Assertions.assertEquals(result, member);
        Assertions.assertEquals(result2, member2);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("memberff");
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setName("membefuxkBitch");
        memberRepository.save(member2);

        Assertions.assertEquals(memberRepository.findAll().size(), 2);
    }
}
