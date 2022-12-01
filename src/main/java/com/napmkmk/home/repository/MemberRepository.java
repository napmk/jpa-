package com.napmkmk.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napmkmk.home.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, String>{ //<엔티티의 클래스타입, 기본키 타입>

}
