package com.example.one.entity;

import java.util.Date;
import java.util.Objects;

public class CommentEntity {
    private int commentIndex;
    private String commentWriter;
    private String commentContent;
    private int commentGroup;
    private int commentSequence;
    private int commentLevel;
    private boolean commentAvailable;
    private int boardNum;

    private Date commentCreatedAt;

    public CommentEntity() {
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "commentIndex=" + commentIndex +
                ", commentWriter='" + commentWriter + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", commentGroup=" + commentGroup +
                ", commentSequence=" + commentSequence +
                ", commentLevel=" + commentLevel +
                ", commentAvailable=" + commentAvailable +
                ", boardNum=" + boardNum +
                ", commentCreatedAt=" + commentCreatedAt +
                '}';
    }

    public CommentEntity(int commentIndex, String commentWriter, String commentContent, int commentGroup, int commentSequence, int commentLevel, boolean commentAvailable, int boardNum, Date commentCreatedAt) {
        this.commentIndex = commentIndex;
        this.commentWriter = commentWriter;
        this.commentContent = commentContent;
        this.commentGroup = commentGroup;
        this.commentSequence = commentSequence;
        this.commentLevel = commentLevel;
        this.commentAvailable = commentAvailable;
        this.boardNum = boardNum;
        this.commentCreatedAt = commentCreatedAt;
    }

    public Date getCommentCreatedAt() {
        return commentCreatedAt;
    }

    public CommentEntity setCommentCreatedAt(Date commentCreatedAt) {
        this.commentCreatedAt = commentCreatedAt;
        return this;
    }

    public int getBoardNum() {
        return boardNum;
    }

    public CommentEntity setBoardNum(int boardNum) {
        this.boardNum = boardNum;
        return this;
    }

    public int getCommentIndex() {
        return commentIndex;
    }

    public CommentEntity setCommentIndex(int commentIndex) {
        this.commentIndex = commentIndex;
        return this;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public CommentEntity setCommentWriter(String commentWriter) {
        this.commentWriter = commentWriter;
        return this;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public CommentEntity setCommentContent(String commentContent) {
        this.commentContent = commentContent;
        return this;
    }

    public int getCommentGroup() {
        return commentGroup;
    }

    public CommentEntity setCommentGroup(int commentGroup) {
        this.commentGroup = commentGroup;
        return this;
    }

    public int getCommentSequence() {
        return commentSequence;
    }

    public CommentEntity setCommentSequence(int commentSequence) {
        this.commentSequence = commentSequence;
        return this;
    }

    public int getCommentLevel() {
        return commentLevel;
    }

    public CommentEntity setCommentLevel(int commentLevel) {
        this.commentLevel = commentLevel;
        return this;
    }

    public boolean isCommentAvailable() {
        return commentAvailable;
    }

    public CommentEntity setCommentAvailable(boolean commentAvailable) {
        this.commentAvailable = commentAvailable;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return commentIndex == that.commentIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentIndex);
    }
}
