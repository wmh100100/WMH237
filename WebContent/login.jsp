<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
 <form action="LoginServlet" method="post">
  <table>
   <tr><td colspan="2" align="center">用户登录程序</td></tr>
   <tr>
    <td>用户ID：</td>
    <td><input type="text" name="user_id"/></td>
   </tr>
   <tr>
    <td>用户名：</td>
    <td><input type="text" name="user_name"/></td>
   </tr>
   <tr>
    <td>密码：</td>
    <td><input type="password" name="password"/></td>
   </tr>
   <tr><td colspan="2"><input type="submit" value="登录"/></td></tr>
  </table>
 </form>
 <a href="regist.jsp">没账号，请注册</a>
</body>
</html>