package com.example.api;

import com.example.api.dto.AddrDTO;
import com.example.api.dto.UserDTO;
import com.example.api.service.AddrService;
import com.example.api.service.UserService;
import com.example.api.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ServiceTest.class);

    @Autowired
    private UserService userService;
    @Autowired
    private AddrService addrService;


    @Test
    public void testGetAll() {
        List<UserDTO> data = userService.getAll();
        logger.info(JsonUtils.toJSON(data));
    }

    @Test
    public void testAddrInsert() {

        AddrDTO param = new AddrDTO();
        param.setUserId(123L);
        param.setAddr("大冲");

        addrService.insertOne(param);
    }

}
