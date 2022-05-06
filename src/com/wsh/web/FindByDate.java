package com.wsh.web;

//import com.fs.domain.Fs;
//import com.fs.service.FsService;

import com.wsh.domain.Fs;
import com.wsh.service.FsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author WS Hu
 * @date 2022/4/30 19:53
 */
@WebServlet("/findByDate")
public class FindByDate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户输入的查询时间
//        String date1 = request.getParameter("date1").replace("T"," ")+":00";
        String date1 = request.getParameter("date1");
//      String date2 = request.getParameter("date2").replace("T"," ")+":59";
        String date2 = request.getParameter("date2");
        FsService fsService = new FsService();
        List<Fs> list = fsService.findByDate(date1, date2);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/list-all.jsp").forward(request, response);

    }
}
