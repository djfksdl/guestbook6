package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	//필드
	@Autowired
	private GuestbookService guestbookService;
	
	//메인화면
	@RequestMapping(value="/alform", method= {RequestMethod.GET, RequestMethod.POST })
	public String alform(Model model) {
		System.out.println("GuestbookController.alform");
		
		//서비스로 전달해서 전체 리스트 받아오기
		List<GuestbookVo> guestList = guestbookService.exeList();
		
		//attribute에 넣어주기
		model.addAttribute("guestList" ,guestList);
		
		return "addList";
	}
	
	//등록
	@RequestMapping(value="/register" ,method= {RequestMethod.GET, RequestMethod.POST})
	public String register(@ModelAttribute GuestbookVo guestbookVo) {//name,password,content받기
		System.out.println("GuestbookController.register");
		
		//vo를 서비스에 전달
		guestbookService.exeRegister(guestbookVo);
		
		return "redirect:/alform";//리스트로 리다이렉트
	}
	//삭제폼
	@RequestMapping(value="/dform" ,method= {RequestMethod.GET, RequestMethod.POST})
	public String dform() {//no jsp에 숨겨서 가져오기
		System.out.println("GuestbookController.dform");
		
		return "deleteForm";//포워드
	}
	//삭제
	@RequestMapping(value="/delete" ,method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {//no, password넘기기
		System.out.println("GuestbookController.delete");
		
		//vo를 서비스로 전달
		guestbookService.exeDelete(guestbookVo);
		return "redirect:/alform";//리다이렉트
	}
}
