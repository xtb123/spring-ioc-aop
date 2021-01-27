package cn.com.taiji.spring.service;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

public class CglibMethodProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Date start=new Date();
        System.out.println("Cglib before");
//        method.getName();
        methodProxy.invokeSuper(target,args);

        Date end=new Date();
        System.out.println("Cglib after");
        System.out.println("执行时间："+(end.getTime()-start.getTime()));
        return null;
    }
}
