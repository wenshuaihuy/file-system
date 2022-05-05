package com.wsh.dao;

import com.wsh.domain.Fs;
import com.wsh.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.logging.impl.Log4JLogger;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author WS Hu
 * @date 2020/12/16 23:17
 */
public class FsDao {
    Connection conn = null;

    //获取数据库连接
    {
        try {
            conn = DbUtils.getConnection().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询用户方法
     *
     * @return list
     */
    public List<Fs> findAll() {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from test_fs order by time desc";
        List<Fs> list = new ArrayList<>();
        //查询所有
        try {
            list = qr.query(conn, sql, new BeanListHandler<Fs>(Fs.class));
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询用户方法
     *
     * @return list
     */
    public void addFlow() {
        QueryRunner qr = new QueryRunner();
        String sql = "INSERT INTO test_fs VALUES(?, ?, ?)";
        String count = UUID.randomUUID().toString();
        String name = "123";
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        try {
            qr.update(conn, sql, count, format, name);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据时间查询方法
     * @param date1, date2
     * @return
     */
    public List<Fs> findByDate(String date1, String date2) {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from test_fs where time between ? and ? order by time desc";
        List<Fs> list = new ArrayList<>();
        //查询所有
        try {
            list = qr.query(conn, sql, new BeanListHandler<Fs>(Fs.class), date1, date2);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addFileData(String fileName) {
        QueryRunner qr = new QueryRunner();
        String sql = "INSERT INTO test_fs VALUES(?, ?, ?)";
        String count = UUID.randomUUID().toString();
//        String name = "123";
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        try {
            qr.update(conn, sql, count, fileName, format);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Fs> findByFileName(String fileName) {
        QueryRunner qr = new QueryRunner();
        ////查询所有姓名包含“张”的记录
        //select * from student where name like '张'
        String sql = "select * from test_fs where name = ?";
        List<Fs> list = new ArrayList<>();
        //查询所有
        try {
            list = qr.query(conn, sql, new BeanListHandler<Fs>(Fs.class), "%" + fileName + "%");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    /**
     * delete data
     * @param id
     */
    public void delFile(String id) {
        QueryRunner qr = new QueryRunner();
        String sql = "delete from test_fs where id = ?";
        try {
            qr.update(conn, sql, id);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
