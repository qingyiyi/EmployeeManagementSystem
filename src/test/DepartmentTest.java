package test;

import entity.Department;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.DepartmentService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DepartmentTest {
    private SqlSession session = null;
    DepartmentService departmentService = new DepartmentService();
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session  = sqlSessionFactory.openSession();

    }

    @Test
    public void insertDepartmentInsertTest(){
        Department department = new Department();
        department.setName("testname1");
        department.setRanking(1);
        department.setIntroduction("213132512");
        System.out.println(departmentService.insertDepartment(department));
    }

    @Test
    public void deleteDepartmentTest(){
        int id=3;
        departmentService.deleteDepartmentById(id);
    }

    @Test
    public void selectAllDepartmentTest(){
        ArrayList<Department> arr = new ArrayList<Department>();
        arr = departmentService.selectAllDepartment();
        System.out.println(arr);
    }

    @Test
    public void selectDepartmentByIdTest(){
        int id=1;
        Department department = departmentService.selectDepartmentById(id);
        System.out.println(department);
    }

    @Test
    public void updateSortConflictTest(){
        int conflictRank = 3;
        int originalRank = 1;
        int result = departmentService.updateSortConflict(conflictRank,originalRank);
        System.out.println(result);
    }

    @Test
    public void checkIfRankingConflictTest(){
        int newRanking =3;
        boolean result = departmentService.checkIfRankingConflict(newRanking);
        System.out.println(result);
    }

    @After
    public void After() throws IOException{
        session.close();
    }
}
