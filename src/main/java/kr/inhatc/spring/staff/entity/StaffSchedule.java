package kr.inhatc.spring.staff.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kr.inhatc.spring.shop.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StaffSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_schedule_number")
    private Long schNo;
    
    @Column(name = "staff_schedule_startdate")
    private String startDate;   //시작날짜
    
    @Column(name = "staff_schedule_enddate")
    private String endDate;     //종료날짜
    
    @Column(name = "staff_schedule_starttime")
    private String startTime;   //출근
    
    @Column(name = "staff_schedule_endtime")
    private String endTime;     //퇴근
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_spNo")
    private Shop shop;          //해당 스케쥴 가게
    
    @Column(name = "staff_schedule_name")
    private String name;        //대상자
}
