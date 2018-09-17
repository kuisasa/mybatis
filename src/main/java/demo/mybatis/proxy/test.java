package demo.mybatis.proxy;

import demo.mybatis.entity.user;
import demo.mybatis.mapper.UserMapper;
import demo.mybatis.session.SqlSession;

import java.util.List;

public class test {
    public static void main(String[] args) {
        UserMapper userMapper = SqlSession.getMapper(UserMapper.class);
        List<user> users = userMapper.selectusers("",0);
        for (user user:users) {
            System.out.println(user.getUserName()+":" + user.getUserAge() +":" + user.getId());
        }


    }
}
