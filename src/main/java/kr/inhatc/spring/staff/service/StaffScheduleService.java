package kr.inhatc.spring.staff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.inhatc.spring.shop.entity.Shop;
import kr.inhatc.spring.shop.service.ShopService;
import kr.inhatc.spring.staff.entity.StaffSchedule;
import kr.inhatc.spring.staff.repository.StaffScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffScheduleService {

    private final StaffScheduleRepository staffScheduleRepository;
    
    private final ShopService shopService;
    
    // 직원 스케쥴 등록
    public StaffSchedule saveStaffSchedule(StaffSchedule staffSchedule, String onwerId, String shopName){
        Shop findShop = shopService.findShopOne(onwerId, shopName);
        StaffSchedule saveSchedule = new StaffSchedule();
        if(findShop != null) {
            saveSchedule.setStartDate(staffSchedule.getStartDate());
            saveSchedule.setEndDate(staffSchedule.getEndDate());
            saveSchedule.setStartTime(staffSchedule.getStartTime());
            saveSchedule.setEndTime(staffSchedule.getEndTime());
            saveSchedule.setShop(findShop);
            saveSchedule.setName(staffSchedule.getName());
            staffScheduleRepository.save(saveSchedule);
        }
        return saveSchedule;
    }
    
    // 직원 스케쥴 리턴
    public List<StaffSchedule> findStaffSchedule(Long spNo, String name){
        try {
            log.info("매장 번호 :" + spNo + "이름 : " + name);
            List<StaffSchedule> findSchedule = staffScheduleRepository.findByShop_SpNoAndName(spNo, name);
            return findSchedule;
        } catch (Exception e) {
            log.info("값이 없음");
            return null;
        }
    }
    
    // 직원 스케쥴 수정
    public void updateStaffSchedule(Long schNo, StaffSchedule staffSchedule){
        log.info("매장 번호 :" + schNo);
        Optional<StaffSchedule> updateScheduleWrapper = staffScheduleRepository.findById(schNo);
        StaffSchedule updateSchedule = updateScheduleWrapper.get();
        
        if(updateSchedule != null) {
            updateSchedule.setStartDate(staffSchedule.getStartDate());
            updateSchedule.setEndDate(staffSchedule.getEndDate());
            updateSchedule.setStartTime(staffSchedule.getStartTime());
            updateSchedule.setEndTime(staffSchedule.getEndTime());
            updateSchedule.setName(staffSchedule.getName());
            staffScheduleRepository.save(updateSchedule);
        }
    }
    
    //직원 스케쥴 삭제
    public void deleteStaffSchedule(Long schNo) {
        staffScheduleRepository.deleteById(schNo);
    }
}
