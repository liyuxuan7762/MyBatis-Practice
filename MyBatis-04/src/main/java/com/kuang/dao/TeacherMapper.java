package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    Teacher getTeacherById(@Param("tid") int id);

    Teacher getTeacherById2(@Param("tid") int id);
}
