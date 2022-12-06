package kr.inhatc.spring.epnotice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.inhatc.spring.epnotice.entity.Epnotice;
import kr.inhatc.spring.epnotice.service.EpnoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EpnoticeController {

    private final EpnoticeService epnoticeService;
    
    //고용공지 등록
    @PostMapping("epnotice/save")
    public Epnotice save(Epnotice epnotice) {
        log.info("EpnoticeController save");
        Epnotice saveEpnotice = epnoticeService.saveEpnotice(epnotice);
        return saveEpnotice;
    }
    
    //모든 고용공지 리턴
    @PostMapping("epnotice/find")
    public List<Epnotice> find(){
        log.info("EpnoticeController finde");
        List<Epnotice> findEpnotice = epnoticeService.findEpnotice();
        return findEpnotice;
    }
    
    //지역별 고용공지 리턴
    @PostMapping("epnotice/findArea")
    public List<Epnotice> findArea(String area){
        log.info("EpnoticeController findArea");
        List<Epnotice> findAreaEpnotice = epnoticeService.findAreaNotice(area);
        return findAreaEpnotice;
    }
    
    //고용공지 수정
    @PostMapping("epnotice/update")
    public String updateEpnotcie(Long epnoticeNo, Epnotice epnotice) {
        epnoticeService.updateNotice(epnoticeNo, epnotice);
        return "고용공지 수정 완료";
    }
    
    //고용공지 삭제
    @PostMapping("epnotice/delete")
    public String deleteEpnotice(Long epnoticeNo) {
        epnoticeService.deleteNotice(epnoticeNo);
        return "고용공지 삭제 완료";
    }
}
