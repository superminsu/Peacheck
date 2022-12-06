package kr.inhatc.spring.shop.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.inhatc.spring.shop.dto.ShopFormDto;
import kr.inhatc.spring.shop.entity.Shop;
import kr.inhatc.spring.shop.entity.ShopNotice;
import kr.inhatc.spring.shop.entity.ShopStaff;
import kr.inhatc.spring.shop.service.ShopNoticeService;
import kr.inhatc.spring.shop.service.ShopService;
import kr.inhatc.spring.shop.service.ShopStaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor //@AutoWired 없이도 repository를 메모리에 올릴 수 있음 ( final 반드시 추가, 테스트에서는 오류남 )
@Slf4j
public class ShopController {

    private final ShopService shopService;
    
    private final ShopNoticeService shopNoticeService;
    
    private final ShopStaffService shopStaffService;
    
    //매장 등록
    @PostMapping("/shop/save")
    public Shop saveShop(Shop shop) {
        log.info("ShopController shopSave()");
        Shop saveShop = shopService.saveShop(shop);
        return saveShop;
    }
    
    //매장 찾기
    @PostMapping("/shop/find")
    public List<Shop> findShop(String id) {
        log.info("ShopController shopFind()");
        List<Shop> sendShop = shopService.findShop(id);
        return sendShop;
    }
    
    //매장 수정
    @PostMapping("shop/update")
    public String updateShop(Long spNo, Shop shop) {
        shopService.updateShop(spNo, shop);
        return "매장 수정 완료";
    }
    
    //매장 삭제
    @PostMapping("shop/delete")
    public String deleteShop(Long spNo) {
        shopService.deleteShop(spNo);
        return "매장 삭제 완료";
    }
    
    //매장 공지 등록
    @PostMapping("/shop/notice/save")
    public ShopNotice saveNotice(ShopNotice shopNotice) {
        log.info("ShopController saveNotice");
        ShopNotice saveShopNotice = shopNoticeService.saveShopNotice(shopNotice);
        return saveShopNotice;
    }
    
    //매장 공지 찾기
    @PostMapping("shop/notice/find")
    public List<ShopNotice> findNotice(Long spNo){
        log.info("ShopController findNotice");
        List<ShopNotice> sendNotice = shopNoticeService.findShopNotice(spNo);
        return sendNotice;
    }
    
    //매장 공지 수정
    @PostMapping("shop/notice/update")
    public String updateNotice(Long spnoticeNo, ShopNotice shopNotice) {
        shopNoticeService.updateShopNotice(spnoticeNo, shopNotice);
        return "매장공지 수정 완료";
    }
    
    //매장 공지 삭제
    @PostMapping("shop/notice/delete")
    public String deleteNotice(Long spnoticeNo) {
        shopNoticeService.deleteShopNotice(spnoticeNo);
        return "매장공지 삭제 완료";
    }
    
    //매장 직원 등록
    @PostMapping("shop/staff/save")
    public String saveStaff(String staffId, String onwerId, String shopName) {
        shopStaffService.saveStaff(staffId, onwerId, shopName);
        return "직원 생성 완료";
    }
    
    //매장 직원 삭제
    @PostMapping("shop/staff/delete")
    public String deleteStaff(String staffId, String onwerId, String shopName) {
        shopStaffService.deleteStaff(staffId, onwerId, shopName);
        return "직원 삭제 완료";
    }
    
    //매장 직원 리턴(한명)
    @PostMapping("shop/staff/findOne")
    public ShopStaff findStaff(String staffId, String onwerId, String shopName) {
        ShopStaff findStaff = shopStaffService.findStaff(staffId, onwerId, shopName);
        return findStaff;
    }
}
