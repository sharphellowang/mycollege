package com.example.api.controller;

import com.example.api.config.JpushConfiguration;
import com.example.api.controller.request.UserReq;
import com.example.api.dto.UserDTO;
import com.example.api.service.UserService;
import com.example.api.util.JsonUtils;
import com.example.api.util.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Autowired
    JpushConfiguration jpushConfiguration;

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public RestResponse getAll(@RequestBody UserReq param) {

        logger.info("===> getAll param: {}", JsonUtils.toJSON(param));
        List<UserDTO> data = userService.getAll();

        logger.info("===> 查询用户: {}", JsonUtils.toJSON(data));
        return RestResponse.success(data);
    }

    @RequestMapping(value = "/getJpush", method = RequestMethod.GET)
    public RestResponse getJpush() {
        logger.info("===> jpush: {}-{}",  jpushConfiguration.getAppId(),  jpushConfiguration.getSecretKey());
        return RestResponse.success();
    }


}
