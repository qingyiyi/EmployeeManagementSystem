package test;

import entity.DepartmentPosition;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.DepartmentPositionService;
import service.DepartmentService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DepartmentPositionTest {
    private SqlSession session = null;
    DepartmentPositionService positionService = new DepartmentPositionService();
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session  = sqlSessionFactory.openSession();
    }

    @Test
    public void insertPositionTest(){
        DepartmentPosition dep = new DepartmentPosition();
        dep.setPositionName("test");
        dep.setPositionIntroduction("test");
        dep.setRanking(1);
        dep.setDepartmentName("test");
        positionService.insertPosition(dep);
    }

    @Test
    public void selectAllPositionTest(){
        ArrayList<DepartmentPosition> positions = positionService.selectAllPosition();
        System.out.println(positions);
    }

    @Test
    public void selectPositionByIdTest(){
        int id=1;
        System.out.println(positionService.selectPositionById(id));
    }

    @Test
    public void deletePositionByIdTest(){
        int id=1;
        System.out.println(positionService.deletePositionById(id));
    }
    @Test
    public void updateSortConflictTest(){
        int original=2;
        int conflict=4;
        positionService.updateSortConflict(conflict,original);
    }

    @Test
    public void checkRankingConflictTest(){
        int newrank=1;
        positionService.checkRankingConflict(1);
    }

    @Test
    public void updatePositionTest(){
        DepartmentPosition position = positionService.selectPositionById(1);
        position.setPositionName("change");
        positionService.updatePosition(position);
    }

    @After
    public void After() throws IOException{
        session.close();
    }
}
