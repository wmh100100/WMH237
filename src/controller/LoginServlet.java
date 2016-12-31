package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserInfo_Dao;
import domain.UserInfo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserInfo user = new UserInfo();
		user.setUser_id(request.getParameter("user_id"));
		user.setUser_name(request.getParameter("user_name"));
		user.setPassword(request.getParameter("password"));
		if(UserInfo_Dao.login(user)){
			HttpSession s = request.getSession();
			s.setAttribute("user", user);
			//WEB-INF目录只能用请求转发跳转
			request.getRequestDispatcher("WEB-INF/success.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("login.jsp");
		}
	}

}
