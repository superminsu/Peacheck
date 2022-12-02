package kr.inhatc.spring.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.staff.entity.StaffSchedule;

public interface StaffScheduleRepository extends JpaRepository<StaffSchedule, Long>{

    List<StaffSchedule> findByShop_ShopnumberAndName(Long spNo, String name);
}
