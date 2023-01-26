package com.example.one.entity.VO;

import java.util.Date;

public class boardMemberVO {

    private int boardNum;
    private String boardTitle;
    private String boardContent;
    private int boardCount;
    private Date boardCreatedAt;
    private int boardLikes;

    private String boardValue;

    private String boardWriter;

    private String boardLikesUser;

    private int memberNum;
    private String memberEmail;
    private String memberPassword;
    private Date memberJoinDate;
    private String memberName;

    private String boardImagesName;



    public boardMemberVO() {
    }

    public boardMemberVO(int boardNum, String boardTitle, String boardContent, int boardCount, Date boardCreatedAt, int boardLikes, String boardValue, String boardWriter, String boardLikesUser, int memberNum, String memberEmail, String memberPassword, Date memberJoinDate, String memberName, String boardImagesName) {
        this.boardNum = boardNum;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardCount = boardCount;
        this.boardCreatedAt = boardCreatedAt;
        this.boardLikes = boardLikes;
        this.boardValue = boardValue;
        this.boardWriter = boardWriter;
        this.boardLikesUser = boardLikesUser;
        this.memberNum = memberNum;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberJoinDate = memberJoinDate;
        this.memberName = memberName;
        this.boardImagesName = boardImagesName;
    }

    public String getBoardImagesName() {
        return boardImagesName;
    }

    public boardMemberVO setBoardImagesName(String boardImagesName) {
        this.boardImagesName = boardImagesName;
        return this;
    }

    public int getBoardNum() {
        return boardNum;
    }

    public boardMemberVO setBoardNum(int boardNum) {
        this.boardNum = boardNum;
        return this;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public boardMemberVO setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
        return this;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public boardMemberVO setBoardContent(String boardContent) {
        this.boardContent = boardContent;
        return this;
    }

    public int getBoardCount() {
        return boardCount;
    }

    public boardMemberVO setBoardCount(int boardCount) {
        this.boardCount = boardCount;
        return this;
    }

    public Date getBoardCreatedAt() {
        return boardCreatedAt;
    }

    public boardMemberVO setBoardCreatedAt(Date boardCreatedAt) {
        this.boardCreatedAt = boardCreatedAt;
        return this;
    }

    public int getBoardLikes() {
        return boardLikes;
    }

    public boardMemberVO setBoardLikes(int boardLikes) {
        this.boardLikes = boardLikes;
        return this;
    }

    public String getBoardValue() {
        return boardValue;
    }

    public boardMemberVO setBoardValue(String boardValue) {
        this.boardValue = boardValue;
        return this;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public boardMemberVO setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
        return this;
    }

    public String getBoardLikesUser() {
        return boardLikesUser;
    }

    public boardMemberVO setBoardLikesUser(String boardLikesUser) {
        this.boardLikesUser = boardLikesUser;
        return this;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public boardMemberVO setMemberNum(int memberNum) {
        this.memberNum = memberNum;
        return this;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public boardMemberVO setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
        return this;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public boardMemberVO setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
        return this;
    }

    public Date getMemberJoinDate() {
        return memberJoinDate;
    }

    public boardMemberVO setMemberJoinDate(Date memberJoinDate) {
        this.memberJoinDate = memberJoinDate;
        return this;
    }

    public String getMemberName() {
        return memberName;
    }

    public boardMemberVO setMemberName(String memberName) {
        this.memberName = memberName;
        return this;
    }
}
