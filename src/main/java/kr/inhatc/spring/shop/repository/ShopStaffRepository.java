package kr.inhatc.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.shop.entity.ShopStaff;

public interface ShopStaffRepository extends JpaRepository<ShopStaff, Long>{

    ShopStaff findByIdAndShop_Shopnumber(String id, Long spNo);
}
