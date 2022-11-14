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

@Service
@Transactional
@RequiredArgsConstructor // @AutoWired 없이도 repository를 메모리에 올릴 수 있음 ( final 반드시 추가, 테스트에서는 오류남 )
public class ShopService {

    private final ShopRepository shopRepository;
    
    // 회원 매장 리턴
    public List<Shop> shopFind(String id) {
        try {
            System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + id);
            List<Shop> findShop = shopRepository.findById(id);
            System.out.println(findShop);
            
            return findShop;
        } catch (Exception e) {
            System.out.println("값이 없음");
            return null;
        }
    }
    
    // 매장 등록
    public Shop shopSave(Shop shop) {
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + shop.getId());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + shop.getName());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + shop.getCity());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + shop.getArea());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + shop.getAddress());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + shop.getPhone());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + shop.getSector());
        return shopRepository.save(shop);
    }
}
