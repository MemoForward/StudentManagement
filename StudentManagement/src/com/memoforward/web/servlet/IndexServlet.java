package com.memoforward.web.servlet;

import com.memoforward.domain.PageBean;
import com.memoforward.domain.Student;
import com.memoforward.service.StudentService;
import com.memoforward.service.impl.StudentServiceImpl;
import com.memoforward.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "IndexServlet",urlPatterns = "/indexServlet.do")
public class IndexServlet extends BaseServlet {

    public String excute(HttpServletRequest req, HttpServletResponse resp){
        StudentService stuService = new StudentServiceImpl();
        int currentPageNum;
        String page = req.getParameter("currentPageNum");
        if(page == null || page.equals("")){
            currentPageNum = 1;
        }else{
            currentPageNum = Integer.valueOf(page);
        }
        PageBean<Student> pageList= null;
        try {
            pageList = stuService.findStudentsByPage(currentPageNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("pageList", pageList);

        return "/jsp/stuList.jsp";
    }

//    public String excute(HttpServletRequest req, HttpServletResponse resp){
//        StudentService stuService = new StudentServiceImpl();
//        List<Student> stuList = null;
//        try {
//            stuList = stuService.findAllStudents();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        req.setAttribute("stuList", stuList);
//        return "/jsp/stuList.jsp";
//    }
}
