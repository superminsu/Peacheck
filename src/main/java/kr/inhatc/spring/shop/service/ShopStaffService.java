package kr.inhatc.spring.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.member.service.MemberService;
import kr.inhatc.spring.shop.entity.Shop;
import kr.inhatc.spring.shop.entity.ShopStaff;
import kr.inhatc.spring.shop.repository.ShopStaffRepository;
import kr.inhatc.spring.staff.service.StaffCommuteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopStaffService {

    private final ShopStaffRepository shopStaffRepository;
    
    private final MemberService memberService;
    
    private final ShopService shopService;
    
    private final StaffCommuteService staffCommuteService;
    
    //가게 직원 생성하기(직원 생성과 동시에 직원 전용 출퇴근기록표 생성)
    public void saveStaff(String staffId, String onwerId, String shopName) {
        Member findMember = memberService.findMember(staffId);
        Shop findShop = shopService.findShopOne(onwerId, shopName);
        
        if(findMember != null && findShop != null) {
            ShopStaff shopStaff = new ShopStaff();
            shopStaff.setId(staffId);
            shopStaff.setName(findMember.getName());
            shopStaff.setMember(findMember);
            shopStaff.setShop(findShop);
            shopStaffRepository.save(shopStaff);
            staffCommuteService.saveComuute(staffId, onwerId, shopName);
        }
    }
    
    //가게 직원 삭제하기
    public void deleteStaff(String staffId, String onwerId, String shopName) {
        Shop findShop = shopService.findShopOne(onwerId, shopName);
        Long spNo = findShop.getSpNo();
        ShopStaff deleteStaff = shopStaffRepository.findByIdAndShop_SpNo(staffId, spNo);
        shopStaffRepository.delete(deleteStaff);
    }
    
    //가게 직원 리턴
    public ShopStaff findStaff(String staffId, String onwerId, String shopName) {
        Shop findShop = shopService.findShopOne(onwerId, shopName);
        Long spNo = findShop.getSpNo();
        ShopStaff findStaff = shopStaffRepository.findByIdAndShop_SpNo(staffId, spNo);
        return findStaff;
    }
    
    //가게 직원 전체 리턴(직원들의 이름을 전부 보내주기 위해 만듦)
    public List<ShopStaff> findAllStaff(String onwerId, String shopName){
        Shop findShop = shopService.findShopOne(onwerId, shopName);
        Long spNo = findShop.getSpNo();
        List<ShopStaff> findAllStaff = shopStaffRepository.findByShop_SpNo(spNo);
        return findAllStaff;
    }
}
