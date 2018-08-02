package com.puwei666.demo.interceptor;

import com.puwei666.demo.annotation.Access;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AccessInterceptor implements HandlerInterceptor {
  private static final Logger logger = LoggerFactory.getLogger(AccessInterceptor.class);
  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
    HandlerMethod handlerMethod = (HandlerMethod) o;
    Method m = handlerMethod.getMethod();
    Access access = m.getAnnotation(Access.class);
    if(access == null || access.value()){
      logger.info("Access - uri:{},query:{}",httpServletRequest.getRequestURI(),httpServletRequest.getQueryString());
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

  }
}
