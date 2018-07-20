package com.nieyue.common;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.name;

/**
 * 获取session cookie
 */
@Configuration
@EnableFeignClients(basePackages = "com.nieyue")
public class FeignClientsConfigurationCustom implements RequestInterceptor {
    @Value("${server.servlet.session.cookie.name}")
    String cookiename;
  @Override
  public void apply(RequestTemplate template) {
 
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    if (requestAttributes == null) {  
      return;  
    }
    String token=null;
    HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
    Enumeration<String> headerNames = request.getHeaderNames();
      template.header("Cookie",cookiename+"="+request.getSession().getId());
      if (headerNames != null) {
          while (headerNames.hasMoreElements()) {
        String name = headerNames.nextElement();
        Enumeration<String> values = request.getHeaders(name);
        while (values.hasMoreElements()) {
            String value = values.nextElement();
          template.header(name, value);
        }
      }
    }

  }
}