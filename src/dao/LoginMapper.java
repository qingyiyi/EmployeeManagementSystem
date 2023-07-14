package dao;

import entity.UserLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

public interface LoginMapper {
    @Select("select * from userlogin where name=#{name}")
    public UserLogin SelectByName(@Param("name") String name);

    @Select("select * from userlogin")
    public ArrayList<UserLogin> SelectAllUsers();

    @Update("UPDATE userlogin SET name=#{name},photo=#{photo} where employeeId=#{employeeId}")
    public int UpdateUserInfo(@Param("name") String name, @Param("photo") String photo, @Param("employeeId") String employeeId);

    @Insert("insert into userlogin (password,employeeId,name,photo,department,position,isAdministrator,time) " +
            "values(#{password},#{employeeId},#{name},#{photo},#{department},#{position},#{isAdministrator},#{time})")
    public int insertUser(UserLogin user);

}
