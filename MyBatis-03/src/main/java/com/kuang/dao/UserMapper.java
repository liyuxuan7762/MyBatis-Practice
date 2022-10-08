package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询
    List<User> getAllUser();

    // 分页查询
    List<User> getUserByLimit(Map<String, Integer> map);

    // 使用RowBounds分页
    List<User> getUserByRowBounds();

}
