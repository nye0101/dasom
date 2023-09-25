package com.example.dasom.controller;

import com.example.dasom.domain.vo.UserVo;
import com.example.dasom.service.MyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/myPage/*")
@RequiredArgsConstructor
@Slf4j
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/myPageDonation")
    public String myPageDonation(Long userNumber, HttpServletRequest req , Model model) {
        userNumber = (Long) req.getSession().getAttribute("userNumber");
        log.info(userNumber.toString());
        model.addAttribute("List",myPageService.donateUserSelectAll(userNumber));
        return "/myPage/myPageDonation";
    }




    @GetMapping("/myPageCs")
    public String myPageCs(Long userNumber, HttpServletRequest req , Model model) {
        userNumber = (Long) req.getSession().getAttribute("userNumber");
        log.info(userNumber.toString());
        model.addAttribute("List",myPageService.csUserSelectAll(userNumber));
        return "/myPage/myPageCs";
    }

    @GetMapping("/myPageUser")
    public String myPageUser(Long userNumber, HttpServletRequest req , Model model) {
        userNumber = (Long) req.getSession().getAttribute("userNumber");
        log.info(userNumber.toString());
        model.addAttribute("List",myPageService.userSelect(userNumber));
        return "/myPage/myPageUser";
    }
}