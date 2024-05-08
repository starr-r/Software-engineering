package com.example.demo.mapper;

import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CommentMapper {
    @Select("select * from comment where user_id=#{user_id}")
    public List<Comment> findCommentsByUser_id(@Param("user_id") Integer user_id);

    @Select("select * from comment where artifact_id=#{artifact_id}")
    public List<Comment> findCommentsByArtifact_id(Integer artifact_id);

    @Insert("insert into comment(user_id, artifact_id, content, create_time,user_name,avatar_url) value " +
            "(#{userId},#{artifactId},#{content},#{createTime},#{userName},#{avatarUrl} )")
    public void insertComment(Comment comment);
}
