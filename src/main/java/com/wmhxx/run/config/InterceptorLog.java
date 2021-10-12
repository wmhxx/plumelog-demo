package com.wmhxx.run.config;

import com.plumelog.core.TraceId;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 日志拦截器
 *
 * @author :WangMengHe
 * @since :2021-10-12 09:49
 **/
@Component
public class InterceptorLog implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //设置TraceID值，不埋此点链路ID就没有
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        TraceId.logTraceID.set(uuid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

}
