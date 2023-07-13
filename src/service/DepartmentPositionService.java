package service;

import dao.DepartmentMapper;
import dao.DepartmentpositionMapper;
import entity.DepartmentPosition;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.ArrayList;

public class DepartmentPositionService {

    public int insertPosition(DepartmentPosition position) {
        SqlSession session = null;
        int result =0;
        try{
            session = MybatisUtil.getSesseion();
            DepartmentpositionMapper positionMapper = session.getMapper(DepartmentpositionMapper.class);
            result = positionMapper.insertPosition(position);
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

    public ArrayList<DepartmentPosition> selectAllPosition() {
        SqlSession session = null;
        ArrayList<DepartmentPosition> positions = new ArrayList<DepartmentPosition>();
        try{
            session = MybatisUtil.getSesseion();
            DepartmentpositionMapper positionMapper = session.getMapper(DepartmentpositionMapper.class);
            positions = positionMapper.selectAllPosition();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return positions;
    }

    public DepartmentPosition selectPositionById(int id) {
        SqlSession session = null;
        DepartmentPosition position = new DepartmentPosition();
        try{
            session = MybatisUtil.getSesseion();
            DepartmentpositionMapper positionMapper = session.getMapper(DepartmentpositionMapper.class);
            position = positionMapper.selectPositionById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return position;
    }

    public int deletePositionById(int parseInt) {
        SqlSession session = null;
        int result=0;
        try{
            session = MybatisUtil.getSesseion();
            DepartmentpositionMapper positionMapper = session.getMapper(DepartmentpositionMapper.class);
            DepartmentPosition position = positionMapper.selectPositionById(parseInt);
            result = positionMapper.deletePositionById(parseInt);
            result += positionMapper.updateRankWhileDelete(position.getRanking());
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

    public int updateSortConflict(int conflictRank,int originalRank){
        SqlSession session = null;
        int result = 0;
        try{
            session = MybatisUtil.getSesseion();
            DepartmentpositionMapper positionMapper = session.getMapper(DepartmentpositionMapper.class);
            result = positionMapper.updateSortConflict(conflictRank,originalRank);
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
            DepartmentpositionMapper positionMapper = session.getMapper(DepartmentpositionMapper.class);
            result = positionMapper.checkIfRankingConflict(newRanking);
            if(result){
                positionMapper.solveRankingConflict(newRanking);
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


    public int updatePosition(DepartmentPosition position) {
        SqlSession session = null;
        int result = 0;
        try{
            session = MybatisUtil.getSesseion();
            DepartmentpositionMapper positionMapper = session.getMapper(DepartmentpositionMapper.class);
            result = positionMapper.updatePosition(position);
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
}
