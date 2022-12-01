package com.napmkmk.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.napmkmk.home.dto.MemberDto;
import com.napmkmk.home.repository.MemberRepository;

@Controller
public class HomeController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping( value =  "/join")
	public String join() {
		
		
		
		return "join" ;
	}
	
	@RequestMapping( value =  "/joinOk")
	public String join(HttpServletRequest request) {
		 
		 String id = request.getParameter("id");
		 String name = request.getParameter("name");
		 int age = Integer.parseInt(request.getParameter("age")); //int 로 형변환
		 int grade = Integer.parseInt(request.getParameter("grade"));
		 String etc = request.getParameter("etc");
		 
		 MemberDto memberDto = new MemberDto();
		 memberDto.setId(id);
		 memberDto.setName(name);
		 memberDto.setAge(age);
		 memberDto.setGrade(grade);
		 memberDto.setId(etc);
		
		 MemberDto mDto = memberRepository.save(memberDto);
		 System.out.println(mDto.toString());
		 
		 
		return "joinOk" ;
	}
}
