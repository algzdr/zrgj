package com.wyt.travelShare.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyt.travelShare.domain.User;
import com.wyt.travelShare.service.ITravelShareService;
import com.wyt.travelShare.service.impl.TravelShareService;

/**
 * Servlet implementation class updateInfoServlet
 */
@WebServlet("/updateInfoServlet")
public class updateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateInfoServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		String userName = request.getParameter("name");
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("password");
		String phoneNum = request.getParameter("tel");
		User user = new User(userId,userName,password,phoneNum);
		ITravelShareService tss = new TravelShareService();
		System.out.println(user);
		tss.updateUser(user);
		request.getRequestDispatcher("/userListServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
