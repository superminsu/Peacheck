package kr.inhatc.spring.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.inhatc.spring.shop.entity.Shop;
import kr.inhatc.spring.shop.entity.ShopNotice;
import kr.inhatc.spring.shop.repository.ShopNoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ShopNoticeService {
    
    private final ShopNoticeRepository shopNoticeRepository;
    
    private final ShopService shopService;
    
    //매장 공지 리턴 - 프론트에서 보내주는 매장 Long spNo 이용하여 찾기
    public List<ShopNotice> findShopNotice(Long spNo){
        try {
            log.info("spNo : " + spNo);
            List<ShopNotice> findNotice = shopNoticeRepository.findByShop_SpNo(spNo);
            return findNotice;
        } catch (Exception e) {
            log.info("값이 없음");
            return null;
        }
    }
    
    //매장 공지 등록
    public ShopNotice saveShopNotice(ShopNotice shopNotice, String onwerId, String shopName) {
        Shop findShop = shopService.findShopOne(onwerId, shopName);
        ShopNotice saveNotice = new ShopNotice();
        if(findShop != null) {
            saveNotice.setTitle(shopNotice.getTitle());
            saveNotice.setBody(shopNotice.getBody());
            saveNotice.setShop(findShop);
            shopNoticeRepository.save(saveNotice);
        }
        return saveNotice;
    }

    //매장 공지 수정
    public void updateShopNotice(Long spnoticeNo, ShopNotice shopNotice) {
        log.info("매장공지 번호 : " + spnoticeNo);
        Optional<ShopNotice> updateNoticeWrapper = shopNoticeRepository.findById(spnoticeNo);
        ShopNotice updateNotice = updateNoticeWrapper.get();
        
        if(updateNotice != null) {
            updateNotice.setTitle(shopNotice.getTitle());
            updateNotice.setBody(shopNotice.getBody());
            shopNoticeRepository.save(updateNotice);
        }
    }
    
    //매장 공지 삭제
    public void deleteShopNotice(Long spnoticeNo) {
        shopNoticeRepository.deleteById(spnoticeNo);
    }
}
