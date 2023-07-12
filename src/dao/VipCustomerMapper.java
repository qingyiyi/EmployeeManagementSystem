package dao;

import entity.VipCustomer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface VipCustomerMapper {
    @Insert("INSERT INTO vipcustomer (productType,companyName,website,id,regTime,password,contractAmount,recharge,contactPerson,employee,contractId) "+
            " VALUES (#{productType},#{companyName},#{website},#{id},#{regTime},#{password},#{contractAmount},#{recharge},#{contactPerson},#{employee},#{contractId})")
    public int addVipCus(VipCustomer vipCustomer);

    @Delete("Delete from vipcustomer where id=#{id}")
    public int deleVipCusById(int id);

    @Delete("Delete from vipcustomer where systemId=#{id}")
    public int deleVipCusBySystemId(int id);

    @Select("select * from vipcustomer")
    public ArrayList<VipCustomer> selectAllVipCustomer();

}
