package com.jxau.hotelsystem.config;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/11 16:29
 */

import com.alibaba.fastjson.JSON;

import com.jxau.hotelsystem.annotation.MyLog;
import com.jxau.hotelsystem.pojo.DO.ZpSysLog;
import com.jxau.hotelsystem.service.SysLogService;
import com.jxau.hotelsystem.utils.GetDateUtil;
import com.jxau.hotelsystem.utils.HttpContextUtil;
import com.jxau.hotelsystem.utils.IPUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysLogService sysLogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.jxau.hotelsystem.annotation.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        //保存日志
        ZpSysLog zpSysLog = new ZpSysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            zpSysLog.setLoggerOperation(value);//保存获取的操作
        }
        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        zpSysLog.setLoggerMethod(className + "." + methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        if(params.length()>1000){
            zpSysLog.setLoggerParams(params.substring(0,100));
        }else{
            zpSysLog.setLoggerParams(params);
        }

        zpSysLog.setLoggerDate(GetDateUtil.getDateTime());
        //获取用户名
        zpSysLog.setLoggerUsername(SecurityUtils.getSubject().getPrincipal().toString());
        System.out.println(SecurityUtils.getSubject().getPrincipal().toString());
        //获取用户ip地址
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        zpSysLog.setLoggerIp(IPUtils.getIPAddress(request));
        //调用service保存SysLog实体类到数据库
        sysLogService.insertLog(zpSysLog);
    }

}
