package com.akash.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akash.bean.Users;
import com.akash.dao.UserBOIMP;

/**
 * Servlet implementation class UserSave
 */
@WebServlet("/save")
public class UserSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users u = new Users();
		u.setName(request.getParameter("name"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		UserBOIMP ubo = new UserBOIMP();
		if(request.getParameter("id") != null && request.getParameter("id") != "") {
			u.setId(Integer.parseInt(request.getParameter("id")));
			int i = ubo.updateUser(u);
			response.sendRedirect("users?d="+i);
		} else {
			int i = ubo.createUser(u);
			response.sendRedirect("users?f="+i);
		}
	}

}
