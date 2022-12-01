package kr.inhatc.spring.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberFormDto {
    
    private Long mbrNo;
    
    private String id;
    
    private String password;
    
    private String name;
    
    private String birthday;
    
    private String city;
    
    private String area;
    
    private String phone;
    
    private String position;
}
