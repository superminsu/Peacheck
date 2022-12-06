package kr.inhatc.spring.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.shop.entity.ShopStaff;

public interface ShopStaffRepository extends JpaRepository<ShopStaff, Long>{

    ShopStaff findByIdAndShop_SpNo(String id, Long spNo);
    List<ShopStaff> findByShop_SpNo(Long spNo);
}
