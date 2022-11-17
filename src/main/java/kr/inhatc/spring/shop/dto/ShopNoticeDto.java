package kr.inhatc.spring.shop.dto;

import org.modelmapper.ModelMapper;

import kr.inhatc.spring.shop.entity.ShopNotice;

public class ShopNoticeDto {

    private String title;
    
    private String body;
    
    private static ModelMapper modelMapper = new ModelMapper();
    
    public ShopNotice createNotice() {
        //Dto -> Entity
        return modelMapper.map(this, ShopNotice.class);
    }
    
    public static ShopNoticeDto of(ShopNotice shopNotice) {
        //Entity -> Dto
        return modelMapper.map(shopNotice, ShopNoticeDto.class);
    }
}
