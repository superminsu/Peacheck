package kr.inhatc.spring.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor  //디폴트 생성자 생성
@AllArgsConstructor //클래스에 존재하는 모든 필드에 대한 생성자 생성
public class ShopNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // null 값 입력시 DB에서 자동 AUTO_INCREMENT
    private Long noticeNo;
    
    @Column(name = "shop_notice_title")
    private String title;               //제목
    
    @Column(name = "shop_notice_body")
    private String body;                //본문
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_number")
    private Shop shop;                  //해당 공지 가게


    public ShopNotice(String title, String body) {
        this.title = title;
        this.body = body;
    }
    
}
