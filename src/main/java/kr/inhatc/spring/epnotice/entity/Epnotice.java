package kr.inhatc.spring.epnotice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "epnotice_number")
    private Long epnoticeNo;

    @Column(name = "epnotice_title")
    private String title;   //제목
    
    @Column(name = "epnotice_sector")
    private String sector;  //분야
    
    @Column(name = "epnotice_body")
    private String body;    //본문
    
    @Column(name = "epnotice_area")
    private String area;    //지역
 
    @Column(name = "epnotice_id")
    private String id;  //공지 올린 사장id
}
