package com.arc.recycle.config.aop;

import com.arc.enums.system.ProjectCodeEnum;
import com.arc.exception.BizException;
import com.arc.model.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 叶超
 * @since 2019/4/10 17:50
 */
@Aspect
@Component
@Slf4j
public class AspectForController {
//    private final static Logger log = LoggerFactory.getLogger(AspectForController.class);

    /**
     * 切点
     */
    @Pointcut("execution(public * com.arc.recycle.controller.*.*Controller.*(..))")
    public void pointcut() {
    }


    /**
     * 环绕通知
     * Around Advice 围绕连接点执行
     * 我们使用@Around来捕获异常信息，并用之前定义好的Result进行异常的返回
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
        long start = System.currentTimeMillis();
        log.debug("pointcut ---------------------------------- AROUND");
        ResponseVo result = null;
        try {
            long startTime = System.currentTimeMillis();
            result = (ResponseVo) proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis() - startTime;

            log.info("业务耗时：" + endTime);
        } catch (Throwable e) {
            long exClock = System.currentTimeMillis();
            System.err.println("------------------------------------");
            System.out.println("getCause=" + e.getCause());
            System.out.println("getMessage=" + e.getMessage());
            System.out.println("getLocalizedMessage=" + e.getLocalizedMessage());
            System.out.println("getSuppressed=" + e.getSuppressed());
            System.out.println("getStackTrace=" + e.getStackTrace());
            System.out.println(e.getStackTrace());
            e.printStackTrace();

            System.err.println("------------------------------------+\n " + e.toString());

            result = handlerException(e);
            log.debug("调用业务方法耗时={}ms,处理异常耗时={}ms", exClock - start, System.currentTimeMillis() - exClock);

        }
        long cost = System.currentTimeMillis() - start;
        log.info("方法总耗时 {} ms ", cost);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(result.getMsg()).append(" 耗时").append(cost).append("ms");
        String msg = stringBuffer.toString();
        result.setMsg(msg);
        return result;
    }

    private ResponseVo handlerException(Throwable e) {

        if (e instanceof BizException) {
            return ResponseVo.failure(((BizException) e).getCode(), ((BizException) e).getMsg());
        }
        return ResponseVo.failure(ProjectCodeEnum.UNKNOWN);
    }
}

//
//    aspectJ切面通过ProceedingJoinPoint想要获取当前执行的方法：
//
//    错误方法：
//
//
//
//                 Signature s = pjp.getSignature();
//    MethodSignature ms = (MethodSignature)s;
//    Method m = ms.getMethod();
//
//    这种方式获取到的方法是接口的方法而不是具体的实现类的方法，因此是错误的。
//
//
//
//    正确方法：
//
//                    Signature sig = pjp.getSignature();
//        MethodSignature msig = null;
//        if (!(sig instanceof MethodSignature)) {
//            throw new IllegalArgumentException("该注解只能用于方法");
//        }
//        msig = (MethodSignature) sig;
//        Object target = pjp.getTarget();
//        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
//
//
//---------------------
//    原文：https://blog.csdn.net/meiyang1990/article/details/50562046
