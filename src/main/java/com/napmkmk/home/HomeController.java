package com.napmkmk.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String join(HttpServletRequest request, Model model) {
		 
	
		 String name = request.getParameter("name");
		 int age = Integer.parseInt(request.getParameter("age")); //int 로 형변환
		 int grade = Integer.parseInt(request.getParameter("grade"));
		 String etc = request.getParameter("etc");
		 
		 MemberDto memberDto = new MemberDto();
		 
		 memberDto.setName(name);
		 memberDto.setAge(age);
		 memberDto.setGrade(grade);
		 memberDto.setEtc(etc);
		
		 MemberDto mDto = memberRepository.save(memberDto); //save INSERT
		 System.out.println(mDto.toString());
		 
		 model.addAttribute("mDto",mDto);
		 
		return "joinOk" ;
	}
	
	@RequestMapping(value = "/search")
	public String search() {
		return "search";
	}
	
	@RequestMapping(value = "/searchOk")
	public String search(Model model, HttpServletRequest request) {
		
		//List<MemberDto> memberDtos = memberRepository.findByName(request.getParameter("searchName"));
		List<MemberDto> memberDtos = memberRepository.findByNameOrderByHakbunDesc(request.getParameter("searchName"));
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		model.addAttribute("searchDto",memberDtos);
		
		return "searchResult";
	}
	
	@RequestMapping(value = "/allmember")
	public String allmember(Model model) {
		
		List<MemberDto> memberDtos= memberRepository.findAll(Sort.by(Sort.Direction.DESC,"hakbun")); //모든회원정보 가져올때 정렬은 소트
		
		List<MemberDto> memberDtos2 = memberRepository.findAllByOrderByHakbunDesc();// 모든리스트정보 가져올때 Repositor 함수가져오기 동일해야됨.
 		
		//model.addAttribute("allmember",memberDtos);
		model.addAttribute("allmember",memberDtos2);
		return "allmember";
	}
	
	@RequestMapping (value =  "/memberor") //결과만 체크할거야
	public String memberor() {
		
		List<MemberDto> memberDtos= memberRepository.findByNameAndGrade("홍길동", 3); //Or조건으로
		
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		
		return "";
		
	}
	
	@RequestMapping (value = "lessthan")
	public String lessthan() {
		
		List<MemberDto> memberDtos= memberRepository.findByAgeLessThan(30); //미만조건
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		return "";
		}
	
	@RequestMapping (value = "between")
	public String between() {
		
		List<MemberDto> memberDtos= memberRepository.findByAgeBetween(10 ,32); //미만조건
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		return "";
		}
	
	@RequestMapping (value = "like")
	public String like() {
		
		List<MemberDto> memberDtos= memberRepository.findByNameStartingWith("홍"); //홍으로 시작
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		return "";
		}
	

}
