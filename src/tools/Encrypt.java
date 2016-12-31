package tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
	public static  String md5(String password){
		 MessageDigest md=null;
		 String str="";
		 try{
			 md=MessageDigest.getInstance("MD5");
			 md.update(password.getBytes());
			 str=new String(md.digest());			 
		 }catch(NoSuchAlgorithmException e){
			 e.printStackTrace();
		 }
		 return str;
	}
}
