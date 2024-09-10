package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class MemberServiceINTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    @Commit
    void join() {
        //given
        Member member = new Member();
        member.setName("ho!!!!@!!");

        //when
        Long newMember = memberService.join(member);

        //then
        Member findMember = memberService.findMemberId(newMember).get();
        Assertions.assertEquals(member, findMember);
    }

    @Test
    void DuplicateMember() {
        //given
        Member member = new Member();
        member.setName("test");

        Member member1 = new Member();
        member1.setName("test");

        //when
        memberService.join(member);
        assertThrows(IllegalStateException.class, () -> memberService.join(member1)); // 1번 방법

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1)); // 2번 방법
        assertTrue(e.getMessage().contains("Member name is already in use"));
        //then
//        Assertions.assertEquals(member, findMember);
    }

    @Test
    void findMember() {
    }
}