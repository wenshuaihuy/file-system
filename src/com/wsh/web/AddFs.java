package com.wsh.web;

//import com.fs.domain.Fs;
//import com.fs.service.FsService;



import com.wsh.service.FsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author WS Hu
 * @date 2022/4/30 19:53
 */
@WebServlet("/add")
public class AddFs extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //测试
        System.out.println(22);
        //调用Service层方法
        FsService fsService = new FsService();
        fsService.addFlow();
        response.sendRedirect(request.getContextPath()+"/list");
    }
}
