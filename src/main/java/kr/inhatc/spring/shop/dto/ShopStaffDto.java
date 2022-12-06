package kr.inhatc.spring.shop.dto;

import org.modelmapper.ModelMapper;

import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.shop.entity.Shop;
import kr.inhatc.spring.shop.entity.ShopStaff;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShopStaffDto {

    private Long sfNo;
    
    private String id;
    
    private String name;
    
    private Shop shop;
    
    private Member member;
    
   private static ModelMapper modelMapper = new ModelMapper();
   
   public ShopStaff createShopStaff() {
       //Dto -> Entity
       return modelMapper.map(this, ShopStaff.class);
   }
   
   public static ShopStaffDto of(ShopStaff shopStaff) {
       //Entity -> Dto
       return modelMapper.map(shopStaff, ShopStaffDto.class);
   }
}
