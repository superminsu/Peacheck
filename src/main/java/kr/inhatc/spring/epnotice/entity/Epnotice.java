package kr.inhatc.spring.epnotice.entity;

import javax.persistence.Entity;

import kr.inhatc.spring.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor  //파라미터가 없는 기본 생성자 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 생성
public class Epnotice {

    private Long id;
    
    private String title;   //제목
    
    private String sector;  //분야
    
    private String body;    //본문
    
    private String area;    //지역
    
    private Member member;  //공지 올린 사장id
}
