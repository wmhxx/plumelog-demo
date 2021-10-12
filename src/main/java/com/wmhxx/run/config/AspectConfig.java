package com.wmhxx.run.config;

import com.plumelog.core.TraceId;
import com.plumelog.trace.aspect.AbstractAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author :WangMengHe
 * @since :2021-10-12 09:27
 **/
@Aspect
@Component
public class AspectConfig extends AbstractAspect {

    /**
     * 代理方面 拦截@Scheduled注解
     */
    @Pointcut(" @annotation(org.springframework.scheduling.annotation.Scheduled)")
    public void proxyAspect() {

    }

    /**
     * 周围
     *
     * @param joinPoint 连接点
     * @return {@link Object}
     * @throws Throwable throwable
     */
    @Around("within(com.wmhxx..*))")
    public Object around(JoinPoint joinPoint) throws Throwable {
        return aroundExecute(joinPoint);
    }

    /**
     * 拦截不到private方法
     *
     * @param joinPoint 连接点
     * @return {@link Object}
     * @throws Throwable throwable
     */
    @Around("proxyAspect()")
    public Object doInvoke(ProceedingJoinPoint joinPoint) throws Throwable {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        TraceId.logTraceID.set(uuid);
        return aroundExecute(joinPoint);
    }
}
