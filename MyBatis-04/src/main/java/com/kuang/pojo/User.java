package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("test")
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String pwd;

}
