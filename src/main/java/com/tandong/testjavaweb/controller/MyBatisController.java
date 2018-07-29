package com.tandong.testjavaweb.controller;

import com.tandong.testjavaweb.entity.MyBatis;
import com.tandong.testjavaweb.service.MyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping("/mybatis")
public class MyBatisController {
    @Autowired
    MyBatisService myBatisService;

    @ResponseBody
    @GetMapping(value = "/addMyBatisMapper")
    public Object addMyBatisMapper() {
        MyBatis myBatis = new MyBatis();
        myBatis.setDate(new Date());
        myBatis.setDescription("描述");
        myBatis.setName("名字");
        myBatis.setPrice(20);
        myBatisService.addMyBatisMapper(myBatis);
        return "插入成功";
    }

    @GetMapping(value = "/getListMapper")
    public List<MyBatis> getListMapper() {
        return myBatisService.getMyBatisMapper();
    }

    @GetMapping(value = "/mapper/{idMapper}")
    public MyBatis getMyBatisByIdMapper(@PathVariable Integer idMapper) {
        return myBatisService.getMyBatisByIdMapper(idMapper);
    }
}
