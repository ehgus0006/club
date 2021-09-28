package com.example.club.controller;

import com.example.club.security.dto.ClubAuthMemberDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sample/")
public class SampleController {


    // 로그인을 하지 않은 사용자도 접글할 수 있는 "/sample/all"
    @GetMapping("/all")
    public void exAll() {
        log.info("exAll............................");
    }

    // 로그인한 사용자만이 접근할 수 있는 "/sample/member"
    @GetMapping("/member")
    public void exMember(@AuthenticationPrincipal ClubAuthMemberDTO clubAuthMemberDTO) {
        log.info("exMember............................");
        log.info("............................");
        log.info(clubAuthMemberDTO);
    }

    // 관리자(admin) 권한이 있는 사용자만이 접근할 수 있는 "/sample/admin"
    @GetMapping("/admin")
    public void exAdmin() {
        log.info("exAdmin............................");

    }
}
