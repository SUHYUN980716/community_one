package com.example.one.controller;

import com.example.one.entity.BoardEntity;
import com.example.one.entity.MemberEntity;
import com.example.one.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class HomeController {
    @Autowired
    public BoardMapper boardMapper;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public void HOME(HttpServletResponse response) throws IOException {
        response.sendRedirect("/index");
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(@SessionAttribute(required = false) MemberEntity member,HttpSession request, Model model){
        member = (MemberEntity) request.getAttribute("member");
        model.addAttribute("member",member);

        BoardEntity[] mainBoard = this.boardMapper.mainFreeRecent();
        model.addAttribute("article",mainBoard);

        BoardEntity[] popMain = this.boardMapper.mainPopRecent();
        model.addAttribute("articleHot",popMain);


        return "index";
    }
}
