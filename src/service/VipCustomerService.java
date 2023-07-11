package service;

import dao.VipCustomerMapper;
import entity.VipCustomer;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

public class VipCustomerService {
    public int addVipCus(VipCustomer customer){
        SqlSession session = null;
        int result =0;
        try {
            session = MybatisUtil.getSesseion();
            VipCustomerMapper vipCustomerMapper = session.getMapper(VipCustomerMapper.class);
            result = vipCustomerMapper.addVipCus(customer);
            session.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
        return result;
    }

}
