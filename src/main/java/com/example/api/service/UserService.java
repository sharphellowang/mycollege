package com.example.api.service;

import com.example.api.dto.UserDTO;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 获取所有用户
     * @return
     */
    List<UserDTO> getAll();

}
