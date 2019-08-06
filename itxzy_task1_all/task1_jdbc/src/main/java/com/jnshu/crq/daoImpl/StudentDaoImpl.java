package com.jnshu.crq.daoImpl;

import com.jnshu.crq.dao.StudentDao;
import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.utils.DBUtil;

import java.sql.*;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void insertStudent(Student student) {
        String sql = "insert into student (name,qq,skill) values (?,?,?)";
        Connection con = DBUtil.open();
        try {
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,student.getName());//替换？占位符
            pstmt.setString(2,student.getQq());
            pstmt.setString(3,student.getSkill());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            while (rs.next()){
                student.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(int id) {
        String sql = "delete from student where id = ?";
        Connection con = DBUtil.open();
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "update student set name=?,qq=?,skill=? where id = ?";
        Connection con = DBUtil.open();
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,student.getName());
            pstmt.setString(2,student.getQq());
            pstmt.setString(3,student.getSkill());
            pstmt.setInt(4,student.getId());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student getStudentById(int id) {
        String sql = "select * from student where id = ?";
        Connection con = DBUtil.open();
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if( rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setQq(rs.getString("qq"));
                student.setSkill(rs.getString("skill"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }
        return null;
    }
}
