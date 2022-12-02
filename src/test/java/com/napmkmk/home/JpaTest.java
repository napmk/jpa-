package com.napmkmk.home;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.napmkmk.home.dto.MemberDto;
import com.napmkmk.home.repository.MemberRepository;

@SpringBootTest
@TestPropertySource(locations ="classpath:application-test.properties")
public class JpaTest {
	
	@Autowired
	MemberRepository memberRepository;
	
//	@Test
//	@DisplayName("이름 검색 테스트")
//	public void searchName() {
//		List<MemberDto> dtos = memberRepository.findByNameContaining("길");
//		
//		for(MemberDto memberDto : dtos) {
//			System.out.println(memberDto.toString());
//		};
//		
//		
//	}
//	
	
//	@Test
//	@DisplayName("회원 삭제 테스트") // DELETE
//	public void deleteMember() {
//		Long hak = (long) 1;
//		
//		Optional<MemberDto> memberDto = memberRepository.findById(hak);
//		assertTrue(memberDto.isPresent());// 존재확인
//		
//		MemberDto dto = memberDto.get();
//		
//		memberRepository.delete(dto);
//		
//		List<MemberDto> memberDtos = memberRepository.findAll();
//		
//		
//		for(MemberDto Dto : memberDtos) {
//			System.out.println(Dto.toString());
//		};
//		
//		
//		
//		
//	}

//	@Test
//	@DisplayName("회원 삭제 테스트") // DELETE
//	public void deleteMember() {
//		Long hak = (long) 2;
//		
//
//		
//		memberRepository.deleteById(hak);
//		
//		List<MemberDto> memberDtos = memberRepository.findAll();
//		
//		
//		for(MemberDto Dto : memberDtos) {
//			System.out.println(Dto.toString());
//		};
//		
//		
//		
//		
//	}
	
//	@Test
//	@DisplayName("특정 회원 검색 테스트")
//	public void searchMember() {
//		
//		List<MemberDto> memberDtos = memberRepository.findByNameLike("%동");
//		
//		for(MemberDto Dto : memberDtos) {
//			System.out.println(Dto.toString());
//		};
//			
//	}
	
	
//	@Test
//	@DisplayName("특정 회원 삭제") // DELETE
//	public void deleteMember() {
//		memberRepository.deleteById(3L); //3번 Long 형을 지워라
//		List<MemberDto> memberDtos = memberRepository.findAll();
//		
//		for(MemberDto Dto : memberDtos) {
//			System.out.println(Dto.toString());
//		};
//	}
	
	@Test
	@DisplayName("회원 정보 수정 테스트")  //UPDATE
	public void modifyMember() {
		
	
		Optional<MemberDto> memberDto = memberRepository.findById(3L);
		assertTrue(memberDto.isPresent());// 존재확인
		
		MemberDto dto = memberDto.get();
		dto.setName("이순신"); //이름수정
		
		memberRepository.save(dto);
		
		List<MemberDto> memberDtos = memberRepository.findAll();
		
		
		for(MemberDto Dto : memberDtos) {
			System.out.println(Dto.toString());
		};
		
	}
	
}
