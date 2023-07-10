package dao;

import entity.UserLogin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {
    @Select("select * from userlogin where name=#{name}")
    public UserLogin SelectByName(@Param("name") String name);
}
