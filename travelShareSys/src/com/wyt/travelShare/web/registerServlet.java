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
 * 
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		
		String userName = request.getParameter("userName");
		String psw = request.getParameter("psw");
		String pswAgain = request.getParameter("pswAgain");
		String tel = request.getParameter("tel");
		User user = new User(null,userName,psw,tel);
		if(pswAgain.equals(psw) && userName != null && psw != null && tel != null) {
			ITravelShareService tss = new TravelShareService();
			tss.register(user);
			request.setAttribute("str", "true");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}	
		else {
			request.setAttribute("str", "false");
			request.getRequestDispatcher("/register.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
