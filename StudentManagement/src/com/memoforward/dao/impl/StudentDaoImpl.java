package com.memoforward.dao.impl;

import com.memoforward.dao.StudentDao;
import com.memoforward.domain.Student;
import com.memoforward.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAllStudents() throws SQLException {
        String sql = "select * from stu";
        List<Student> stuList = new ArrayList<>();
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        stuList = qr.query(sql, new BeanListHandler<Student>(Student.class));
        C3P0Utils.closeConn();
        return stuList;
    }

    @Override
    public Student findStudentById(String sid) throws SQLException {
        String sql = "select * from stu where sid = ?";
        Student student = new Student();
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        student = qr.query(sql, new BeanHandler<Student>(Student.class),sid);
        C3P0Utils.closeConn();
        return student;
    }

    @Override
    public void addStudent(Student stu) throws SQLException {
        String sql = "insert into stu values (?,?,?,?,?,?)";
        Object[] params = {stu.getSid(),stu.getSnum(),stu.getSname(),stu.getSage(),stu.getSgender(),stu.getBirthday()};
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        qr.update(sql, params);
        C3P0Utils.closeConn();
    }

    @Override
    public void updateStudent(Student stu) throws SQLException {
        String sql = "update stu set snum=?,sname=?,sage=?,sgender=?,birthday=? where sid = ?";
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        Object[] params = {stu.getSnum(),stu.getSname(),stu.getSage(),stu.getSgender(),stu.getBirthday(),stu.getSid()};
        qr.update(sql, params);
        C3P0Utils.closeConn();
    }

    @Override
    public void deleteStudentById(String sid) throws SQLException {
        String sql = "delete from stu where sid = ?";
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        qr.update(sql, sid);
        C3P0Utils.closeConn();
    }

    @Override
    public int findAllStudentNums() throws SQLException {
        String sql = "select count(*) from stu ";
        Student student = new Student();
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        int num = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        C3P0Utils.closeConn();
        return num;
    }

    @Override
    public List<Student> findStudentByPage(int currentPage,int perPageDataNum) throws SQLException {
        String sql = "select * from stu limit ?, ?";
        int _currentPage = (currentPage - 1) * perPageDataNum;
        List<Student> stuList = new ArrayList<Student>();
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        stuList = qr.query(sql, new BeanListHandler<Student>(Student.class),_currentPage,perPageDataNum);
        C3P0Utils.closeConn();
        return stuList;
    }

    @Override
    public List<Student> findStudentsByNum(String stuNum) throws SQLException {
        String sql = "select * from stu where snum like ?";
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        List<Student> stuList = new ArrayList<>();
        stuList = qr.query(sql, new BeanListHandler<Student>(Student.class), "%" + stuNum + "%");
        C3P0Utils.closeConn();
        return stuList;
    }
}
