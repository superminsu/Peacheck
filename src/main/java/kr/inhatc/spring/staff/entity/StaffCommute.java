package kr.inhatc.spring.staff.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.shop.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor  //디폴트 생성자
@AllArgsConstructor //기본 생성자 생성
public class StaffCommute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_commute_number")
    private Long ctNo;
    
    @Column(name = "staff_commute_id")
    private String id;
    
    @Column(name = "staff_commute_year")
    private String year;
    
    @Column(name = "staff_commute_month")
    private String month;
    
    @Column(name = "staff_commute_date")
    private String date;
    
    @Column(name = "staff_commute_arrival")
    private String arrival;
    
    @Column(name = "staff_commute_leave")
    private String leave;
    
    @Column(name = "staff_commute_check")
    private String check;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_mbrNo")
    private Member member;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_spNo")
    private Shop shop;
}
