package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	//필드
	@Autowired
	private GuestbookDao guestbookDao;
	//메소드-일반
	
	//전체 리스트 받아오기
	public List<GuestbookVo> exeList() {
		System.out.println("GuestbookService.exeList");
		
		//Dao에서 전체 리스트 받아오기
		List<GuestbookVo> guestList = guestbookDao.guestList();
		return guestList;
	}
	
	//등록
	public void exeRegister(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeRegister");

		//vo를 Dao에 전달
		guestbookDao.guestInsert(guestbookVo);
	}
	
	//삭제
	public void exeDelete(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeDelete");
		
		//no를 Dao로 전달
		guestbookDao.guestDelete(guestbookVo);
	}
}
