package kr.inhatc.spring.staff.dto;

import org.modelmapper.ModelMapper;

import kr.inhatc.spring.staff.entity.StaffCommute;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StaffCommuteDto {

    private Long ctNo;
    
    private String year;
    
    private String month;
    
    private String date;
    
    private String arrival;
    
    private String leave;
    
    private String check;
    
    private static ModelMapper modelMapper = new ModelMapper();
    
    public StaffCommute createCommute() {
        //Dto -> Entity
        return modelMapper.map(this, StaffCommute.class);
    }
    
    public static StaffCommuteDto of(StaffCommute staffCommute) {
        //Entity -> Dto
        return modelMapper.map(staffCommute, StaffCommuteDto.class);
    }
}
