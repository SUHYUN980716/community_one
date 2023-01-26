package com.example.one.controller;

import com.example.one.entity.BoardEntity;
import com.example.one.entity.CommentEntity;
import com.example.one.entity.MemberEntity;
import com.example.one.entity.VO.Criteria;
import com.example.one.entity.VO.boardMemberVO;
import com.example.one.entity.VO.pageMaker;
import com.example.one.mapper.BoardMapper;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("bbs")
public class BoardController {


    @Autowired
    private BoardMapper boardMapper;

    @RequestMapping(value = "/free", method = RequestMethod.GET)
    public String getFree(
            Model model,
            HttpServletRequest request,
            Criteria cri
    ) {
        HttpSession session = request.getSession();
        if (session.getAttribute("member") == null) {
            return "redirect:/mbr/login";
        }
        model.addAttribute("freeList", this.boardMapper.selectFreeBoard(cri));

        pageMaker pageMaker = new pageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(this.boardMapper.totalCountofFreeBoard());
        model.addAttribute("pageMaker",pageMaker);
        return "/board/freeBoard";
    }

    @RequestMapping(value = "/freeWrite", method = RequestMethod.GET)
    public String getFreeInsert(Model model) {
        model.addAttribute("boardValue", this.boardMapper.selectBoardVlaue());
        return "/board/freeBoardInsert";
    }

    @RequestMapping(value = "/freeInsert", method = RequestMethod.POST)
    public String freeWrite(BoardEntity boardEntity) {
        this.boardMapper.insertBoard(boardEntity);
        return "redirect:/bbs/free";
    }

    @RequestMapping(value = "/freeDetail", method = RequestMethod.GET)
    public String freeDetail(Model model, @RequestParam("boardNum") int boardNum, HttpServletRequest request) {
        model.addAttribute("freeDetail", this.boardMapper.selectFreeDetail(boardNum));
        HttpSession session = request.getSession();
        session.setAttribute("BNum", boardNum);
        model.addAttribute("boardNum", session.getAttribute("BNum"));
        model.addAttribute("Pcomment",this.boardMapper.AllComment(boardNum));
        this.boardMapper.BoardCount(boardNum);
        return "board/freeDetail";
    }

    @RequestMapping(value = "/like", method = RequestMethod.GET)
    @ResponseBody
    public String likeIt(@RequestParam("boardWriter") String boardWriter, @RequestParam("boardNum") int boardNum) {
        int state = this.boardMapper.LikeCount(boardWriter, boardNum);

        JSONObject responseJson = new JSONObject();

        if (state != 0) {
            responseJson.put("result", 1);
            return responseJson.toString();
        } else {
            responseJson.put("result", 0);
            return responseJson.toString();
        }
    }

    @RequestMapping(value = "/dislike", method = RequestMethod.GET)
    @ResponseBody
    public String dislikeIt(@RequestParam("boardWriter") String boardWriter, @RequestParam("boardNum") int boardNum) {
        int state = this.boardMapper.undoLikeCount(boardWriter, boardNum);

        JSONObject responseJson = new JSONObject();

        if (state != 0) {
            responseJson.put("result", 1);
            return responseJson.toString();
        } else {
            responseJson.put("result", 0);
            return responseJson.toString();
        }
    }


    @RequestMapping(value = "/SelectLike", method = RequestMethod.GET)
    @ResponseBody
    public String DidYouLikeIt(@RequestParam("boardLikesUser") String boardLikesUser, @RequestParam("boardNum") int boardNum) {
        JSONObject responseJson = new JSONObject();
        BoardEntity board = this.boardMapper.selectLikedUser(boardNum);
        int num = board.getBoardLikes();

        responseJson.put("num", num);

        ArrayList<String> list = new ArrayList<>();
        String email = board.getBoardLikesUser();
        for (String e : email.split(","))
            list.add(e);
        for (String s : list) {
            if (s.equals(boardLikesUser)) {
                responseJson.put("result", "LikedIt");
                return responseJson.toString();
            }
        }
        responseJson.put("result", "nope");
        return responseJson.toString();
    }

    @RequestMapping(value = "/pop", method = RequestMethod.GET)
    public String getPop(Model model, HttpServletRequest request, Criteria cri) {
        HttpSession session = request.getSession();
        if (session.getAttribute("member") == null) {
            return "redirect:/mbr/login";
        }
        this.boardMapper.insertHotArticle();
        List<boardMemberVO> board = boardMapper.HotArticle(cri);
        model.addAttribute("Hot", board);

        pageMaker pageMaker = new pageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(this.boardMapper.totalCountofPopBoard());
        model.addAttribute("pageMaker",pageMaker);

        return "/board/popBoard";
    }

