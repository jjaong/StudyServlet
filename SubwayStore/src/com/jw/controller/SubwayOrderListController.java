package com.jw.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jw.model.service.SubwayService;
import com.jw.model.vo.Order;

/**
 * Servlet implementation class SubwayOrderListController
 */
@WebServlet("/orderList.sandwich")
public class SubwayOrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubwayOrderListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Order> list = new SubwayService().selectOrderList();
		
		if(list.isEmpty()) {
			request.setAttribute("alertMsg", "조회결과가 없습니다.");
		}else {
			request.setAttribute("alertMsg", "조회결과가 있습니다.");
		}
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
