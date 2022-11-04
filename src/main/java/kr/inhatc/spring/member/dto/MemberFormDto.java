package kr.inhatc.spring.member.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberFormDto {
    
    private String name;
    
    private String password;
    
    private String birthday;
    
    private String city;
    
    private String area;
    
    private String phone;
    
    private String position;
}
