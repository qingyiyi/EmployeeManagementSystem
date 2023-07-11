package dao;

import entity.UserLogin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LoginMapper {
    @Select("select * from userlogin where name=#{name}")
    public UserLogin SelectByName(@Param("name") String name);

    @Update("UPDATE userlogin SET name=#{name},photo=#{photo} where employeeId=#{employeeId}")
    public int UpdateUserInfo(@Param("name") String name, @Param("photo") String photo, @Param("employeeId") String employeeId);

}
