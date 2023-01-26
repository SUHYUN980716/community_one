package com.example.one.mapper;

import com.example.one.entity.BoardEntity;
import com.example.one.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface memberMapper {
    void insertMember(MemberEntity member);

    MemberEntity loginMember(@Param("memberEmail")String memberEmail,@Param("memberPassword")String memberPassword);

    MemberEntity selectPassword(@Param("memberEmail") String memberEmail, @Param("memberPassword") String memberPassword);

    int updatePassword(@Param("memberEmail")String memberEmail,@Param("memberPassword")String memberPassword);

    int updateNickName(@Param("memberEmail")String memberEmail,@Param("memberName")String memberName);

    int deleteUser(@Param("memberEmail") String memberEmail, @Param("memberPassword") String memberPassword);

    BoardEntity[] selectUserArticle(@Param("boardWriter") String boardWriter);

    MemberEntity DuplicationCheckEmail(@Param("memberEmail")String memberEmail);

    MemberEntity DuplicationCheckName(@Param("memberName")String memberName);


}
