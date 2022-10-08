package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询
    @Select("select * from t_account")
    List<User> getAllUser();

    // 根据Id查询
    @Select("select * from t_account where id = #{id}")
    User getUserById(@Param("id") Integer id);

    // 添加用户
    @Insert("insert into t_account values (#{id}, #{username}, #{pwd})")
    int addUser(User user);

    // 删除用户
    @Delete("delete from t_account where id = #{id}")
    int deleteUserById(@Param("id") Integer id);

    // 修改用户
    @Update("update t_account set username = #{username}, pwd = #{pwd} where id = #{id}")
    int update(User user);
}
