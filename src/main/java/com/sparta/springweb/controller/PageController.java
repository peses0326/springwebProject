package com.sparta.springweb.controller;

import com.sparta.springweb.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    // 홈으로 가는 controller : addAttribute 로 username 을 전달 해주고 있다.

    // security가 전달하는 userdetailsImpl 이다.
    @GetMapping("/detail.html")
    public String detail(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
        }
        return "detail";
    }
}

