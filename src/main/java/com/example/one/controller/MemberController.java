package com.example.one.controller;

import com.example.one.entity.MemberEntity;
import com.example.one.mapper.BoardMapper;
import com.example.one.mapper.memberMapper;
import com.example.one.util.CryptoUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("mbr")
public class MemberController {

    @Autowired
    private memberMapper memberMapper;
    @Autowired
    private BoardMapper boardMapper;



    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister(){
        return "/member/register";
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public String getRegister(MemberEntity member){
        member.setMemberPassword(CryptoUtils.hashSha512(member.getMemberPassword()));
        this.memberMapper.insertMember(member);

        return"redirect:/";
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(){
        return "/member/login";
    }


    @RequestMapping(value="loginProcess", method = RequestMethod.POST)
    public String getLogin(
            HttpServletRequest request,
            @SessionAttribute(required = false) MemberEntity member,
            @RequestParam("memberEmail")String memberEmail,
            @RequestParam("memberPassword")String memberPassword
    ){
        String HashPassword = CryptoUtils.hashSha512(memberPassword);
        member = this.memberMapper.loginMember(memberEmail,HashPassword);
        HttpSession session = request.getSession();
        if(memberEmail.equals("admin")){
            session.setAttribute("manager",member);
            session.setAttribute("member", member);
            return "redirect:/";
        }
        if(member != null){
            session.setAttribute("member", member);
            return "redirect:/";
        }else{
            return "redirect:/mbr/login";
        }

    }

    @RequestMapping(value="logout", method = RequestMethod.GET)
    public String Logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }


    @RequestMapping(value="myPage", method = RequestMethod.GET)
    public String getMyPage(HttpServletRequest request,Model model){
        HttpSession session =request.getSession();
        MemberEntity member = (MemberEntity) session.getAttribute("member");
        model.addAttribute("myArticle",this.memberMapper.selectUserArticle(member.getMemberEmail()));
        model.addAttribute("myComments",this.boardMapper.myComments(member.getMemberName()));
        return "member/myPage";
    }

    @RequestMapping(value="changePassWord", method = RequestMethod.POST)
    @ResponseBody
    public String changeIt(MemberEntity member, @RequestParam("memberEmail")String memberEmail, @RequestParam("memberPassword")String memberPassword){
        String HashPass = CryptoUtils.hashSha512(memberPassword);
        member = this.memberMapper.selectPassword(memberEmail,HashPass);


        JSONObject responseJson = new JSONObject();

        if(member != null){
            responseJson.put("result","success");
            return responseJson.toString();
        }else{
            responseJson.put("result","failed");
            return responseJson.toString();
        }
    }


    @RequestMapping(value="updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public String updateIt(@RequestParam("memberEmail")String memberEmail, @RequestParam("memberPassword")String memberPassword){
        String HashPass = CryptoUtils.hashSha512(memberPassword);
        int count = this.memberMapper.updatePassword(memberEmail,HashPass);


        System.out.println(count);

        JSONObject responseJson = new JSONObject();

        if(count != 0){
            responseJson.put("result","success");
            return responseJson.toString();
        }else{
            responseJson.put("result","failed");
            return responseJson.toString();
        }
    }

    @RequestMapping(value="updateName", method = RequestMethod.POST)
    @ResponseBody
    public String updateItTheName(@RequestParam("memberEmail")String memberEmail, @RequestParam("memberName")String memberName){
        int count = this.memberMapper.updateNickName(memberEmail,memberName);


        System.out.println(count);

        JSONObject responseJson = new JSONObject();

        if(count != 0){
            responseJson.put("result","success");
            return responseJson.toString();
        }else{
            responseJson.put("result","failed");
            return responseJson.toString();
        }
    }

    @RequestMapping(value="deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public String DeleteUser(@RequestParam("memberEmail")String memberEmail, @RequestParam("memberPassword")String memberPassword){
        int count = this.memberMapper.deleteUser(memberEmail,memberPassword);


        System.out.println(count);

        JSONObject responseJson = new JSONObject();

        if(count != 0){
            responseJson.put("result","success");
            return responseJson.toString();
        }else{
            responseJson.put("result","failed");
            return responseJson.toString();
        }
    }


    @RequestMapping(value="checkEmail", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String checkEmail(@RequestParam("memberEmail")String memberEmail){
        MemberEntity member = this.memberMapper.DuplicationCheckEmail(memberEmail);



        JSONObject responseJson = new JSONObject();

        if(member == null){
            responseJson.put("result","success");
            return responseJson.toString();
        }else{
            responseJson.put("result","failed");
            return responseJson.toString();
        }
    }

    @RequestMapping(value="checkName", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String checkName(@RequestParam("memberName")String memerName){
        MemberEntity member = this.memberMapper.DuplicationCheckName(memerName);



        JSONObject responseJson = new JSONObject();

        if(member == null){
            responseJson.put("result","success");
            return responseJson.toString();
        }else{
            responseJson.put("result","failed");
            return responseJson.toString();
        }
    }

}


