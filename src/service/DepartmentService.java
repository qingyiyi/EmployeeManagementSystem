package service;

import dao.DepartmentMapper;
import entity.Department;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.ArrayList;

public class DepartmentService {
    public int insertDepartment(Department department){
        SqlSession session = null;
        int result =0;
        try{
            session = MybatisUtil.getSesseion();
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            result = departmentMapper.insertDepartment(department);
            session.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return result;
    }

    public int deleteDepartmentById(int id) {
        SqlSession session = null;
        int result =0;
        try{
            session = MybatisUtil.getSesseion();
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            Department department = departmentMapper.selectDepartmentById(id);
            result = departmentMapper.deleteDepartmentById(id);
            departmentMapper.updateRankWhileDelete(department.getRanking());
            session.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            session.rollback();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return result;
    }

    public ArrayList<Department> selectAllDepartment(){
        SqlSession session = null;
        ArrayList<Department> departments = null;
        try{
            session = MybatisUtil.getSesseion();
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            departments = departmentMapper.selectAllDepartment();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return departments;
    }

    public Department selectDepartmentById(int id){
        SqlSession session = null;
        Department department = null;
        try{
            session = MybatisUtil.getSesseion();
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            department = departmentMapper.selectDepartmentById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return department;
    }

    public int updateSortConflict(int conflictRank,int originalRank){
        SqlSession session = null;
        int result = 0;
        try{
            session = MybatisUtil.getSesseion();
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            result = departmentMapper.updateSortConflict(conflictRank,originalRank);
            session.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return result;
    }

    public boolean checkIfRankingConflict(int newRanking) {
        SqlSession session = null;
        boolean result = false;
        try{
            session = MybatisUtil.getSesseion();
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            result = departmentMapper.checkIfRankingConflict(newRanking);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return result;
    }
}
