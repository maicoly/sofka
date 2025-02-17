package com.test.sofka.AccountMovements.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;
/**
 * filter interceptor for all request
 *
 * @autor maicoly
 * @fecha 2025/02/16
 */
@Component
public class CustomInterceptor  implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(CustomInterceptor.class);
    String requestE= "############################# REQUEST DEL CLIENTE ###########################################";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = String.valueOf(request.getRequestURI());
        long startTime = System.currentTimeMillis();
        setTraceability();
        log.info(requestE);
        log.info("startTime {}", startTime);
        request.setAttribute("startTime", startTime);
        log.info("METHOD {}, {}", request.getMethod(), path);
        log.info("#####################################END REQUEST DEL CLIENTE###################################################");
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Después de completar la solicitud: " + request.getRequestURI());
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        log.info("Request procesado para la url: {}. Tiempo total:  {} ms" , request.getRequestURL().toString() , timeTaken );
        MDC.clear();
    }

    private void setTraceability(){
        clearTraceability();
        String uuid = String.valueOf(UUID.randomUUID().hashCode() & Long.MAX_VALUE);
        MDC.put("uuid", uuid);
    }
    public void clearTraceability() {
        MDC.clear();
    }
}
