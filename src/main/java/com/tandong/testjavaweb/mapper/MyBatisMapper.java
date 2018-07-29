package com.tandong.testjavaweb.mapper;

import com.tandong.testjavaweb.entity.MyBatis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface MyBatisMapper {

    @Select("SELECT * FROM mybatis WHERE id = #{id}")
    MyBatis findById(@Param("id") Integer id);

    @Select(value = "select * from mybatis")
    List<MyBatis> getList();

    @Insert(value = "insert into mybatis(name, description,price,date) values(#{name}, #{description}, #{price}, #{date})")
    void addMyBatis(@Param("name") String name, @Param("description") String description, @Param("price") long price, @Param("date") Date date);
}
