package com.wsh.service;

import com.wsh.dao.FsDao;
import com.wsh.domain.Fs;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.MultipartStream;

import java.util.List;

/**
 * @author WS Hu
 * @date 2020/12/17 10:13
 */
public class FsService {

    FsDao fsDao = new FsDao();

    /**
     * 查询所有方法
     * @return
     */
    public List<Fs> finaAll() {
        //查询所有
        return fsDao.findAll();
    }

    /**
     *上传文件
     */
    public void addFlow() {


        fsDao.addFlow();
    }

    /**
     * 根据时间查询
     * @param date1,date2
     * @return
     */
    public List<Fs> findByDate(String date1,String date2) {
        return fsDao.findByDate(date1,date2);
    }


    /**
     * 添加文件信息
     */
    public void addFileData(String fileName) {
        fsDao.addFileData(fileName);
    }

    public List<Fs> findByFileName(String fileName) {

        return fsDao.findByFileName(fileName);
    }

    public void delFile(String id) {
        fsDao.delFile(id);
    }
}
