package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;

public class editCartCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CVO cvo = new CVO();
		cvo.setAmount(request.getParameter("amount"));
		cvo.setId(request.getParameter("id"));
		cvo.setP_num(request.getParameter("p_num"));
		
		int result = DAO.getCartAmountUpdate(cvo);
		
		return "MyController?cmd=showCart";
	}
}
