package me.lym.myspace.core.uims.dao;

import me.lym.myspace.core.uims.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    @Insert("insert into ac_user(id,username,password) values(#{id},#{username},#{password})")
    int newUser(User user);

    @Delete("delete from ac_user where id = #{id}")
    boolean deleteById(String id);

    @Update("update ac_user set id = #{id}, username = #{username}, password = #{password} where id = #{id}")
    int updateById(User user);

    @Update("update ac_user set id = #{id}, username = #{username}, password = #{password} where username = #{username}")
    int updateByUsername(User user);

    @Select("select id,username,password from ac_user where id = #{id}")
    User queryById(String id);

    @Select("select id,username,password,is_enabled,is_credentials_non_expired,is_account_not_locked,is_account_not_expired from ac_user where username = #{username}")
    User queryByUsername(String username);

    @Select("select id,username,password from ac_user limit #{limit} offset #{offset}")
    List<User> queryWithPage(Integer limit, Integer offset);

    @Select("select ac_user.id,ac_user.username,ac_user.password from ac_user_join_group left join ac_user on ac_user_join_group.user_id = ac_user.id where ac_user_join_group.group_id = #{groupId}")
    List<User> queryByGroupId(String groupId);

    @Update("update ac_user set password = #{newPassword} where username = #{username} and password = #{oldPassword}")
    void changePassword(String username, String oldPassword, String newPassword);

    @Select("select exists(select id from ac_user where username=#{username})")
    boolean userExists(String username);
}
