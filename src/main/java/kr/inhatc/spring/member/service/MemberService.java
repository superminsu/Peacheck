package kr.inhatc.spring.member.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.inhatc.spring.member.dto.MemberFormDto;
import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor // @AutoWired 없이도 repository를 메모리에 올릴 수 있음 ( final 반드시 추가, 테스트에서는 오류남 )
public class MemberService {

    private final MemberRepository memberRepository;

    // 로그인 기능
    public MemberFormDto login(MemberFormDto member) {
        try {
            System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + member.getName());
            System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + member.getPassword());
            Member findMember = memberRepository.findByNameAndPassword(member.getName(), member.getPassword());
            if (findMember.getName() != null && findMember.getPassword() != null)
                return member;
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    // 회원가입
    public Member saveMember(Member member) {
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + member.getName());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + member.getPassword());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + member.getBirthday());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + member.getCity());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + member.getArea());
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + member.getPhone());
        return memberRepository.save(member);
    }
}
