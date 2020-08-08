package com.example.api.exception;

import com.example.api.util.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public RestResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        //could_not_read_json
        logger.error("400，参数解析失败，详情：{}", e);
        return RestResponse.buildMsg(RestResponse.ResultType.BAD_REQUEST.value(), "400，参数解析失败", null);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public RestResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        //required_parameter_is_not_present
        logger.error("400，缺少请求参数，详情：{}", e);
        return RestResponse.buildMsg(RestResponse.ResultType.BAD_REQUEST.value(), "400，缺少请求参数", null);
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public RestResponse handleException(Exception e) {
        logger.error("500，服务器端发生错误，详情：{}", e);
        return RestResponse.error();
    }


    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ApiRRException.class)
    public RestResponse handleApiException(ApiRRException e) {
        logger.error("500，服务器端发生错误，详情：{}", e);
        return RestResponse.buildMsg(e.getCode(), e.getMessage());
    }
}