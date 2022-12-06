package kr.inhatc.spring.epnotice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.inhatc.spring.epnotice.entity.Epnotice;
import kr.inhatc.spring.epnotice.repository.EpnoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EpnoticeService {

    private final EpnoticeRepository epnoticeRepository;
    
    // 고용 공지 등록
    public Epnotice saveEpnotice(Epnotice epnotice) {
        return epnoticeRepository.save(epnotice);
    }
    
    // 모든 고용 공지 리턴
    public List<Epnotice> findEpnotice(){
        try {
            List<Epnotice> findEpnotice = epnoticeRepository.findAll();
            return findEpnotice;
        } catch (Exception e) {
            log.info("값이 없음");
            return null;
        }
    }
    
    // 지역별 고용 공지 리턴
    public List<Epnotice> findAreaNotice(String area){
        try {
            List<Epnotice> findAreaNotice = epnoticeRepository.findByArea(area);
            return findAreaNotice;
        } catch (Exception e) {
            log.info("값이 없음");
            return null;
        }
    }
    
    // 고용 공지 수정
    public void updateNotice(Long epnoticeNo, Epnotice epnotice) {
        log.info("공지 번호 : " + epnoticeNo);
        Optional<Epnotice> updateNoticeWrapper = epnoticeRepository.findById(epnoticeNo);
        Epnotice updateNotice = updateNoticeWrapper.get();
        
        if(updateNotice != null) {
            updateNotice.setTitle(epnotice.getTitle());
            updateNotice.setSector(epnotice.getSector());
            updateNotice.setBody(epnotice.getBody());
            updateNotice.setArea(epnotice.getArea());
            epnoticeRepository.save(updateNotice);
        }
    }
    
    // 고용 공지 삭제
    public void deleteNotice(Long epnoticeNo) {
        epnoticeRepository.deleteById(epnoticeNo);
    }
}
