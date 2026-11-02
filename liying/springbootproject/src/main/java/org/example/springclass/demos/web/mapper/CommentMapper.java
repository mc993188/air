package org.example.springclass.demos.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.springclass.demos.web.pojo.comment;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM t_comment WHERE id =#{id}")
    public comment findById(Integer id);

    @Update("UPDATE t_comment SET content=#{content} WHERE id=#{id}")
    public int updateComment(comment comment);

}
