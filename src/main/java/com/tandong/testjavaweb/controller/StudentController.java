package com.tandong.testjavaweb.controller;

import com.tandong.testjavaweb.dao.StudentsDaoImpl;
import com.tandong.testjavaweb.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 注意@RestController用于写接口
 *
 * @Controller 用于写页面跳转
 */
@RestController
//@Controller
@SpringBootApplication
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentsDaoImpl studentsDao;

    /**
     * ResopnseBody如果返回的是Object，会把返回结果转为Json格式输出
     *
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    public Object getUserNameGet(@RequestParam(value = "name") String userName) {
        return userName;
    }

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getName(@RequestParam(value = "name") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String listUser() {
        Student student = new Student();
        student.setAge(12);
        student.setName("学生");
        student.setSex("女");
        student.setTel("13333333333");
        try {
            studentsDao.add(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "插入成功";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getLists() {
        List<Student> userList = null;
        try {
            userList = studentsDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
