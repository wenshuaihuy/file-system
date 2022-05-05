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
 * @author huwenshuai
 * @date 2022/5/5 15:30
 */
@WebServlet("/findByFileName")
public class FindByFileName extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //测试
//        System.out.println(44);
        //获取用户输入的查询时间
//        String date1 = request.getParameter("date1").replace("T"," ")+":00";
        String fileName = request.getParameter("fileName");

        //调用Service层方法
            FsService fsService = new FsService();
            List<Fs> list = fsService.findByFileName(fileName);
        //将集合存到域对象
            request.setAttribute("list", list);
        //将数据转发到
        request.getRequestDispatcher("/list-all.jsp").forward(request, response);

    }

}
