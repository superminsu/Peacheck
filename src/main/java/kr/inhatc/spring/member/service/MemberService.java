package kr.inhatc.spring.member.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.inhatc.spring.member.dto.MemberFormDto;
import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor // @AutoWired 없이도 repository를 메모리에 올릴 수 있음 ( final 반드시 추가, 테스트에서는 오류남 )
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    // 로그인 기능
    public Member login(Member member) {
        try {
            log.info("맴버 : " + member);
            Member findMember = memberRepository.findByIdAndPassword(member.getId(), member.getPassword());
            if (findMember.getId() != null && findMember.getPassword() != null)
                return findMember;
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    // 회원가입
    public Member saveMember(Member member) {
        log.info("맴버 : " + member);
        return memberRepository.save(member);
    }
    
    // 직급 리턴
    
}
