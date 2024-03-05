package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	//메소드
	
	//전체 리스트 받아오기
	public List<GuestbookVo> guestList() {
		System.out.println("GuestbookDao.guestList");
		
		//selectList로 전체 리스트 불러오기
		List<GuestbookVo> guestList = sqlSession.selectList("guestbook.selectList");
		
		return guestList;
	}
	
	//등록
	public void guestInsert(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.guestInsert");
		
		//insert로 등록
		sqlSession.insert("guestbook.insert",guestbookVo);
	}
	
	//삭제
	public void guestDelete(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.guestDelete");
		
		//delete로 삭제
		sqlSession.delete("guestbook.delete", guestbookVo);
	}
}
