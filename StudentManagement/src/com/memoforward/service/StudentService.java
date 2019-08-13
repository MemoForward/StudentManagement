package com.memoforward.service;

import com.memoforward.domain.PageBean;
import com.memoforward.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    static final int perPageDataNum = 5; //每页显示5个数据

    List<Student> findAllStudents() throws SQLException;

    Student findStudentById(String sid)throws SQLException;

    void addStudent(Student student)throws SQLException;

    void updateStudent(Student stu)throws SQLException;

    void deleteStudentById(String sid)throws SQLException;

    PageBean<Student> findStudentsByPage(int currentPage)throws SQLException;

    List<Student> findStudentsByNum(String stuNum)throws SQLException;
}
