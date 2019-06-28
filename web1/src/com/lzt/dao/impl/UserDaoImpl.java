package com.lzt.dao.impl;

import com.lzt.dao.UserDao;
import com.lzt.pojo.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    @Override
    public User checkUserLoginDao(String name, String pwd ) {
        //声明jdbc对象
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //声明变量
        User u=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/users_test?SSL=true","root", "root");
            //创建sql命令
            String sql="select * from users where name=? and pwd=?";
            //创建sql命令对象
            ps=conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, name);
            ps.setString(2, pwd);
            //执行sql
            rs=ps.executeQuery();
            //遍历结果
            while(rs.next()){
                //给变量赋值
                u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getInt("sex"));
                u.setBirth(rs.getDate("birth"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //关闭资源
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        //返回结果
        return u;
    }
}
