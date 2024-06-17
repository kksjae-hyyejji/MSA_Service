package shop.msa.user.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // Define the pointcut
    @Pointcut("execution(* shop.msa.user..*(..))")
    private void logPointCut() {}

    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}

    @Before("logPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Entering: {}.{} with arguments: {}", className, methodName, Arrays.toString(args));
    }

    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("Exiting: {}.{}", className, methodName);
    }

    @AfterThrowing(pointcut = "allService()")
    public void logAfterThrowing(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.error("-------->Exception: {}.{} with arguments: {} ", className, methodName, Arrays.toString(args));
    }
}
