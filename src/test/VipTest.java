package test;

import dao.VipCustomerMapper;
import entity.VipCustomer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

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
        vipCustomer.setCompanyName("testCompany");
        vipCustomer.setContractAmount(111111);
        vipCustomer.setContactPerson("tesstperson");
        vipCustomer.setEmployee("testemp");
        vipCustomer.setRecharge("re?");
        vipCustomer.setRegTime("reg1111");
        vipCustomer.setSystemId(12351135);
        vipCustomer.setId(1);
        vipCustomer.setSystemId(1);
        vipCustomer.setPassword("121gaoi");
        VipCustomerMapper vipCustomerMapper = session.getMapper(VipCustomerMapper.class);
        int i = vipCustomerMapper.addVipCus(vipCustomer);
        System.out.print(i);

    }

}
