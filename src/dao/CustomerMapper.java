package dao;

import entity.Customer;
import entity.UserLogin;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface CustomerMapper {
    @Select("select * from customer where id=#{id}")
    public Customer SelectById(@Param("id") int id);

    @Select("<script>"+
            "select * from customer where true" +
            "<if test='yixiang!=null'> and interest=#{yixiang}</if> "+
            "<if test='yuangong!=null'> and employee=#{yuangong}</if> "+
//            "<if test='siv.banxingFenlei!=null'> and shopname like concat('%',#{siv.banxingFenlei},'%')</if> "+
            "</script>")
    ArrayList<Customer> selectCustomerByLimits(@Param("yixiang")String yixiang,@Param("yuangong") String yuangong);

    @Select("<script>"+
            "select * from customer where true" +
            "<if test='yixiang!=null'> and interest=#{yixiang}</if> "+
            "<if test='yuangong!=null'> and employee=#{yuangong}</if> "+
            " and employee=#{username} "+
            "</script>")
    ArrayList<Customer> selectMyCustomerByLimits(String trueYixiang, String trueYuangong, String username);

    @Insert("insert into customer (interest,website,companyName,companyAddress,contactPerson,contactNumber,contactResult,employee,addTime)"+
    " VALUES (#{interest},#{website},#{companyName},#{companyAddress},#{contactPerson},#{contactNumber},#{contactResult},#{employee},#{addTime})")
    public int insertCustomer(Customer customer);

    @Delete("delete from customer where id=#{cusid}")
    public int deleteCustomerById(String cusid);

    @Update("update customer set interest=#{interest},website=#{website},companyName=#{companyName},"+
            "companyAddress=#{companyAddress},contactPerson=#{contactPerson},contactNumber=#{contactNumber},"+
            "contactResult=#{contactResult} where id=#{id}")
    public int updateCustomer(Customer customer);
}
