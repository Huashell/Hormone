//package com.example.hormone.aspect;
//
//import com.example.hormone.aspect.annotation.PermissionData;
//import com.example.hormone.utils.JwtTokenUtil;
//import com.example.hormone.utils.SpringContextUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//
//@Aspect
//@Component
//@Slf4j
//public class PermissionDataAspect {
//
//
//    @Pointcut("@annotation(com.example.hormone.aspect.annotation.PermissionData)")
//    public void pointCut() {
//
//    }
//
//    @Around("pointCut()")
//    public Object arround(ProceedingJoinPoint point) throws Throwable{
//        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
//        MethodSignature signature = (MethodSignature) point.getSignature();
//        Method method = signature.getMethod();
//        PermissionData pd = method.getAnnotation(PermissionData.class);
//        String component = pd.pageComponent();
//        String requestMethod = request.getMethod();
//        String requestPath = request.getRequestURI().substring(request.getContextPath().length());
//        requestPath = filterUrl(requestPath);
//        /**
//         * 进行权限检查
//        **/
//        return point.proceed();
//    }
//
//    private String filterUrl(String requestPath) {
//        String url = "";
//        if(!requestPath.isEmpty()){
//            url = requestPath.replace("\\", "/");
//            url = url.replace("//", "/");
//            if(url.indexOf("//") >= 0){
//                url = filterUrl(url);
//            }
//        }
//        return url;
//    }
//
//}
