package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {

	private static final String url = "jdbc:mysql://";//数据库连接URL前缀
	private static final String portNumber = "3306";//数据库连接端口
	private static final String serverName="localhost",//数据库地址
			             databaseName="9_userlogin",
			             loginName="root",
			             loginPassword="root";
	// 告诉驱动器使用服务器端游标，
	// 它允许在一个连接上的多个活动语句。
	private static final String selectMethod = "cursor";
	/**
	 * 通过getConnection可以直接获得一个数据库连接
	 */

	public static java.sql.Connection getConnection() {
		Connection con = null;
		try {
			//注册 SQL Server JDBC 驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//创建新数据库连接
			con = java.sql.DriverManager.getConnection(getConnectionUrl(),
					loginName, loginPassword);
			if (con != null)
				System.out.println("数据库连接成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection() : "
					+ e.getMessage());
		}
		return con;
	}

	/**
	 * 返回数据库连接的字符串
	 */
	private static String getConnectionUrl() {
		return url + serverName + ":" + portNumber + "/"
				+ databaseName ;
	}
	
	/**
	 * 关闭一个数据库连接
	 */
	public static void  close(Connection conn){
		try {
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
			conn=null;
			System.out.println("conn关闭!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void close(PreparedStatement psm){
		try {
			if(psm!=null&&!psm.isClosed()){
				psm.close();
			}
			psm=null;
			System.out.println("psm连接关闭!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs){
		try {
			if(rs!=null&&!rs.isClosed()){
				rs.close();
			}
			rs=null;
			System.out.println("rs连接关闭!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
