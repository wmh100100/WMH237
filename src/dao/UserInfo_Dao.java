package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.UserInfo;
import tools.Encrypt;

public class UserInfo_Dao {
	public static boolean login(UserInfo user){
		boolean login=false;
		ResultSet rs=null;
		PreparedStatement psm=null;
		Connection conn=null;
		int num=0;
		try{
			conn=JDBCConnection.getConnection();
			psm=conn.prepareStatement("select count(*) from user where user_id=? and password=? ");
			psm.setString(1,user.getUser_id());
			psm.setString(2,Encrypt.md5(user.getPassword()));
			rs=psm.executeQuery();
			if(rs.next()){
				num=rs.getInt(1);
			}
			if(num!=0){
				login=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCConnection.close(rs);
			JDBCConnection.close(psm);
			JDBCConnection.close(conn);
		}
		return login;
	}
	
	public static int regist(String user_id,String user_name,String password){
		int regist=0;
		Connection conn=null;
		PreparedStatement psm=null;
		try {
			conn=JDBCConnection.getConnection();
			String sql="INSERT INTO user(user_id,user_name,password)VALUES(?,?,?)";
			psm = conn.prepareStatement(sql);
			psm.setString(1,user_id);
			psm.setString(2,user_name);
			psm.setString(3,Encrypt.md5(password));
			regist=psm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCConnection.close(psm);
			JDBCConnection.close(conn);
		}
		return regist;
	}
}
