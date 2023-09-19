package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LogProxy {

    @Before("execution(public int com.spring.aop.ArithmeticCalculator.*(int, int))")
    public void beforMethod(JoinPoint point){
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("调用前连接点方法为：" + methodName + ",参数为：" + args);
    }

    @After(("execution(public int com.spring.aop.ArithmeticCalculator.*(int, int))"))
    public void afterMethod(JoinPoint point){
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("调用后连接点方法为：" + methodName + ",参数为：" + args);
    }

    //通过returning属性指定连接点方法返回的结果放置在result变量中，
    //在返回通知方法中可以从result变量中获取连接点方法的返回结果了。
    @AfterReturning(value="execution(public int com.spring.aop.ArithmeticCalculator.*(int, int))",
            returning="result")
    public void afterReturning(JoinPoint point, Object result){
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("连接点方法为：" + methodName + ",参数为："
                + args + ",目标方法执行结果为：" + result);
    }

    //通过throwing属性指定连接点方法出现异常信息存储在ex变量中，
    //在异常通知方法中就可以从ex变量中获取异常信息了
    @AfterThrowing(value="execution(public int com.spring.aop.ArithmeticCalculator.*(int, int))",
            throwing="ex")
    public void afterReturning(JoinPoint point, Exception ex){
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("连接点方法为：" + methodName + ",参数为：" + args + ",异常为：" + ex);
    }

    /*@AfterThrowing(value="execution(public int com.spring.aop.ArithmeticCalculator.*(int, int))",
            throwing="ex")
    //只捕获连接点方法中的NullPointerException 类型的异常信息
    public void afterReturning(JoinPoint point, NullPointerException ex){
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("连接点方法为：" + methodName + ",参数为：" + args + ",异常为：" + ex);
    }*/


/*    @Around("execution(public int com.spring.aop.ArithmeticCalculator.*(int, int))")
    public Object aroundMethod(ProceedingJoinPoint pdj){
        *//*result为连接点的放回结果*//*
        Object result = null;
        String methodName = pdj.getSignature().getName();

        *//*前置通知方法*//*
        System.out.println("前置通知方法>目标方法名：" + methodName + ",参数为："
                + Arrays.asList(pdj.getArgs()));

        *//*执行目标方法*//*
        try {
            result = pdj.proceed();

            *//*返回通知方法*//*
            System.out.println("返回通知方法>目标方法名" + methodName + ",返回结果为：" + result);
        } catch (Throwable e) {
            *//*异常通知方法*//*
            System.out.println("异常通知方法>目标方法名" + methodName + ",异常为：" + e);
        }

        *//*后置通知*//*
        System.out.println("后置通知方法>目标方法名" + methodName);

        return result;
    }*/

    /*@Around("execution(public int com.spring.aop.ArithmeticCalculator.*(int, int))")
    public Object aroundMethod(ProceedingJoinPoint pdj){
        *//*result为连接点的放回结果*//*
        Object result = null;
        String methodName = pdj.getSignature().getName();

        *//*前置通知方法*//*
        System.out.println("前置通知方法>目标方法名：" + methodName + ",参数为："
                + Arrays.asList(pdj.getArgs()));

        *//*执行目标方法*//*
        try {
            result = pdj.proceed();

            *//*返回通知方法*//*
            System.out.println("返回通知方法>目标方法名" + methodName + ",返回结果为：" + result);
        } catch (Throwable e) {
            *//*异常通知方法*//*
            System.out.println("异常通知方法>目标方法名" + methodName + ",异常为：" + e);
            *//*当环绕通知方法本身还有其它异常时，非连接点方法出现的异常，此时抛出来*//*
            throw new RuntimeException();
        }

        *//*后置通知*//*
        System.out.println("后置通知方法>目标方法名" + methodName);

        return result;
    }*/

}



