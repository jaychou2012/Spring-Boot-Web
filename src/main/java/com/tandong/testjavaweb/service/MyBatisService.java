package com.tandong.testjavaweb.service;

import com.tandong.testjavaweb.entity.MyBatis;
import com.tandong.testjavaweb.mapper.MyBatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBatisService {

    @Autowired
    private MyBatisMapper myBatisMapper;


    public List<MyBatis> getMyBatisMapper() {
        return myBatisMapper.getList();
    }

    public MyBatis getMyBatisByIdMapper(int id) {
        return myBatisMapper.findById(id);
    }

    public void addMyBatisMapper(MyBatis myBatis) {
        myBatisMapper.addMyBatis(myBatis.getName(), myBatis.getDescription(), myBatis.getPrice(), myBatis.getDate());
    }

}
