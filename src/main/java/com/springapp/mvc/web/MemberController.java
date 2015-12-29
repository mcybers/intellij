package com.springapp.mvc.web;

import com.springapp.mvc.domain.Member;
import com.springapp.mvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @ModelAttribute("member") Member member, ModelMap model)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {

        if (memberService.login(member)) {
            request.getSession().setAttribute("id", member.getId());
        } else {
            model.addAttribute("message", "로그인에 실패했습니다");
            return "fail";
        }

        if (member.getId().equals("admin")) {
            List<Member> members = memberService.findMembers();
            model.addAttribute("members", members);
            return "adminView";
        } else {
            model.addAttribute("member", memberService.findOne(member.getId()));
            return "userView";
        }
    }


    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join(ModelMap model) {
        return "join";
    }

    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public String input(@ModelAttribute("member") Member member, ModelMap model) throws NoSuchAlgorithmException {

        memberService.join(member);
        model.addAttribute("members", memberService.findMembers());
        return "main";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify(@RequestParam String modifyid, ModelMap model) {
        Member member = memberService.findOne(modifyid);
        model.addAttribute("member", member);
        return "modify";
    }

    @RequestMapping(value = "/modifyPro", method = RequestMethod.POST)
    public String modifyPro(HttpServletRequest request, @ModelAttribute("member") Member member, ModelMap model) throws NoSuchAlgorithmException {

        memberService.modify(member);
        String id = (String) request.getSession().getAttribute("id");

        if (id.equals("admin")) {
            List<Member> members = memberService.findMembers();
            model.addAttribute("members", members);
            return "adminView";
        } else {
            model.addAttribute("member", memberService.findOne(id));
            return "userView";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, ModelMap model) {

        request.getSession().removeAttribute("id");
        return "main";
    }

    @RequestMapping(value = "/searchForm", method = RequestMethod.GET)
    public String searchForm( ModelMap model) {

        return "searchForm";
    }

    @RequestMapping(value ="/searchPro", method = RequestMethod.POST)
    public String searchPro(@RequestParam String name, ModelMap model){
        List<Member> members = memberService.findByName(name);
        model.addAttribute("members",members);
        return "searchResult";
    }



}