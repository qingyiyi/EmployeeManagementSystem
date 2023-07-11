package test;

import entity.VipCustomer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import service.VipCustomerService;

import java.io.IOException;
import java.io.InputStream;

public class VipTest {
    private SqlSession session = null;
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session  = sqlSessionFactory.openSession();
    }
    @Test
    public void setVipCustomerTest(){
        VipCustomer vipCustomer = new VipCustomer();
        vipCustomer.setProductType("type");
        vipCustomer.setCompanyName("testCompany");
        vipCustomer.setWebsite("webt");
        vipCustomer.setContractAmount(111111);
        vipCustomer.setContactPerson("tesstperson");
        vipCustomer.setEmployee("testemp");
        vipCustomer.setRecharge("re?");
        vipCustomer.setRegTime("reg1111");
        vipCustomer.setId(1);
        vipCustomer.setSystemId(1);
        vipCustomer.setPassword("121gaoi");
        VipCustomerService vipCustomerService = new VipCustomerService();
        int i = vipCustomerService.addVipCus(vipCustomer);
        System.out.print(i);

    }

}
