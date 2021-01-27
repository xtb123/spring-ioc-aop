package cn.com.taiji.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

//    @Pointcut("execution(* cn.com.taiji.spring.UserService.*(..))")
    //@Pointcut("execution(* cn.com.taiji.spring.UserDao.*(..))")
    @Pointcut("@annotation(cn.com.taiji.spring.Transaction)")
    public void pointCut(){

    }

   // @Around("pointCut()") //一种方式
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
////        System.out.println("aspect before");
////        joinPoint.proceed(joinPoint.getArgs());
////        System.out.println("aspect after");
//
//        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
//        Transaction transaction=methodSignature.getMethod().getAnnotation(Transaction.class);
//        if(transaction!=null){
//            System.out.println(transaction.propagate());
//        }
//
//        System.out.println("begin transaction");
//        joinPoint.proceed(joinPoint.getArgs());
//        System.out.println("after transaction");
//    }

    /**
     * 获取注解还可以这么写，简化方式
     * @param joinPoint
     * @param transaction
     * @throws Throwable
     */
    @Around("pointCut() && @annotation(transaction)")
    public void around(ProceedingJoinPoint joinPoint,Transaction transaction) throws Throwable {
        System.out.println(transaction.propagate());

        System.out.println("begin1 transaction");
        joinPoint.proceed(joinPoint.getArgs());
        System.out.println("after1 transaction");
    }
}
