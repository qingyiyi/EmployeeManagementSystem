package service;

import dao.VipCustomerMapper;
import entity.VipCustomer;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

public class VipCustomerService {
    public int addCus(VipCustomer customer){
        SqlSession session = null;
        try {
            session = MybatisUtil.getSesseion();
            VipCustomerMapper vipCustomerMapper = session.getMapper(VipCustomerMapper.class);

        }catch (Exception ex){

        }finally {

        }
    }
}
