package com.wsh.web;

//import com.fs.domain.Fs;
//import com.fs.service.FsService;
//import com.mysql.jdbc.log.Slf4JLogger;
import com.wsh.domain.Fs;
import com.wsh.service.FsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

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
@WebServlet("/list")
public class FindFs extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        测试
        System.out.println(111);
        FsService fsService = new FsService();
        List<Fs> list = fsService.finaAll();
        //将集合存到域对象
        request.setAttribute("list",list);
        //将数据转发到
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
