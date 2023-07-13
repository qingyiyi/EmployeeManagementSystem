package dao;

import entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface DepartmentMapper {

    @Insert("INSERT INTO department (name,introduction,ranking) "+
            " VALUES (#{name},#{introduction},#{ranking})")
    public int insertDepartment(Department department);

    @Delete("delete from department where id=#{id}")
    public int deleteDepartmentById(int id);

    @Select("select * from department")
    public ArrayList<Department> selectAllDepartment();

    @Select("select * from department where id=#{id}")
    public Department selectDepartmentById(int id);

    @Update("<script>"+
            "UPDATE department SET "+
            "<if test='conflictRank lt originalRank'>ranking=ranking+1 where ranking between #{conflictRank} and #{originalRank}</if>"+
            "<if test='conflictRank gt originalRank'>ranking=ranking-1 where ranking between #{originalRank} and #{conflictRank}</if>"+
            "</script>")
    int updateSortConflict(@Param("conflictRank") int conflictRank,@Param("originalRank") int originalRank);

    @Update("update department set ranking=ranking-1 where ranking>=#{rank}")
    int updateRankWhileDelete(int rank);

    @Select("select count(*)=1 from department where ranking=#{newRanking}")
    public boolean checkIfRankingConflict(int newRanking);
}
