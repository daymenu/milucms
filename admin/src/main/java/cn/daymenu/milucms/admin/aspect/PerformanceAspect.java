package cn.daymenu.milucms.admin.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    @Around("serverOps()")
    public Object logPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        String name = "-";
        String result = "Y";
        try {
            name = pjp.getSignature().toShortString();
            return pjp.proceed();
        } catch (Throwable t) {
            result = "N";
            throw t;
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("aop-milucms: {};{};{} ms", name, result, endTime-startTime);
        }
    }

    //execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
    // (param-pattern) () 匹配不带参数的方法 (..) 匹配任意参数的方法 (*) 匹配一个任何类型的方法 (*, String) 匹配接受两个参数的方法，一个是任意类型，一个是String
    @Pointcut("execution(* cn.daymenu.milucms.admin.service.impl.*.*(..))")
    private  void serverOps() {
        // Do nothing because this is pointcut.
    }

    @Before("serverOps()")
    public void addStart() {
        log.info("aop-milucms start");
    }

    @After("serverOps()")
    public void addEnd() {
        log.info("aop-milucms end");
    }
}
