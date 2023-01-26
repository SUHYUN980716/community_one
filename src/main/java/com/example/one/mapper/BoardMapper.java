package com.example.one.mapper;

import com.example.one.entity.BoardEntity;
import com.example.one.entity.BoardValueEntity;
import com.example.one.entity.CommentEntity;
import com.example.one.entity.MemberEntity;
import com.example.one.entity.VO.Criteria;
import com.example.one.entity.VO.boardMemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface BoardMapper {

    void insertBoard(String boardWriter,@Param("boardTitle")String boardTitle, @Param("boardContent")String boardContent,@Param("boardValue")String boardValue);
    void insertBoard(BoardEntity boardEntity);

    BoardValueEntity[] selectBoardVlaue();

    List<boardMemberVO> selectFreeBoard(Criteria cri);

    BoardEntity[] selectNoticeBoard(Criteria cri);

    int totalCountofNoticeBoard();

    boardMemberVO selectFreeDetail(@Param("boardNum")int boardNum);

    void BoardCount(@Param("boardNum")int boardNum);

    int LikeCount(@Param("boardWriter")String boardWriter, @Param("boardNum")int boardNum);
    int undoLikeCount(@Param("boardWriter")String boardWriter, @Param("boardNum")int boardNum);

    BoardEntity selectLikedUser(@Param("boardNum")int boardNum);

    void deletePost(@Param("boardNum")int boardNum);

    void editPost(@Param("boardTitle")String boardTitle, @Param("boardContent")String boardContent,@Param("boardNum")int boardNum);

    BoardEntity selectEditPost(@Param("boardNum")int boardNum);

    BoardEntity[] mainFreeRecent();

    BoardEntity[] mainPopRecent();

    List<boardMemberVO> HotArticle(Criteria cri);

    int totalCountofPopBoard();
    void insertHotArticle();

    CommentEntity selectParentComments(@Param("commentIndex") int commentIndex);

    void replySequence(CommentEntity comment);

    int replyInsert(CommentEntity commet);

    CommentEntity[] AllComment(@Param("boardNum") int boardNum);

    int commentInsert(CommentEntity commet);

    int totalCountofFreeBoard();

    CommentEntity[] myComments(@Param("commentWriter") String commentWriter);

    void deleteComments(@Param("commentIndex")int commentIndex);
}