    @RequestMapping(value = "/popDetail", method = RequestMethod.GET)
    public String popDetail(Model model, @RequestParam("boardNum") int boardNum, HttpServletRequest request) {
        model.addAttribute("popDetail", this.boardMapper.selectFreeDetail(boardNum));
        HttpSession session = request.getSession();
        session.setAttribute("BNum", boardNum);
        model.addAttribute("boardNum", session.getAttribute("BNum"));
        model.addAttribute("Pcomment",this.boardMapper.AllComment(boardNum));
        this.boardMapper.BoardCount(boardNum);
        return "board/popDetail";
    }

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public String getNotice(Model model, Criteria cri) {
        model.addAttribute("notice", this.boardMapper.selectNoticeBoard(cri));

        pageMaker pageMaker = new pageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(this.boardMapper.totalCountofNoticeBoard());
        model.addAttribute("pageMaker",pageMaker);

        return "/board/noticeBoard";
    }

    @RequestMapping(value = "/noticeWrite", method = RequestMethod.GET)
    public String getNoticeInsert(Model model) {
        model.addAttribute("notice", this.boardMapper.selectBoardVlaue());
        return "/board/noticeBoardInsert";
    }

    @RequestMapping(value = "/noticeInsert", method = RequestMethod.POST)
    public String noticeWrite(@RequestParam String boardEmail, @RequestParam String boardTitle, @RequestParam String boardContent, @RequestParam String boardValue) {
        this.boardMapper.insertBoard(boardEmail, boardTitle, boardContent, boardValue);
        return "redirect:/bbs/notice";
    }

    @RequestMapping(value = "/noticeDetail", method = RequestMethod.GET)
    public String noticeDetail(Model model, @RequestParam("boardNum") int boardNum) {
        model.addAttribute("freeDetail", this.boardMapper.selectFreeDetail(boardNum));
        model.addAttribute("Pcomment",this.boardMapper.AllComment(boardNum));
        this.boardMapper.BoardCount(boardNum);
        return "board/noticeDetail";
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.GET)
    public String deletePost(@RequestParam("boardNum") int boardNum) {
        this.boardMapper.deletePost(boardNum);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    public String deleteComment(@RequestParam("commentIndex") int commentIndex) {
        this.boardMapper.deleteComments(commentIndex);
        return "redirect:/";
    }


    @RequestMapping(value = "/editPost", method = RequestMethod.GET)
    public String editPostGET(Model model, @RequestParam("boardNum") int boardNum) {
        BoardEntity board = this.boardMapper.selectEditPost(boardNum);
        model.addAttribute("board", board);
        return "board/freeEdit";
    }


    @RequestMapping(value = "/editPostPro", method = RequestMethod.POST)
    public String editPost(@RequestParam String boardTitle, @RequestParam String boardContent, @RequestParam("boardNum") int boardNum) {
        this.boardMapper.editPost(boardTitle, boardContent, boardNum);
        return "redirect:/bbs/free";
    }

    @RequestMapping(value = "/images", produces = "application/json; charset=utf8")
    @ResponseBody
    public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        JsonObject jsonObject = new JsonObject();


        String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
        String fileRoot = contextRoot + "bbs/images/";

        String originalFileName = multipartFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String savedFileName = UUID.randomUUID() + extension;

        File targetFile = new File(fileRoot + savedFileName);
        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
            jsonObject.addProperty("url", "/bbs/images/" + savedFileName);
            jsonObject.addProperty("responseCode", "success");

        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            jsonObject.addProperty("responseCode", "error");
            e.printStackTrace();
        }
        String a = jsonObject.toString();
        return a;
    }

    @RequestMapping(value = "/insertComment", method = RequestMethod.GET)
    @ResponseBody
    public String getComment(
            @RequestParam(value = "boardNum") int boardNum,
            @RequestParam(value = "commentWriter") String commentWriter,
            @RequestParam(value = "commentContent") String commentContent
    ) {
        CommentEntity comment = new CommentEntity();
        comment.setCommentContent(commentContent);
        comment.setCommentWriter(commentWriter);
        comment.setBoardNum(boardNum);
        int state = this.boardMapper.commentInsert(comment);

        JSONObject responseJson = new JSONObject();

        if (state != 0) {
            responseJson.put("result", 1);
            return responseJson.toString();
        } else {
            responseJson.put("result", 0);
            return responseJson.toString();
        }


    }

    @RequestMapping(value = "/InsertReplyComment", method = RequestMethod.GET)
    public String postComment(
            CommentEntity comment,
            @RequestParam(value = "boardNum",required = false) int boardNum,
            @RequestParam(value = "commentWriter",required = false) String commentWriter,
            @RequestParam(value = "commentContent",required = false) String commentContent,
            @RequestParam(value = "commentIndex") int commentIndex

    ) {
        CommentEntity parent = this.boardMapper.selectParentComments(commentIndex);

        comment.setCommentContent(commentContent);
        comment.setCommentWriter(commentWriter);
        comment.setCommentGroup(parent.getCommentGroup());
        comment.setCommentSequence(parent.getCommentSequence()+1);
        comment.setCommentLevel(parent.getCommentLevel()+ 1);
        comment.setBoardNum(boardNum);
        this.boardMapper.replySequence(parent);
        int state = this.boardMapper.replyInsert(comment);


        if (state != 0) {
            return "redirect:/bbs/freeDetail?boardNum="+boardNum;
        } else {
            return "redirect:/bbs/freeDetail?boardNum="+boardNum;
        }

    }


}
