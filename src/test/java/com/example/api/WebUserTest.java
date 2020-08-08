package com.example.api;

import com.example.api.controller.request.UserReq;
import com.example.api.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * api接口测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={ApiApplication.class})
public class WebUserTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    //private MockHttpSession session;

    private static final Logger logger = LoggerFactory.getLogger(WebUserTest.class);

    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
//        session = new MockHttpSession();
//        User user =new User("root","root");
//        session.setAttribute("user",user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }


    /**
     * 新增教程测试用例
     * @throws Exception
     */
    @Test
    public void getAll() throws Exception{

        UserReq req = new UserReq("param-name", 12);


        mvc.perform(MockMvcRequestBuilders.post("/user/getAll")
                // 请求contenType
                .contentType(MediaType.APPLICATION_JSON)
                // 请求的编码格式
                .characterEncoding("UTF-8")
                // 响应的congtentType
                .accept(MediaType.APPLICATION_JSON)

                // 请求body
                .content(JsonUtils.toJSON(req))

                // 如果是表单请求, 设置表单参数
                //.param("id", String.valueOf(1))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                //打印请求结果
                .andDo(MockMvcResultHandlers.print());
    }

}
