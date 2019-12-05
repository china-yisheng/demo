package com.base.utils.log;

import com.alibaba.fastjson.JSON;
import com.base.utils.log.service.ILog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Yr
 */
@Aspect
@Component
public class AopLogAspect {
    @Autowired
    private ILog iLog;



    /**
     * 定义切入位置 @Pointcut
     * 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.base.utils.log.AopLog)")
    public void logPointCut(){
    }

    /**
     * 切面配置通知
     */
    @AfterReturning("logPointCut()")
    public void saveAopLog(JoinPoint joinPoint){
    System.out.println("开始切面日志");

        //保存日志
        AopLogPo aopLogPo =new AopLogPo();

        //从切面植入点处通过反射机制获取植入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        AopLog aopLog = method.getAnnotation(AopLog.class);
        if (aopLog!=null){

            String active = aopLog.actionType();
            switch (active){
                case "1":
                    aopLogPo.setMethod("新增");
                    break;
                case "2":
                    aopLogPo.setMethod("修改");
                    break;
                case "3":
                    aopLogPo.setMethod("删除");
                    break;
                case "4":
                    aopLogPo.setMethod("查询");
                    break;
                default:
            }
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();

        //获取请求的方法名
        String methodName = method.getName();
        aopLogPo.setMethod(className+"."+methodName);

        //获取参数
        Object[] args = joinPoint.getArgs();
        String params= JSON.toJSONString(args);
        aopLogPo.setParams(params);

        //设置时间
        aopLogPo.setOperatingTime(new Date());

        //获取用户名
        //aopLogPo.setUserName();

        //获取用户IP
        //HttpServletRequest request = HttpContextUtils.

        this.iLog.save(aopLogPo);
        System.out.println(aopLogPo);
    }
}
