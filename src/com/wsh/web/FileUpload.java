package com.wsh.web;

import com.wsh.service.FsService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author wsh
 * @date 2022/5/4 7:18 下午
 */
@WebServlet("/fileUpload")
public class FileUpload extends HttpServlet {
    static String FILEPath = "";

    String filename = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; cha|rset=UTF-8");
        final String filePath = getServletContext().getRealPath("/WEB-INF/upload/");
        FILEPath = filePath;
        System.out.println("filePath==" + filePath);
        // 判断提交类型是否为multipart/form-data
        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
                // 前端传过来的文件名
                filename = null;
                List<FileItem> items = servletFileUpload.parseRequest(request);
                Iterator<FileItem> it = items.iterator();
                // 迭代从前端获取的数据，处理表单数据和文件数据
                while (it.hasNext()) {
                    FileItem item = it.next();
                    filename = item.getName();
                    // 文件夹不存在则创建
                    File dir = new File(filePath);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    } else if (dir.exists() && dir.isDirectory()) {
                        System.out.println("文件夹存在，跳过新建文件夹流程！");
                    } else {
                        throw new Exception("无法创建文件夹，请确认目标路径是一个文件夹类型！");
                    }
                    File file = new File(filePath, filename);
                    item.write(file);
                    FsService fsService = new FsService();
                    fsService.addFileData(filename);
                    request.setAttribute("msg", filename + "已上传成功! ");
                }
            }
        } catch (Exception e) {
//            request.setAttribute("msg", String.format("%s-%s ： %s上传失败,请查看错误日志！", filename));
            request.setAttribute("msg", "文件：" + filename + "  上传失败,文件已经存在！");
            request.getRequestDispatcher("print.jsp").forward(request, response);
            System.out.println(String.format("文件上传失败，错误原因为：%s", e.getMessage()));
        }
//        request.getRequestDispatcher("/list-all.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/listAll");
    }
}


