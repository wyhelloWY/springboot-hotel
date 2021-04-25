package com.jxau.hotelsystem.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/11 21:25
 */
public class HttpContextUtil {

    private HttpContextUtil(){}
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
