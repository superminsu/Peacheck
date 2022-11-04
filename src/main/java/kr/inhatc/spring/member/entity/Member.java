package kr.inhatc.spring.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.password.PasswordEncoder;

import kr.inhatc.spring.member.dto.MemberFormDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor  //디폴트 생성자(파라미터가 없는 생성자를 생성)
@AllArgsConstructor //클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;
    
    private String name;
    
    private String password;
    
    private String birthday;
    
    private String city;
    
    private String area;
    
    private String phone;
    
    private String position;
    
    
    public static Member createMember(MemberFormDto memberFormDto) {
        
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setPassword(memberFormDto.getPassword());    
        member.setBirthday(memberFormDto.getBirthday());
        member.setCity(memberFormDto.getCity());
        member.setArea(memberFormDto.getArea());
        member.setPhone(memberFormDto.getPhone());
        member.setPosition(memberFormDto.getPosition());
        return member;
    }
}
