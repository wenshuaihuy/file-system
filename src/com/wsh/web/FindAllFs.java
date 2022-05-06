package com.wsh.web;


import com.wsh.domain.Fs;
import com.wsh.service.FsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author WS Hu
 * @date 2022/4/30 19:53
 */
@WebServlet("/listAll")
public class FindAllFs extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        测试
        System.out.println(33);
        FsService fsService = new FsService();
        List<Fs> list = fsService.finaAll();
        request.setAttribute("list", list);
        //将数据转发到
        request.getRequestDispatcher("/list-all.jsp").forward(request, response);
    }
}
