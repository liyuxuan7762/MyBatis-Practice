package com.kuang.dao;

import com.kuang.pojo.Blog;
import com.kuang.utils.IDUtils;
import com.kuang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.awt.event.WindowStateListener;
import java.util.*;

public class BlogMapperTest {
    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getID());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void query() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("author", "狂神说");
        map.put("title", "Java");
        List<Blog> blog = mapper.getBlog(map);
        blog.forEach(System.out::println);
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("author", "狂神说");
        map.put("title", "Java");
        map.put("id", "098243eb-3064-469a-9ac7-aa9e79f8f6f0");
        mapper.updateBlog(map);
    }

    @Test
    public void testForeach() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        ArrayList<String> integers = new ArrayList<>();
        integers.add("Java");integers.add("Mybatis");integers.add("微服务");
        map.put("ids", integers);
        mapper.queryBlog(map);
    }
}

