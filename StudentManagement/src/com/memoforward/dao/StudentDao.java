package com.memoforward.dao;

import com.memoforward.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    List<Student> findAllStudents() throws SQLException;

    Student findStudentById(String sid)throws SQLException;

    void addStudent(Student student)throws SQLException;

    void updateStudent(Student stu)throws SQLException;

    void deleteStudentById(String sid)throws SQLException;

    int findAllStudentNums()throws SQLException;

    List<Student> findStudentByPage(int currentPage, int perPageDataNum)throws SQLException;

    List<Student> findStudentsByNum(String stuNum)throws SQLException;
}
