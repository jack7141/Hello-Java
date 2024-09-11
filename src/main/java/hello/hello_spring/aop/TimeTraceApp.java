package hello.hello_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceApp {
//    SprintConfig에서 할려고 했는데, 의존성 순환이 되면서 오류가 발생하여 Compenet로 어노테이션으로 Spring이 스캔하도록 수정
    @Around("execution(* hello.hello_spring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long time = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            System.out.println("Time: " + (System.currentTimeMillis() - time));
        }
    }
}
