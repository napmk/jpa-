package com.napmkmk.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napmkmk.home.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, Long>{ //<엔티티의 클래스타입, 기본키 타입>
	public List<MemberDto> findByName(String membername); //findBy select구문
	public MemberDto findByHakbun(Long hakbun); //findBy select구문
	public List<MemberDto> findByNameOrderByHakbunDesc(String membername);// 학번을 기준으로 이름을 찾아라 select구문
	public List<MemberDto> findAllByOrderByHakbunDesc();
	public List<MemberDto> findByNameAndGrade(String memberName, int grade);  //그리고
	public List<MemberDto> findByAgeLessThan(int age);//LessThan 미만 <
	public List<MemberDto> findByAgeLessThanEqual(int age);//LessThanEqul 이하 <=
	public List<MemberDto> findByAgeGreaterThan(int age);// 초과 >
	public List<MemberDto> findByAgeGreaterThanEqual(int age);// 이상 >=
	public List<MemberDto> findByAgeBetween(int startage, int endAge);// 사이  =< x =<
	public List<MemberDto> findByNameStartingWith(String namekey);// 특정문자포함 맨앞
	public List<MemberDto> findByNameEndingWith(String namekey);// 특정문자포함 맨뒤
	public List<MemberDto> findByNameContaining(String namekey);// 특정단어포함
	public List<MemberDto> findByNameLike(String namekey);// 특정단어포함
	
	//데이터 삭제(delete)
	public void deleteAllByName(String name); // 이름으로 조회하여 삭제
}
