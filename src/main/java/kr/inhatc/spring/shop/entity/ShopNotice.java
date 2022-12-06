package kr.inhatc.spring.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kr.inhatc.spring.shop.dto.ShopNoticeDto;
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
    @Column(name = "shop_notice_number")
    private Long spnoticeNo;
    
    @Column(name = "shop_notice_title")
    private String title;               //제목
    
    @Column(name = "shop_notice_body")
    private String body;                //본문
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_spNo")
    private Shop shop;                  //해당 공지 가게


    public static ShopNotice createShopNotice(ShopNoticeDto shopNoticeDto) {
        ShopNotice shopNotice = new ShopNotice();
        shopNotice.setTitle(shopNoticeDto.getTitle());
        shopNotice.setBody(shopNoticeDto.getBody());
        return shopNotice;
    }
    
}
