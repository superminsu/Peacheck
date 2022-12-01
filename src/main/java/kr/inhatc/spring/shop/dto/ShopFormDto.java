package kr.inhatc.spring.shop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ShopFormDto {

    private Long spNo;
    
    private String id;
    
    private String name;
    
    private String city;
    
    private String area;
    
    private String address;
    
    private String phone;
    
    private String sector;
}
