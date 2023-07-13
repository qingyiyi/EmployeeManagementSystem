package dao;

import entity.DepartmentPosition;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface DepartmentpositionMapper {
    @Insert("insert into departmentposition (departmentName,positionName,positionIntroduction,ranking) " +
            " VALUES (#{departmentName},#{positionName},#{positionIntroduction},#{ranking})")
    public int insertPosition(DepartmentPosition position);

    @Select("select * from departmentposition")
    public ArrayList<DepartmentPosition> selectAllPosition();

    @Select("select * from departmentposition where id=#{id}")
    public DepartmentPosition selectPositionById(int id);

    @Delete("delete from departmentposition where id=#{id}")
    public int deletePositionById(int parseInt);

    @Update("<script>"+
            "UPDATE departmentposition SET "+
            "<if test='conflictRank lt originalRank'>ranking=ranking+1 where ranking between #{conflictRank} and #{originalRank}</if>"+
            "<if test='conflictRank gt originalRank'>ranking=ranking-1 where ranking between #{originalRank} and #{conflictRank}</if>"+
            "</script>")
    int updateSortConflict(@Param("conflictRank") int conflictRank, @Param("originalRank") int originalRank);

    @Update("update departmentposition set ranking=ranking-1 where ranking>=#{rank}")
    int updateRankWhileDelete(int rank);

    @Select("select count(*)=1 from departmentposition where ranking=#{newRanking}")
    public boolean checkIfRankingConflict(int newRanking);

    @Update("update departmentposition set ranking=ranking+1 where ranking>=#{newRanking}")
    public int solveRankingConflict(@Param("newRanking") int newRanking);

    @Update("update departmentposition set departmentName=#{departmentName},positionName=#{positionName}" +
            ",positionIntroduction=#{positionIntroduction},ranking=#{ranking} where id=#{id}")
    public int updatePosition(DepartmentPosition position);
}
