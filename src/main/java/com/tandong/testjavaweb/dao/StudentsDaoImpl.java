package com.tandong.testjavaweb.dao;

import com.tandong.testjavaweb.entity.Student;
import com.tandong.testjavaweb.utils.JDBCUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsDaoImpl implements StudentsDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void add(Student s) throws SQLException {
        jdbcTemplate.update("insert into student(id,name,sex,age,tel)values(?,?,?,?,?)", s.getId()
                , s.getName(), s.getSex(), s.getAge(), s.getTel());
    }

    @Override
    public void update(Student s) throws SQLException {
        jdbcTemplate.update("UPDATE  student SET name=? ,sex=?,age=?,tel=? WHERE id=?",
                s.getName(), s.getSex(), s.getAge(), s.getTel(), s.getId());
    }

    @Override
    public void delete(int id) throws SQLException {
        jdbcTemplate.update("DELETE from TABLE student where id=?", id);
    }

    @Override
    public Student findById(int id) throws SQLException {
        List<Student> list = jdbcTemplate.query("select * from student where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Student.class));
        if (list != null && list.size() > 0) {
            Student student = list.get(0);
            return student;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> list = jdbcTemplate.query("select * from student", new Object[]{}, new BeanPropertyRowMapper(Student.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }


//    @Override
//    public void add(Student s) throws SQLException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        String sql = "insert into student(id,name,sex,age,tel)values(?,?,?,?,?)";
//        try {
//            conn = JDBCUtils.getInstance().getConnection();
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, s.id);
//            ps.setString(2, s.name);
//            ps.setString(3, s.sex);
//            ps.setInt(4, s.age);
//            ps.setString(5, s.tel);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new SQLException("添加数据失败！");
//        } finally {
//            JDBCUtils.getInstance().closeConnection(conn, ps, null);
//        }
//        System.out.println("数据添加成功！");
//    }
//
//    @Override
//    public void update(Student s) throws SQLException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        if (s == null) return;
//        // 根据对象属性 拼接 更新sql
//        String sql = "update student set ";
//        StringBuilder sb = new StringBuilder(sql);
//        sb.append("name=?");
//        sb.append(",sex=?");
//        sb.append(",tel=?");
//        if (s.age != 0) sb.append(",age=?");
//        if (s.id != 0) sb.append("where id=?");
//        // 如果sql语句和原始语句一样，或者 没有包含条件语句不允许执行
//        if (sb.toString().equals(sql) || sb.toString().contains("where")) return;
//        try {
//            conn = JDBCUtils.getInstance().getConnection();
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, s.name);
//            ps.setInt(2, s.age);
//            ps.setString(3, s.sex);
//            ps.setString(4, s.tel);
//            ps.setInt(5, s.id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new SQLException("更新数据失败");
//        } finally {
//            JDBCUtils.getInstance().closeConnection(conn, ps, null);
//        }
//        System.out.println("数据更新成功！");
//    }
//
//    @Override
//    public void delete(int id) throws SQLException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        String sql = "delete from student where id=?";
//        try {
//            conn = JDBCUtils.getInstance().getConnection();
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new SQLException(" 删除数据失败");
//        } finally {
//            JDBCUtils.getInstance().closeConnection(conn, ps, null);
//        }
//        System.out.println("数据删除成功！");
//    }
//
//    @Override
//    public Student findById(int id) throws SQLException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Student s = null;
//        String sql = "select * from student where id=?";
//        try {
//            conn = JDBCUtils.getInstance().getConnection();
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                s = new Student();
//                s.id = id;
//                s.name = rs.getString("name");
//                s.age = rs.getInt("age");
//                s.sex = rs.getString("sex");
//                s.tel = rs.getString("tel");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new SQLException("根据ID查询数据失败");
//        } finally {
//            JDBCUtils.getInstance().closeConnection(conn, ps, rs);
//        }
//        System.out.println("数据查询成功！");
//        return s;
//    }
//
//    @Override
//    public List<Student> findAll() throws SQLException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Student s;
//        List<Student> students = new ArrayList<Student>();
//        String sql = "select * from student";
//        try {
//            conn = JDBCUtils.getInstance().getConnection();
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                s = new Student();
//                s.id = rs.getInt("id");
//                s.name = rs.getString("name");
//                s.age = rs.getInt("age");
//                s.sex = rs.getString("sex");
//                s.tel = rs.getString("tel");
//                students.add(s);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new SQLException("查询所有数据失败");
//        } finally {
//            JDBCUtils.getInstance().closeConnection(conn, ps, rs);
//        }
//        System.out.println("数据查询成功！");
//        return students;
//    }
}
