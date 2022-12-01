package kr.inhatc.spring.epnotice.dto;

import org.modelmapper.ModelMapper;

import kr.inhatc.spring.epnotice.entity.Epnotice;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EpnoticeDto {

    private Long id;
    
    private String title;
    
    private String sector;
    
    private String body;
    
    private String area;
    
    private static ModelMapper modelMapper = new ModelMapper();
    
    public Epnotice createEpnotice() {
        //Dto -> Entity
        return modelMapper.map(this, Epnotice.class);
    }
    
    public static EpnoticeDto of(Epnotice epnotice) {
        //Entity -> Dto
        return modelMapper.map(epnotice, EpnoticeDto.class);
    }
}
