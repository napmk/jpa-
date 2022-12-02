package com.napmkmk.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napmkmk.home.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, Long>{ //<엔티티의 클래스타입, 기본키 타입>
	public List<MemberDto> findByName(String membername); //findBy select구문
}
