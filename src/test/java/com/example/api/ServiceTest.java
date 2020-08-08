package com.example.api;

import com.example.api.dto.UserDTO;
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

    @Test
    public void testGetAll() {
        List<UserDTO> data = userService.getAll();
        logger.info(JsonUtils.toJSON(data));
    }


}
