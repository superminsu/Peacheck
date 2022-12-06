package kr.inhatc.spring.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    //매장 공지 리턴 - 프론트에서 보내주는 매장 Long spNo 이용하여 찾기
    public List<ShopNotice> findShopNotice(Long spNo){
        try {
            log.info("spNo : " + spNo);
            List<ShopNotice> findSNotice = shopNoticeRepository.findByShop_Shopnumber(spNo);
            return findSNotice;
        } catch (Exception e) {
            log.info("값이 없음");
            return null;
        }
    }
    
    //매장 공지 등록
    public ShopNotice saveShopNotice(ShopNotice shopNotice) {
        return shopNoticeRepository.save(shopNotice);
    }

    //매장 공지 수정
    public void updateShopNotice(Long spnoticeNo, ShopNotice shopNotice) {
        log.info("매장공지 번호 : " + spnoticeNo);
        Optional<ShopNotice> updateNoticeWrapper = shopNoticeRepository.findById(spnoticeNo);
        ShopNotice updateNotice = updateNoticeWrapper.get();
        
        if(updateNotice != null) {
            updateNotice.setTitle(shopNotice.getTitle());
            updateNotice.setBody(shopNotice.getBody());
        }
    }
    
    //매장 공지 삭제
    public void deleteShopNotice(Long spnoticeNo) {
        shopNoticeRepository.deleteById(spnoticeNo);
    }
}
