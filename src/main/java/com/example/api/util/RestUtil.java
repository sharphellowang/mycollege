package com.example.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestUtil.class);


    public static void response(HttpServletResponse response, int code, String msg) {
        response(response, code, msg, null);
    }


    public static void response(HttpServletResponse response, int code, String msg, Object content) {
        try {
            RestResponse res = RestResponse.buildMsg(code, msg, content);
            String resStr = JsonUtils.toJSON(res);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(resStr);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
