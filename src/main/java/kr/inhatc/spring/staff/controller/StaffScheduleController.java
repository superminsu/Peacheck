package kr.inhatc.spring.staff.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.inhatc.spring.staff.entity.StaffSchedule;
import kr.inhatc.spring.staff.service.StaffScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StaffScheduleController {

    private final StaffScheduleService staffScheduleService;
    
    //직원 스케쥴 등록
    @PostMapping("staff/schedule/save")
    public StaffSchedule saveSchedule(StaffSchedule staffSchedule) {
        log.info("StaffScheduleController saveSchedule()");
        StaffSchedule saveSchedule = staffScheduleService.saveStaffSchedule(staffSchedule);
        return saveSchedule;
    }
    
    //직원 스케쥴 리턴
    @PostMapping("staff/schedule/find")
    public List<StaffSchedule> findSchedule(Long spNo, String name){
        log.info("StaffScheduleController findSchedule()");
        List<StaffSchedule> findSchedule = staffScheduleService.findStaffSchedule(spNo, name);
        return findSchedule;
    }
    
    //직원 스케쥴 수정
    @PostMapping("staff/schedule/update")
    public StaffSchedule updateSchedule(Long schNo,StaffSchedule staffSchedule) {
        return null;
    }
    
    //직원 스케쥴 삭제
    @PostMapping("staff/schedule/delete")
    public StaffSchedule deleteSchedule(Long schNo) {
        return null;
    }
}
