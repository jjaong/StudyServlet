package com.jw.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.jw.common.JDBCTemplate;
import com.jw.model.dao.SubwayDao;
import com.jw.model.vo.Order;

public class SubwayService {
	public int insertOrder(Order order) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new SubwayDao().insertOrder(conn, order);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public ArrayList<Order> selectOrderList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Order> list = new SubwayDao().selectOrderList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
}
