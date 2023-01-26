package com.example.one.entity;


import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public class MemberEntity {

    public static final String ATTRIBUTE_NAME = "memberUser";
    public static final String ATTRIBUTE_NAME_PLURAL = "memberUsers";

    private int memberNum;
    private String memberEmail;
    private String memberPassword;
    private Date memberJoinDate;
    private String memberName;

    public MemberEntity() {
    }

    public MemberEntity(int memberNum, String memberEmail, String memberPassword, Date memberJoinDate, String memberName) {
        this.memberNum = memberNum;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberJoinDate = memberJoinDate;
        this.memberName = memberName;
    }

    public String getMemberName() {
        return memberName;
    }

    public MemberEntity setMemberName(String memberName) {
        this.memberName = memberName;
        return this;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public MemberEntity setMemberNum(int memberNum) {
        this.memberNum = memberNum;
        return this;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public MemberEntity setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
        return this;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public MemberEntity setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
        return this;
    }

    public Date getMemberJoinDate() {
        return memberJoinDate;
    }

    public MemberEntity setMemberJoinDate(Date memberJoinDate) {
        this.memberJoinDate = memberJoinDate;
        return this;
    }

}
