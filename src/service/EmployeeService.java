package service;

import dao.CustomerMapper;
import dao.EmployeeMapper;
import entity.Customer;
import entity.Employee;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.ArrayList;

public class EmployeeService {
    public Employee setlectEmployeeById(int id) {
        SqlSession session = null;
        Employee employee = null;
        try {
            session = MybatisUtil.getSesseion();   //Mybatis的工具类完成session工厂的建立与返回session
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            employee = employeeMapper.selectById(id);

        }catch (Exception e){
            e.printStackTrace();
        }finally {   //finally字段保证即使出现错误，也将执行完该代码块
            if(session!=null){
                session.close();
            }
        }
        return employee;
    }

    public int insertEmployee(Employee employee){
        SqlSession session = null;
        int result=0;
        try {
            session = MybatisUtil.getSesseion();   //Mybatis的工具类完成session工厂的建立与返回session
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            result = employeeMapper.insertEmployee(employee);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {   //finally字段保证即使出现错误，也将执行完该代码块
            if(session!=null){
                session.close();
            }
        }
        return result;
    }

    public int updateSortConflict(int conflictRank,int originalRank){
        SqlSession session = null;
        int result = 0;
        try{
            session = MybatisUtil.getSesseion();
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            result = employeeMapper.updateSortConflict(conflictRank,originalRank);
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

    public boolean checkRankingConflict(int newRanking) {
        SqlSession session = null;
        boolean result = false;
        try{
            session = MybatisUtil.getSesseion();
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            result = employeeMapper.checkIfRankingConflict(newRanking);
            if(result){
                employeeMapper.solveRankingConflict(newRanking);
                session.commit();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return result;
    }

    public int updateEmployee(Employee employee) {
        SqlSession session = null;
        int result = 0;
        try{
            session = MybatisUtil.getSesseion();
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            result = employeeMapper.updateEmployee(employee);
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

    public int deleteEmployeeById(int parseInt) {
        SqlSession session = null;
        int result=0;
        try{
            session = MybatisUtil.getSesseion();
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectById(parseInt);
            result = employeeMapper.deleteEmployeeById(parseInt);
            result += employeeMapper.updateRankWhileDelete(employee.getRanking());
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

    public ArrayList<Employee> selectAll() {
        SqlSession session = null;
        ArrayList<Employee> employees = new ArrayList<>();
        try{
            session = MybatisUtil.getSesseion();
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            employees = employeeMapper.selectAll();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return employees;
    }
}
