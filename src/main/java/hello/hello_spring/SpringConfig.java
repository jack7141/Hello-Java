package hello.hello_spring;

import hello.hello_spring.aop.TimeTraceApp;
import hello.hello_spring.repository.JPAMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

      private final MemberRepository memberRepository;

      @Autowired
      public SpringConfig(MemberRepository memberRepository) {
          this.memberRepository = memberRepository;
      }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

}
