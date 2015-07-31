package com.memory.user.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.memory.user.domain.User;

public interface UserMapper {

  @Select("<script>"
      + "select * from user where 1 = 1 "
      + "<if test=\"id != null\">"
      + "and id = #{id}"
      + "</if>"
      + "<if test=\"username != null\">"
      + "and username = #{username}"
      + "</if>"
      + "<if test=\"password != null\">"
      + "and password = #{password}"
      + "</if>"
      + "</script>")
  List<User> getAll(Map<String, Object> params);

  @Select("<script>"
      + "select * from user where 1 = 1 "
      + "<if test=\"id != null\">"
      + "and id = #{id}"
      + "</if>"
      + "<if test=\"username != null\">"
      + "and username = #{username}"
      + "</if>"
      + "<if test=\"password != null\">"
      + "and password = #{password}"
      + "</if>"
      + "</script>")
  int getCount(Map<String, Object> params);

  @Select("select * from user where id = #{id}")
  User getById(long id);

  @Insert("insert into user (username, password) values(#{username}, #{password})")
  @SelectKey(before = false, statement = "select last_insert_id() as id", keyProperty = "id", resultType = long.class)
  long add(User user);

  @Delete("delete from user where id = #{id}")
  int delById(long id);

  @Update("update user set username = #{username}, password = #{password} where id = #{id}")
  int update(User user);
}
