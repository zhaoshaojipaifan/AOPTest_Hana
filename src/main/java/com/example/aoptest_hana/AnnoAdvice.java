package com.example.aoptest_hana;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
@Aspect
public class AnnoAdvice {
    //切点
    @Pointcut("execution( * com.example.aoptest_hana.UserDaoImpl.*(..))")
    public void poincut(){
    }
    @Before("poincut()")
    public void before(JoinPoint joinPoint){
        System.out.print("前置");
        System.out.println("目标类是："+joinPoint.getTarget());
        System.out.println("被织入增强处理的目标方法为："+
                joinPoint.getSignature().getName());
    }
    @AfterReturning("poincut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.print("返回");
        System.out.println("被织入增强处理的目标方法为："+
                joinPoint.getSignature().getName());
    }
    @Around("poincut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        System.out.println("这是环绕通知之前的部分");
        Object object = point.proceed();
        System.out.println("这是环绕通知之后的部分");
        return object;
    }
    @AfterThrowing("poincut()")
    public void afterException(){
        System.out.println("异常通知");
    }
    @After("poincut()")
    public void after(){
        System.out.println("后置");
    }
}