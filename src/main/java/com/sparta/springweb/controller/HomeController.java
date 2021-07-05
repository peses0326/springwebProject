package com.sparta.springweb.controller;


import com.sparta.springweb.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


// 홈으로 가는 controller : addAttribute 로 username 을 전달 해주고 있다.
@Controller
public class HomeController {
      // security가 전달하는 userdetailsImpl 이다.
//    @GetMapping("/index.html")
//    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        model.addAttribute("username", userDetails.getUsername());
//        return "index";
//    }

    @GetMapping("/index.html") // security가 전달하는 userdetailsImpl 이다.
    public String home() {
        return "index";
    }
}
