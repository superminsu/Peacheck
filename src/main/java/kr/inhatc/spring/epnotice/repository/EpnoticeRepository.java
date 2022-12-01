package kr.inhatc.spring.epnotice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.epnotice.entity.Epnotice;

public interface EpnoticeRepository extends JpaRepository<Epnotice, Long>{

}
