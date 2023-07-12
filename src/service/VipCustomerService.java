package service;

import dao.VipCustomerMapper;
import entity.VipCustomer;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.ArrayList;

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
    public int deleteVipCusById(int id){
        SqlSession session = null;
        int result =0;
        try {
            session = MybatisUtil.getSesseion();
            VipCustomerMapper vipCustomerMapper = session.getMapper(VipCustomerMapper.class);
            result = vipCustomerMapper.deleVipCusById(id);
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

    public int deleteVipCusBySystemId(int systemId){
        SqlSession session = null;
        int result =0;
        try {
            session = MybatisUtil.getSesseion();
            VipCustomerMapper vipCustomerMapper = session.getMapper(VipCustomerMapper.class);
            result = vipCustomerMapper.deleVipCusBySystemId(systemId);
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

    public ArrayList<VipCustomer> selectAllVipCustomer(){
        SqlSession session = null;
        ArrayList<VipCustomer> vips = null;
        try {
            session = MybatisUtil.getSesseion();
            VipCustomerMapper vipCustomerMapper = session.getMapper(VipCustomerMapper.class);
            vips = vipCustomerMapper.selectAllVipCustomer();
            session.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
        return vips;
    }

}
