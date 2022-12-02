package kr.inhatc.spring.staff.dto;

import org.modelmapper.ModelMapper;

import kr.inhatc.spring.staff.entity.StaffSchedule;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StaffScheduleDto {

    private Long schNo;
    
    private String startDate;
    
    private String endDate;
    
    private String startTime;
    
    private String endTime;
    
    private String name;
    
    private static ModelMapper modelMapper = new ModelMapper();
    
    public StaffSchedule createSchedule() {
        //Dto -> Entity
        return modelMapper.map(this, StaffSchedule.class);
    }
    
    public static StaffScheduleDto of(StaffSchedule staffSchedule) {
        //Entity -> Dto
        return modelMapper.map(staffSchedule, StaffScheduleDto.class);
    }
}
