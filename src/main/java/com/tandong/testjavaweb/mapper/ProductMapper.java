package com.tandong.testjavaweb.mapper;

import com.tandong.testjavaweb.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM product WHERE id = #{id}")
    Product findById(@Param("id") Integer id);

    @Select(value = "select * from product")
    List<Product> getList();

    @Insert(value = "insert into product(name, description,price,date) values(#{name}, #{description}, #{price}, #{date})")
    void addProduct(@Param("name") String name, @Param("description") String description, @Param("price") long price, @Param("date") Date date);
}
