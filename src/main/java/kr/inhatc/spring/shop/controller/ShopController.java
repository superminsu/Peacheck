package kr.inhatc.spring.shop.controller;

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
import kr.inhatc.spring.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor //@AutoWired 없이도 repository를 메모리에 올릴 수 있음 ( final 반드시 추가, 테스트에서는 오류남 )
public class ShopController {

    private final ShopService shopService;
    
    @PostMapping("/shop/find")
    public ShopFormDto find(ShopFormDto dto) {
        log.info("ShopController shopFind()");
        ShopFormDto sendDto = shopService.shopFind(dto);
        return sendDto;
    }
    
    @PostMapping("/shop/save")
    public Shop save(Shop shop) {
        log.info("ShopController shopSave()");
        Shop saveShop = shopService.shopSave(shop);
        return saveShop;
    }
}
