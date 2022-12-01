package kr.inhatc.spring.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.shop.entity.ShopNotice;

public interface ShopNoticeRepository extends JpaRepository<ShopNotice, Long>{

    List<ShopNotice> findByShop_Shopnumber(Long spNo);
}
