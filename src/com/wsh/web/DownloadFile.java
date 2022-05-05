package com.wsh.web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author huwenshuai
 * @date 2022/5/5 17:03
 */
@WebServlet("/downloadFile")
public class DownloadFile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String fileName = request.getParameter("filename");
        if ("".equals(FileUpload.FILEPath)) {
            FileUpload.FILEPath = getServletContext().getRealPath("/WEB-INF/upload/");
        }
        File file = new File(FileUpload.FILEPath + fileName);
        if (file.exists()) {
            //设置相应类型让浏览器知道用什么打开  用application/octet-stream也可以，看是什么浏览器
            response.setContentType("application/x-msdownload");
            //设置头信息
            response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
            InputStream inputStream = new FileInputStream(file);
            ServletOutputStream ouputStream = response.getOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = inputStream.read(b)) != -1) {
                ouputStream.write(b, 0, n);
            }
            ouputStream.close();
            inputStream.close();
        } else {
            request.setAttribute("msg", "文件不存在,下载失败!");
            request.getRequestDispatcher("/print.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/list-all.jsp").forward(request, response);
    }
}
