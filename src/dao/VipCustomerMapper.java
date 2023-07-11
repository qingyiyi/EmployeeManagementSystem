package dao;

import entity.VipCustomer;
import org.apache.ibatis.annotations.Insert;

public interface VipCustomerMapper {
    @Insert("INSERT INTO vipcustomer (productType,companyName,website,id,regTime,password,contractAmount,recharge,contactPerson,employee) "+
            " VALUES (#{productType},#{companyName},#{website},#{id},#{regTime},#{password},#{contractAmount},#{recharge},#{contactPerson},#{employee})")
    public int addVipCus(VipCustomer vipCustomer);

}
