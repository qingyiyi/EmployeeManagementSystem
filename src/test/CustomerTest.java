package test;

import entity.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.CustomerService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CustomerTest {
    private SqlSession session = null;
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session  = sqlSessionFactory.openSession();
    }

    @Test
    public void selectCustomerByLimitsTest(){
        CustomerService customerService = new CustomerService();
        String yixiang="大";
        String yuangong="李四";
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers = customerService.selectCustomerByLimits(yixiang,yuangong);
        System.out.println(customers);
    }

    @Test
    public void updateCustomerTest(){
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.selectCustomerById(1);
        customer.setContactPerson("changep");
        customer.setEmployee("change2");
        int result =customerService.updateCustomer(customer);
        System.out.println(customer);
        System.out.println(result);
    }
    @After
    public void After() throws IOException{
        session.close();
    }
}
