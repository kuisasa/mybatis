package demo.mybatis.mapper;

import demo.mybatis.annoation.OrmInsert;
import demo.mybatis.annoation.OrmSelect;
import demo.mybatis.annoation.OrmParam;
import demo.mybatis.entity.user;

import java.util.List;

public interface UserMapper  {

    @OrmInsert("insert into user(userName , userAge) values (#{userName} , #{userAge})")
    int insertUser(@OrmParam("userName")String username , @OrmParam("userAge")Integer userAge);


    @OrmSelect("select * from user where userName  =  #{userName} and userAge = #{userAge} ")
    List<user> selectusers(@OrmParam("userName")String username , @OrmParam("userAge")Integer userAge);


}
