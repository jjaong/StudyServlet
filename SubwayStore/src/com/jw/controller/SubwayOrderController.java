package com.jw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jw.model.service.SubwayService;
import com.jw.model.vo.Order;

/**
 * Servlet implementation class SubwayOrderController
 */
@WebServlet("/order.do")
public class SubwayOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubwayOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		String sandwich = request.getParameter("sandwich");
		String[] toppings = request.getParameterValues("topping");
		String[] cookies = request.getParameterValues("cookie");
		String payment  = request.getParameter("payment");
		
		int price =0;
		
		
		switch(sandwich) {
		case "참치" :price += 5500; break;
		case "에그마요":price+=4300; break;
		case "이탈리안비엘티" :price += 5300; break;
		case "터키베이컨아보카도" :
		case "로티세리바베큐치킨":price+=6300; break;
		case "치즈N스테이크" : price+=6500; break;
		
		}
		
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				switch(cookies[i]) {
				case "라즈베리치즈케잌" :
				case "더블초코칩쿠키" :
				case "스모어초코" : price += 1500; break;
				}
			}
		}
		
		Order order = new Order(
				userName, 
				phone, 
				address,
				message, 
				sandwich, 
				String.join(",", toppings),
				String.join(",", cookies),
				payment,
				price,
				null);
		
		int result = new SubwayService().insertOrder(order);
		
		request.setAttribute("sandwich", sandwich);
		request.setAttribute("toppings", toppings);
		request.setAttribute("cookies", cookies);
		request.setAttribute("payment", payment);
		
		request.setAttribute("price", price);
		
		if(result>0) {
			RequestDispatcher view = request.getRequestDispatcher("views/result.jsp");
			
			view.forward(request, response);
		}
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
