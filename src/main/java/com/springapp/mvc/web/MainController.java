package com.springapp.mvc.web;

import com.springapp.mvc.domain.Member;
import com.springapp.mvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initPage(ModelMap model) throws NoSuchAlgorithmException {

        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(HttpServletRequest request, ModelMap model) {

        String page = "main";
        String sessionId = (String) request.getSession().getAttribute("id");

        if (request.getSession().getAttribute("id") != null) {
            if (sessionId.equals("admin")) {
                List<Member> members = memberService.findMembers();
                model.addAttribute("members", members);
                page = "adminView";
            } else {
                model.addAttribute("member", memberService.findOne(sessionId));
                page = "userView";
            }
        }

        return page;
    }
}