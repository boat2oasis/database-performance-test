package com.service.mall.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {
	@Pointcut("@annotation(com.service.mall.annotate.Log)")
	public void logPointCut() {
		
		
	}
	
	@Before("logPointCut()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("这里是切面================HELLO WORLD");

        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        // 打印前端请求信息
        System.out.println("=== 开始 ===");
        System.out.println("请求地址: {} {}"+request.getRequestURL().toString()+","+request.getMethod());
        System.out.println("类名方法: {}.{}"+signature.getDeclaringTypeName()+""+name);
        System.out.println("远程地址: {}"+request.getRemoteAddr());

        // 打印请求参数
        Object[] args = joinPoint.getArgs();

        Object[] arguments  = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest
                    || args[i] instanceof ServletResponse
                    || args[i] instanceof MultipartFile) {
                continue;
            }
            arguments[i] = args[i];
        }
        //System.out.println("请求的参数: {}", JSON.toJSONString(arguments));
	}
}
