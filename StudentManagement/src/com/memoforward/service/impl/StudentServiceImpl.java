package com.memoforward.service.impl;

import com.memoforward.dao.StudentDao;
import com.memoforward.dao.impl.StudentDaoImpl;
import com.memoforward.domain.PageBean;
import com.memoforward.domain.Student;
import com.memoforward.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> findAllStudents() throws SQLException {
        StudentDao stuDao = new StudentDaoImpl();
        return stuDao.findAllStudents();
    }

    @Override
    public Student findStudentById(String sid) throws SQLException {
        StudentDao stuDao = new StudentDaoImpl();
        return stuDao.findStudentById(sid);
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        new StudentDaoImpl().addStudent(student);
    }

    @Override
    public void updateStudent(Student stu) throws SQLException {
        StudentDao stuDao = new StudentDaoImpl();
        stuDao.updateStudent(stu);
    }

    @Override
    public void deleteStudentById(String sid) throws SQLException {
        StudentDao stuDao = new StudentDaoImpl();
        stuDao.deleteStudentById(sid);
    }

    @Override
    public PageBean<Student> findStudentsByPage(int currentPage) throws SQLException {
        PageBean<Student> pageBean = new PageBean<>();
        pageBean.setPerPageDataNum(perPageDataNum);
        pageBean.setCurrentPageNum(currentPage);
        StudentDao stuDao = new StudentDaoImpl();
        int totalDataNum = stuDao.findAllStudentNums();
        pageBean.setTotalDataNum(totalDataNum);
        int _totalPageNum = totalDataNum/perPageDataNum;
        pageBean.setTotalPageNum(totalDataNum%perPageDataNum == 0 ? _totalPageNum : _totalPageNum + 1);
        List<Student> stuList = stuDao.findStudentByPage(currentPage,perPageDataNum);
        pageBean.setPageList(stuList);
        return pageBean;
    }

    @Override
    public List<Student> findStudentsByNum(String stuNum) throws SQLException {
        return new StudentDaoImpl().findStudentsByNum(stuNum);
    }
}
