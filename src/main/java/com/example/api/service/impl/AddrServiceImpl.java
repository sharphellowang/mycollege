package com.example.api.service.impl;

import com.example.api.dto.AddrDTO;
import com.example.api.orm.entity.AddrPO;
import com.example.api.orm.mapper.AddrMapper;
import com.example.api.service.AddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 */
@Service
public class AddrServiceImpl implements AddrService {

    @Autowired
    private AddrMapper addrMapper;

    @Override
    public int insertOne(AddrDTO addr) {

        AddrPO po = new AddrPO();
        po.setUserId(addr.getUserId());
        po.setAddr(addr.getAddr());

        return addrMapper.insert(po);
    }
}
