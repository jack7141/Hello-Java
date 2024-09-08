package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberService();

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("test");

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
        memberService.join(member1);
        //then
    }

    @Test
    void findMember() {
    }
}