package com.kuang.dao;

import com.kuang.pojo.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    @Insert("insert into blog values (#{id}, #{title}, #{author}, #{createTime}, #{views})")
    public int addBlog(Blog blog);

    public List<Blog> getBlog(Map map);

    // 使用choose when
    public List<Blog> getBlog2(Map map);

    // 使用set
    public int updateBlog(Map map);

    // 使用forEach()
    public List<Blog> queryBlog(Map map);
}
