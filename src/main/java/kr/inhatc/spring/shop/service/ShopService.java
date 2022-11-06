package kr.inhatc.spring.shop.service;

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
    
    // 회원 매장 찾기
    public ShopFormDto shopFind(ShopFormDto shopFormDto) {
        try {
            System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + shopFormDto.getId());
            Shop findMember = shopRepository.findById(shopFormDto.getId());
            if (findMember.getId() != null)
                return shopFormDto;
            return null;
        } catch (Exception e) {
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
