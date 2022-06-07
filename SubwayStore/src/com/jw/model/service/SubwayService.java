package com.jw.model.service;

import java.sql.Connection;

import com.jw.common.JDBCTemplate;
import com.jw.model.dao.SubwayDao;
import com.jw.model.vo.Order;

public class SubwayService {
	public int insertOrder(Order order) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new SubwayDao().insertOrder(conn, order);
		return result;
	}
}
