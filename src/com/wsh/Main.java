/*
package com.wsh;

*
 * @author wsh



import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class UploadServlet extends HttpServlet {
    // 文件路径定义
    public static final String filePath = "/Users/younglu/upload";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        // 判断提交类型是否为multipart/form-data
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

            // 前端传过来的三个参数 工号、姓名和文件名
            String sno = null;
            String sname = null;
            String filename = null;
            try {
                List<FileItem> items = servletFileUpload.parseRequest(req);
                Iterator<FileItem> it = items.iterator();

                // 迭代从前端获取的数据，处理表单数据和文件数据
                while (it.hasNext()) {
                    FileItem item = it.next();
                    if (item.isFormField()) {
                        if (item.getFieldName().equals("sno")) {
                            sno = item.getString("utf-8");
                        } else if (item.getFieldName().equals("sname")) {
                            sname = item.getString("utf-8");
                        } else {
                            System.out.println("其他字段，忽略。");
                        }
                    } else {
                        filename = item.getName();
                        // 文件夹不存在则创建
                        File dir = new File(filePath);
                        if (!dir.exists()) {
                            dir.mkdir();
                        } else if (dir.exists() && dir.isDirectory()) {
                            System.out.println("文件夹存在，跳过新建文件夹流程！");
                        } else {
                            throw new Exception("无法创建文件夹，请确认目标路径是一个文件夹类型！");
                        }
                        File file = new File(filePath, filename);
                        item.write(file);
                        req.setAttribute("news", String.format("%s-%s ： %s已上传成功,谢谢分享", sno, sname, filename));
                    }
                }
            } catch (Exception e) {
                req.setAttribute("news", String.format("%s-%s ： %s上传失败,请查看错误日志！", sno, sname, filename));
                System.out.println(String.format("文件上传失败，错误原因为：%s", e.getMessage()));
            }
            req.getRequestDispatcher("print.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

}
*/
