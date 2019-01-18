package com.wyt.shoppingCar.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyt.shoppingCar.domain.CartItem;
import com.wyt.shoppingCar.domain.Goods;
import com.wyt.shoppingCar.domain.ShoppingCart;
import com.wyt.shoppingCar.service.IShoppingCarService;
import com.wyt.shoppingCar.service.impl.ShoppingCarService;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 
     */
    public ShoppingServlet() {

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
		
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if(cmd.equals("add")) {
			addItem(request, response);
		}else if(cmd.equals("findAll")) {
			
			showGoods(request, response);
			request.getRequestDispatcher("/goodsList.jsp").forward(request, response);
		}else if(cmd.equals("join")) {
			addItem(request, response);
			request.getRequestDispatcher("/ShoppingServlet?cmd=findAll").forward(request, response);
		}else if(cmd.equals("findCar")) {
			findCar(request, response);
			request.getRequestDispatcher("/cartList.jsp").forward(request, response);
		}else if(cmd.equals("del")){
			del(request, response);
			request.getRequestDispatcher("/ShoppingServlet?cmd=findCar").forward(request, response);
		}else if(cmd.equals("clear")) {
			clear(request, response);
			request.getRequestDispatcher("/ShoppingServlet?cmd=findCar").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 添加到购物车
	 * @param request
	 * @param response
	 */
	private void addItem(HttpServletRequest request,HttpServletResponse response) {
		String goodsId = request.getParameter("goodsId");
		String goodsName = request.getParameter("goodsName");
		double goodsPrice = Double.parseDouble(request.getParameter("goodsPrice"));
		CartItem goods = new CartItem(goodsId,goodsName,1,goodsPrice);
		@SuppressWarnings("unchecked")
		List<CartItem> list = (List<CartItem>) request.getSession().getAttribute("list");
		if(list == null) {
			list = new ArrayList<>();
		}
		int a = 0;
		for (CartItem cartItem : list) {
			if(goodsId.equals(cartItem.getId())) {
				cartItem.setNumber(cartItem.getNumber() + 1);
				a++;
			}
		}
		if(a == 0) {
			list.add(goods);
		}
		request.getSession().setAttribute("list", list);
	}
	
	/**
	 * 显示所有商品信息
	 * @param request
	 * @param response
	 */
	private void showGoods(HttpServletRequest request,HttpServletResponse response) {
		IShoppingCarService scs = new ShoppingCarService();
		List<Goods> list = scs.findAll();
		request.setAttribute("list", list);
	}
	/**
	 * 显示购物车
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	private void findCar(HttpServletRequest request,HttpServletResponse response) {
		List<CartItem> list = (List<CartItem>) request.getSession().getAttribute("list");
		request.getSession().setAttribute("list", list);
		
	}
	/**
	 * 删除购物车商品
	 */
	private void del(HttpServletRequest request,HttpServletResponse response) {
		String userId = request.getParameter("userId");
		@SuppressWarnings("unchecked")
		List<CartItem> list2 = (List<CartItem>) request.getSession().getAttribute("list");
		List<CartItem> list = new ArrayList<>();
		for (CartItem cartItem : list2) {
			if(!userId.equals(cartItem.getId())) {
				list.add(cartItem);
			}
		}
		request.getSession().setAttribute("list", list);
	}
	
	/**
	 * 清空购物车
	 * @param request
	 * @param response
	 */
	private void clear(HttpServletRequest request,HttpServletResponse response) {
		List<CartItem> list = new ArrayList<>();
		request.getSession().setAttribute("list", list);
	}
}
