package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询
    List<User> getAllUser();
    // 删除
    int deleteUserById(Integer id);
    // 改
    int updateUser(User user);
    // 添加
    int addUser(User user);
    // Map传值 仅仅修改密码
    int updatePwd(Map<String, Object> map);
    // 模糊查询
    List<User> selectLike(String username);
}
