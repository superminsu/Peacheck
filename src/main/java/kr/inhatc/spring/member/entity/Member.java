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
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mbrNo 값을 null로 하면 DB가 알아서 AUTO_INCREMENT 해준다
    @Column(name="member_number")
    private Long mbrNo;
     
    private String id;          //아이디
    
    private String password;    //비밀번호
    
    private String name;        //이름
    
    private String birthday;    //생년월일
    
    private String city;        //도시
    
    private String area;        //지역구
    
    private String phone;       //전화번호
    
    private String position;    //직급
    
    
    public static Member createMember(MemberFormDto memberFormDto) {
        
        Member member = new Member();
        member.setId(memberFormDto.getId());
        member.setPassword(memberFormDto.getPassword());    
        member.setName(memberFormDto.getName());
        member.setBirthday(memberFormDto.getBirthday());
        member.setCity(memberFormDto.getCity());
        member.setArea(memberFormDto.getArea());
        member.setPhone(memberFormDto.getPhone());
        member.setPosition(memberFormDto.getPosition());
        return member;
    }
}
