package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MyBatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void testQuery() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testLimit() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 3);
        List userByLimit = mapper.getUserByLimit(map);
        userByLimit.forEach(System.out::println);
        sqlSession.commit();
    }

    @Test
    public void testRowBounds() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        RowBounds rowBounds = new RowBounds(0,2);
        List<Object> objects = sqlSession.selectList("com.kuang.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (Object object : objects) {
            User user = (User) object;
            System.out.println(user);
        }
    }
}
