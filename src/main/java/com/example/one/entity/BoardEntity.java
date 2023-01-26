package com.example.one.entity;

import java.util.Date;
import java.util.Objects;

public class BoardEntity {
    private int boardNum;
    private String boardTitle;
    private String boardContent;
    private int boardCount;
    private Date boardCreatedAt;
    private int boardLikes;

    private String boardValue;

    private String boardWriter;

    private String boardLikesUser;

    private String boardImages;

    private String boardImagesName;

    public BoardEntity() {
    }

    public BoardEntity(int boardNum, String boardTitle, String boardContent, int boardCount, Date boardCreatedAt, int boardLikes, String boardValue, String boardWriter, String boardLikesUser, String boardImages, String boardImagesName) {
        this.boardNum = boardNum;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardCount = boardCount;
        this.boardCreatedAt = boardCreatedAt;
        this.boardLikes = boardLikes;
        this.boardValue = boardValue;
        this.boardWriter = boardWriter;
        this.boardLikesUser = boardLikesUser;
        this.boardImages = boardImages;
        this.boardImagesName = boardImagesName;
    }

    public String getBoardImagesName() {
        return boardImagesName;
    }

    public BoardEntity setBoardImagesName(String boardImagesName) {
        this.boardImagesName = boardImagesName;
        return this;
    }

    public String getBoardImages() {
        return boardImages;
    }

    public BoardEntity setBoardImages(String boardImages) {
        this.boardImages = boardImages;
        return this;
    }

    public int getBoardNum() {
        return boardNum;
    }

    public BoardEntity setBoardNum(int boardNum) {
        this.boardNum = boardNum;
        return this;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public BoardEntity setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
        return this;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public BoardEntity setBoardContent(String boardContent) {
        this.boardContent = boardContent;
        return this;
    }

    public int getBoardCount() {
        return boardCount;
    }

    public BoardEntity setBoardCount(int boardCount) {
        this.boardCount = boardCount;
        return this;
    }

    public Date getBoardCreatedAt() {
        return boardCreatedAt;
    }

    public BoardEntity setBoardCreatedAt(Date boardCreatedAt) {
        this.boardCreatedAt = boardCreatedAt;
        return this;
    }

    public int getBoardLikes() {
        return boardLikes;
    }

    public BoardEntity setBoardLikes(int boardLikes) {
        this.boardLikes = boardLikes;
        return this;
    }

    public String getBoardValue() {
        return boardValue;
    }

    public BoardEntity setBoardValue(String boardValue) {
        this.boardValue = boardValue;
        return this;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public BoardEntity setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
        return this;
    }

    public String getBoardLikesUser() {
        return boardLikesUser;
    }

    public BoardEntity setBoardLikesUser(String boardLikesUser) {
        this.boardLikesUser = boardLikesUser;
        return this;
    }
}
