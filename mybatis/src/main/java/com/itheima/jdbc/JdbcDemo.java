package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt =null;
		ResultSet rs = null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.创建数据库连接对象
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis","root","root");
			//3.定义sql语句
			String sql = "select * from user where id = ?";
			//4.创建Statement语句对象
			psmt = con.prepareStatement(sql);
			//5.设置参数
			psmt.setInt(1, 16);
			//6.执行查询
			rs = psmt.executeQuery();
			//7.处理结果集
			while (rs.next()) {
				System.out.println("用户id:"+rs.getInt("id")+",用户姓名："+rs.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null)rs.close();
				if (psmt!=null)psmt.close();
				if (con!=null)con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
