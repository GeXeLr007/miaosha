package com.imooc.miaosha.dao;

import com.imooc.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    @Select("select * from user where id=#{id}")
    public User getByid(@Param("id")int id);
    @Insert("insert into user(id,name) values(#{id},#{name})")
    public int insert(User user);
    
}
