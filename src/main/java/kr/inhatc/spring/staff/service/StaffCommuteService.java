package kr.inhatc.spring.staff.service;

import org.springframework.stereotype.Service;

import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.member.service.MemberService;
import kr.inhatc.spring.shop.entity.Shop;
import kr.inhatc.spring.shop.service.ShopService;
import kr.inhatc.spring.staff.entity.StaffCommute;
import kr.inhatc.spring.staff.repository.StaffCommuteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffCommuteService {
    
    private final StaffCommuteRepository staffCommuteRepository;
    
    private final MemberService memberService;
    
    private final ShopService shopService;

    //출퇴근기록표 생성(매장에 직원 등록과 동시에 같이 생성)
    public void saveComuute(String staffId, String onwerId, String shopName) {
        Member findMember = memberService.findMember(staffId);
        Shop findShop = shopService.findShopNumber(onwerId, shopName);
        
        if(findMember != null && findShop != null) {
            StaffCommute staffCommute = new StaffCommute();
            staffCommute.setId(staffId);
            staffCommute.setYear("");
            staffCommute.setMonth("");
            staffCommute.setDate("");
            staffCommute.setArrival("");
            staffCommute.setLeave("");
            staffCommute.setCheck("");
            staffCommute.setMember(findMember);
            staffCommute.setShop(findShop);
            staffCommuteRepository.save(staffCommute);
        }
    }
}
