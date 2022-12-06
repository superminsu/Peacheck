package kr.inhatc.spring.staff.service;

import org.springframework.stereotype.Service;

import kr.inhatc.spring.staff.entity.StaffCommute;
import kr.inhatc.spring.staff.repository.StaffCommuteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffCommuteService {
    
    private final StaffCommuteRepository staffCommuteRepository;

    //출퇴근기록표 생성(매장에 직원 등록과 동시에 같이 생성)
    public StaffCommute saveComuute(StaffCommute staffCommute) {
        return staffCommuteRepository.save(staffCommute);
    }
}
