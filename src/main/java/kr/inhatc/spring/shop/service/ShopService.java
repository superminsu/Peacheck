package kr.inhatc.spring.shop.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.inhatc.spring.shop.dto.ShopFormDto;
import kr.inhatc.spring.shop.entity.Shop;
import kr.inhatc.spring.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor // @AutoWired 없이도 repository를 메모리에 올릴 수 있음 ( final 반드시 추가, 테스트에서는 오류남 )
@Slf4j
public class ShopService {

    private final ShopRepository shopRepository;
    
    // 회원 매장 리턴
    public List<Shop> findShop(String id) {
        try {
            log.info("주인 아이디 : " + id);
            List<Shop> findShop = shopRepository.findById(id);
            log.info("매장 정보 : " + findShop);
            
            return findShop;
        } catch (Exception e) {
            log.info("값이 없음");
            return null;
        }
    }
    
    // 매장 등록
    public Shop saveShop(Shop shop) {
        log.info("매장 정보 : " + shop);
        return shopRepository.save(shop);
    }
}
