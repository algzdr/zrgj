package com.wyt.travelShare.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wyt.travelShare.domain.User;
import com.wyt.travelShare.service.ITravelShareService;
import com.wyt.travelShare.service.impl.TravelShareService;

/**
 * Servlet implementation class travelShareServlet
 */
@WebServlet("/travelShareServlet")
public class travelShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public travelShareServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		//获取字符编码集
		String encoding = context.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		
		String ope = request.getParameter("ope");
		System.out.println(ope);
		if(ope.equals("login")) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			System.out.println(name);
			System.out.println(password);
			ITravelShareService service = new TravelShareService();
			User user = service.Login(name, password);
			String code = request.getParameter("code");
			String sessionCode = (String)request.getSession().getAttribute("code");
			
			System.out.println(code + "   " + sessionCode);
			if (!sessionCode.equalsIgnoreCase(code)) {
	            request.getRequestDispatcher("/login.jsp").forward(request, response);
	            return;
	        }
			else {
				if(user != null) {
					//把登录用户存入session中
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					
					//格式化日期格式
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
					String lastTime = sdf.format(new Date());
					
					Cookie[] cookies = request.getCookies();
					if(cookies != null) {
						Cookie c = null;
						for (Cookie cookie : cookies) {
							String cookieName = cookie.getName();
							//如果有名字为lastTime的Cookie
							if("lastTime".equals(cookieName)) {
								c = cookie;
								break;
							}
						}
						if(c != null) {
							String time = c.getValue();
							//把lastTime时间放入到请求域中
							System.out.println(time);
							request.setAttribute("lastTime", time);
							//给cookie设置新的最后访问时间
							c.setValue(lastTime);
							//覆盖掉原来的cookie
							response.addCookie(c);
//							设置3s后跳转
							response.getWriter().write("登录成功, 3s后回到主页...");
							response.setHeader("refresh","3;url=" + context.getContextPath() + "/index.jsp"); 				}else {
							c = new Cookie("lastTime", lastTime);
							c.setPath("/");
							c.setMaxAge(60 * 60 * 24 * 180);
							request.setAttribute("lastTime", lastTime);
							response.addCookie(c);
//							设置3s后跳转
							response.getWriter().write("登录成功, 3s后回到主页...");
							response.setHeader("refresh","3;url=" + context.getContextPath() + "/index.jsp"); 
						}
					}else {
						Cookie c = new Cookie("lastTime", lastTime);
						c.setPath("/");
						c.setMaxAge(60 * 60 * 24 * 180);
						request.setAttribute("lastTime", lastTime);
						response.addCookie(c);
//						设置3s后跳转
						response.getWriter().write("登录成功, 3s后回到主页...");
						response.setHeader("refresh","3;url=" + context.getContextPath() + "/index.jsp"); 			}

					return;
				}
				else {
					request.setAttribute("error_msg","账号或者密码有错");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
			}
		}else if(ope.equals("userList")) {
			userList(request,response);
			request.getRequestDispatcher("/userList.jsp").forward(request, response);
		}
		
		
	}

	private void userList(HttpServletRequest request, HttpServletResponse response) {
		ITravelShareService tss = new TravelShareService();
		List<User> list = tss.findAll();
		request.setAttribute("list", list);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
