package com.ict.db;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}
	
	// 리스트
	public static List<VO> getList(String category){
		List<VO> list = null;
		list = getSession().selectList("list", category);
		return list;
	}
	
	// 상세보기
	public static VO getOneList(String idx) {
		VO vo = null;
		vo = getSession().selectOne("onelist", idx);
		return vo;
	}
	
	// 로그인 
	public static MVO getLogIn(MVO m_vo) {
		MVO mvo = null;
		mvo = getSession().selectOne("login", m_vo);
		return mvo;
	}
	
	// cartsearch
	public static CVO getCartSearch(String id, String p_num)
	{
		CVO cvo = null;
		CVO c_vo = new CVO();
		c_vo.setId(id);
		c_vo.setP_num(p_num);
		cvo = getSession().selectOne("cartSearch", c_vo);
		return cvo;
		
	}
	
	// cartinsert
	public static int getCartInsert(CVO c_vo)
	{
		int result = 0;
		result = getSession().insert("cartInsert", c_vo);
		ss.commit();
		return result;
	}
	
	// cartupdate
	public static int getCartUpdate(CVO cvo)
	{
		int result = 0;
		result = getSession().update("cartUpdate", cvo);
		ss.commit();
		return result;
	}
	
	// cartlist
	public static List<VO> getCartList(String id)
	{
		List<VO> clist = null;
		clist = getSession().selectList("cartList",id);
		ss.commit();
		return clist;
	}
	
	// cartdelete
	public static int getCartDelete(CVO cvo)
	{
		int result = 0;
		result = getSession().delete("cartDelete", cvo);
		ss.commit();
		return result;
	}
	
	// cartamountupdate
	public static int getCartAmountUpdate(CVO cvo)
	{
		int result = 0;
		result = getSession().update("cartAmountUpdate", cvo);
		ss.commit();
		return result;
	}
	
}

















