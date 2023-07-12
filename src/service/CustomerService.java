package service;

import dao.CustomerMapper;
import dao.LoginMapper;
import entity.Customer;
import entity.UserLogin;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.ArrayList;

public class CustomerService {

    public Customer selectCustomerById(int id) {
        SqlSession session = null;
        Customer customer = null;
        try {
            session = MybatisUtil.getSesseion();   //Mybatis的工具类完成session工厂的建立与返回session
            CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
            customer = customerMapper.SelectById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {   //finally字段保证即使出现错误，也将执行完该代码块
            if(session!=null){
                session.close();
            }
        }
        return customer;
    }

    public ArrayList<Customer> selectCustomerByLimits(String yixiang,String yuangong){
        SqlSession session = null;
        ArrayList<Customer> customers = null;
        String trueYixiang=null;
        String trueYuangong=null;
        String quan="全部";
        if(!yixiang.equals(quan)&& !yixiang.equals("")){
            trueYixiang=yixiang;
        }
        if(!yuangong.equals(quan)&&!yuangong.equals("")){
            trueYuangong=yuangong;
        }
        try {
            session = MybatisUtil.getSesseion();   //Mybatis的工具类完成session工厂的建立与返回session
            CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
            customers = customerMapper.selectCustomerByLimits(trueYixiang,trueYuangong);
        }catch (Exception e){
            e.printStackTrace();
        }finally {   //finally字段保证即使出现错误，也将执行完该代码块
            if(session!=null){
                session.close();
            }
        }
        return customers;
    }

    public ArrayList<Customer> selectMyCustomerByLimits(String yixiang,String yuangong,String username){
        SqlSession session = null;
        ArrayList<Customer> customers = null;
        String trueYixiang=null;
        String trueYuangong=null;
        String quan="全部";
        if(!yixiang.equals(quan)&& !yixiang.equals("")){
            trueYixiang=yixiang;
        }
        if(!yuangong.equals(quan)&&!yuangong.equals("")){
            trueYuangong=yuangong;
        }
        try {
            session = MybatisUtil.getSesseion();
            CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
            customers = customerMapper.selectMyCustomerByLimits(trueYixiang,trueYuangong,username);
        }catch (Exception e){
            e.printStackTrace();
        }finally {   //finally字段保证即使出现错误，也将执行完该代码块
            if(session!=null){
                session.close();
            }
        }
        return customers;
    }
    public int addCustomer(Customer customer){
        SqlSession session = null;
        int result =0;
        try {
            session = MybatisUtil.getSesseion();
            CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
            customerMapper.insertCustomer(customer);
        }catch (Exception exception){
            exception.printStackTrace();
            session.rollback();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return result;
    }

    public int deleteCustomerById(String cusid) {
        SqlSession session = null;
        int result =0;
        try {
            session = MybatisUtil.getSesseion();
            CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
            customerMapper.deleteCustomerById(cusid);
        }catch (Exception exception){
            exception.printStackTrace();
            session.rollback();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return result;
    }

    public int updateCustomer(Customer customer) {
        SqlSession session = null;
        int result =0;
        try {
            session = MybatisUtil.getSesseion();
            CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
            result =customerMapper.updateCustomer(customer);
            session.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            session.rollback();
        }
        return result;
    }
}
