package com.tandong.testjavaweb.dao;

import com.tandong.testjavaweb.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentsDao {

    //添加方法
    void add(Student s) throws SQLException;

    //更新方法
    void update(Student s) throws SQLException;

    //删除方法
    void delete(int id) throws SQLException;

    //查找方法
    Student findById(int id) throws SQLException;

    //查找所有
    List<Student> findAll()throws SQLException;
}
