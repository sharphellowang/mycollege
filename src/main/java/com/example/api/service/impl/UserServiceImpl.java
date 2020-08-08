package com.example.api.service.impl;

import com.example.api.dto.UserDTO;
import com.example.api.orm.entity.UserPO;
import com.example.api.orm.mapper.UserMapper;
import com.example.api.service.UserService;
import com.example.api.util.BeanHelper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAll() {
        List<UserPO> userPOs = userMapper.selectAll();

        if(CollectionUtils.isEmpty(userPOs)){
            return new ArrayList<>(0);
        }

        return BeanHelper.copyList(userPOs, UserDTO.class);
    }
}
