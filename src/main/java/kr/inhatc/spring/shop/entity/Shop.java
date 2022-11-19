package kr.inhatc.spring.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.password.PasswordEncoder;

import kr.inhatc.spring.shop.dto.ShopFormDto;
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
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //spNo 값을 null로 하면 DB가 알아서 AUTO_INCREMENT 해준다
    @Column(name="shop_number")
    private Long spNo;
    
    @Column(name="shop_id")
    private String id;          //매장 구별을 위해 매장 주인 아이디 저장
    
    @Column(name="shop_name")
    private String name;        //매장명
    
    @Column(name="shop_city")
    private String city;        //도시
    
    @Column(name="shop_area")
    private String area;        //지역구
    
    @Column(name="shop_address")
    private String address;     //상세주소
    
    @Column(name="shop_phone")
    private String phone;       //전화번호
    
    @Column(name="shop_sector")
    private String sector;      //업종
    
    @OneToMany(mappedBy = "ShopNotice", cascade = CascadeType.ALL)
    private List<ShopNotice> shopNotices = new ArrayList<>();
    
    
    public static Shop createShop(ShopFormDto shopFormDto) {
        
        Shop shop= new Shop();
        shop.setId(shopFormDto.getId());
        shop.setName(shopFormDto.getName());
        shop.setCity(shopFormDto.getCity());
        shop.setArea(shopFormDto.getArea());
        shop.setAddress(shopFormDto.getAddress());
        shop.setPhone(shopFormDto.getPhone());
        shop.setSector(shopFormDto.getSector());
        return shop;
    }
}
