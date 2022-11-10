package kr.inhatc.spring.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.shop.entity.Shop;


public interface ShopRepository extends JpaRepository<Shop, Long>{
    
    Optional<Shop> findByName(String name);
    List<Shop> findById(String id);
}
