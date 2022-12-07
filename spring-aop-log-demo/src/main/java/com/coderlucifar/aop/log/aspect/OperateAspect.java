package com.coderlucifar.aop.log.aspect;

import com.alibaba.fastjson.JSON;
import com.coderlucifar.aop.log.Convert;
import com.coderlucifar.aop.log.entity.OperateLog;
import com.coderlucifar.aop.log.annotation.RecordOperate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class OperateAspect {

    @Pointcut("@annotation(com.coderlucifar.aop.log.annotation.RecordOperate)")
    public void pointCut() {}

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
      1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100)
    );

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 被织入方法执行并获取结果
        Object result = proceedingJoinPoint.proceed();

        // 起一个异步线程去记录操作日志，不影响主业务流程
        threadPoolExecutor.execute(() -> {
            try {
                // 获取方法签名
                MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
                // 获取目标方法，获取目标注解
                RecordOperate annotation = methodSignature.getMethod().getAnnotation(RecordOperate.class);
                // 获取注解中的Convert.class
                Class<? extends Convert> convert = annotation.convert();
                // 反射创建 Convert的实例
                Convert logConvert = convert.newInstance();
                // 调用参数转换方法，拿到切入方法的第一个入参作为参数传入（这里是假设目标入参在方法入参列表的第一个位置，可能并不适用于实际的业务场景）
                OperateLog operateLog = logConvert.convert(proceedingJoinPoint.getArgs()[0]);
                // 其他参数的设置
                operateLog.setDescription(annotation.desc());
                operateLog.setResult(result.toString());
//                operateLog.setOrderId();  // 这个参数可能在不同的业务实体类中是用不同的属性名称表示的，无法统一处理，如何解决这个问题？

                // 操作日志信息入库
                System.out.println("insert operateLog: " + JSON.toJSONString(operateLog));
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        // 返回结果
        return result;
    }

}
