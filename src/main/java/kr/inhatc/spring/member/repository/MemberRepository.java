package kr.inhatc.spring.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
    
    Member findByIdAndPassword(String id, String password);
    Member findByPosition(String position);
    Member findById(String id);
}
