package com.wsh.web;

import com.wsh.service.FsService;
import org.apache.commons.logging.impl.Log4JLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author huwenshuai
 * @date 2022/5/5 18:56
 */
@WebServlet("/delFile")
public class DelFile extends HttpServlet {
    Logger logger = Logger.getLogger(String.valueOf(DelFile.class));
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String fileName = request.getParameter("filename");
        if (id == null) {
            request.setAttribute("msg", "文件不存在");
            request.getRequestDispatcher("/print.jsp").forward(request, response);
        }
        if ("".equals(FileUpload.FILEPath)) {
            FileUpload.FILEPath = getServletContext().getRealPath("/WEB-INF/upload/");
        }
        File file = new File(FileUpload.FILEPath + fileName);
        if (file.exists()) {
            file.delete();
        } else {
            logger.info("文件不存在");
            request.setAttribute("msg", "文件不存在");
            request.getRequestDispatcher("/print.jsp").forward(request, response);
        }
        FsService fsService = new FsService();
        fsService.delFile(id);
        response.sendRedirect(request.getContextPath()+"/listAll");
    }
}
