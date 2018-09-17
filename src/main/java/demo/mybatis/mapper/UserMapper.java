package demo.mybatis.mapper;

import demo.mybatis.annoation.OrmInsert;
import demo.mybatis.annoation.OrmSelect;
import demo.mybatis.annoation.Ormparm;
import demo.mybatis.entity.user;

import java.util.List;

public interface UserMapper  {

    @OrmInsert("insert into user(userName , userAge) values (#{userName} , #{userAge})")
    int insertUser(@Ormparm("userName")String username , @Ormparm("userAge")Integer userAge);


    @OrmSelect("select * from user where userName  =  #{userName} and userAge = #{userAge} ")
    List<user> selectusers(@Ormparm("userName")String username , @Ormparm("userAge")Integer userAge);


}
