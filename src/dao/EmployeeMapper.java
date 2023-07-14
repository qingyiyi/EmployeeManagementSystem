package dao;

import entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface EmployeeMapper {
    @Select("select * from employee where id=#{id}")
    public Employee selectById(@Param("id") int id);

    @Select("select * from employee where name=#{name}")
    public Employee selectByName(@Param("name") String name);

    @Insert("insert into employee (department,name,position,employeeId,sex,ranking,level,authority,resume) " +
            "values(#{department},#{name},#{position},#{employeeId},#{sex},#{ranking},#{level},#{authority},#{resume})")
    public int insertEmployee(Employee employee);

    @Update("<script>"+
            "UPDATE employee SET "+
            "<if test='conflictRank lt originalRank'>ranking=ranking+1 where ranking between #{conflictRank} and #{originalRank}</if>"+
            "<if test='conflictRank gt originalRank'>ranking=ranking-1 where ranking between #{originalRank} and #{conflictRank}</if>"+
            "</script>")
    public int updateSortConflict(@Param("conflictRank") int conflictRank, @Param("originalRank") int originalRank);

    @Select("select count(*)=1 from employee where ranking=#{newRanking}")
    public boolean checkIfRankingConflict(int newRanking);

    @Update("update employee set ranking=ranking+1 where ranking>=#{newRanking}")
    public int solveRankingConflict(@Param("newRanking") int newRanking);

    @Update("update employee set department=#{department},name=#{name},position=#{position},employeeId=#{employeeId}," +
            "sex=#{sex},ranking=#{ranking},level=#{level},authority=#{authority},resume=#{resume} where id=#{id}")
    public int updateEmployee(Employee employee);

    @Delete("delete from employee where id=#{parseInt}")
    public int deleteEmployeeById(int parseInt);

    @Update("update employee set ranking=ranking-1 where ranking>=#{ranking}")
    public int updateRankWhileDelete(int ranking);

    @Select("select * from employee")
    public ArrayList<Employee> selectAll();
}
