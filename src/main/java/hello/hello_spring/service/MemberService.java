package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
//    command + shift + T => 테스트파일 자동 생성
    private final MemberRepository memberRepository;

    //    DI = 의존성 주입 시작
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        validateDuplicateUserName(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateUserName(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("Member name is already in use");
        });
    }


    /**
     * 회원 List
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }


    /**
     * 회원 조회 retrive
     * @param id
     * @return
     */
    public Optional<Member> findMemberId(Long id) {
        return memberRepository.findById(id);
    }

}
