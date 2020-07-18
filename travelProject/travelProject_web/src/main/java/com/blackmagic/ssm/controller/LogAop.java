package com.blackmagic.ssm.controller;

import com.blackmagic.ssm.domain.SysLog;
import com.blackmagic.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

import static javax.management.Query.value;

@Controller
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;
    private Date visitTime;
    private Class clazz;
    private Method method;

    //前置通知
    @Before("execution(* com.blackmagic.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
    visitTime=new Date();
    clazz=joinPoint.getTarget().getClass();
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        if (args==null || args.length==0){
            method=clazz.getMethod(name);
        }else {
            Class[] classes = new Class[args.length];
            for (int i=0;i<args.length;i++){
                classes[i]=args[i].getClass();
            }

        }
    }
    @After("execution(* com.blackmagic.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        long time =new Date().getTime() - visitTime.getTime();
    String url= "";
    if (clazz!=null&&method!=null&&clazz!=LogAop.class){
        RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
        if (clazzAnnotation!=null){
            String[] value = clazzAnnotation.value();

            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            if (methodAnnotation!=null){
                String[] methodValue = methodAnnotation.value();
                url = value[0] + methodValue[0];
                String ip=request.getRemoteAddr();

                SecurityContext context = SecurityContextHolder.getContext();
                User user = (User) context.getAuthentication().getPrincipal();
                String username=user.getUsername();
                SysLog sysLog = new SysLog();
                sysLog.setIp(ip);
                sysLog.setIp(ip);
                sysLog.setExecutionTime(time);
                sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
                sysLog.setUrl(url);
                sysLog.setUsername(username);
                sysLog.setVisitTime(visitTime);
                if (clazz.getName()!="com.blackamgic.ssm.controller.SysLogController"){
                    sysLogService.save(sysLog);
                }

            }
        }
    }


    }
}
