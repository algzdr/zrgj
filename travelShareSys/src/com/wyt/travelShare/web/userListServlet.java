package com.wyt.travelShare.web;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class userListServlet
 */
@WebServlet("/userListServlet")
public class userListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userListServlet() {
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");
		response.setContentType("text/html;charset="+encoding);
		
		ITravelShareService tss = new TravelShareService();
		
		List<User> list = tss.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/userList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
