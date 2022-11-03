package kr.inhatc.spring.member.controller;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.inhatc.spring.member.dto.MemberFormDto;
import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor //@AutoWired 없이도 repository를 메모리에 올릴 수 있음 ( final 반드시 추가, 테스트에서는 오류남 )
public class MemberController {

    private final MemberService memberService;
    
    @PostMapping("/login")
    public MemberFormDto login(MemberFormDto dto) {
        log.info("MemberController login()");
        MemberFormDto sendDto = memberService.login(dto);
        return sendDto;
    }
    
    @PostMapping("/save")
    public Member save(Member member) {
        log.info("MemberController save()");
        Member saveMember = memberService.saveMember(member);
        return saveMember;
    }
}
