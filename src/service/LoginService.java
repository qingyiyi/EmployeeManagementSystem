package service;

import dao.LoginMapper;
import entity.UserLogin;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.ArrayList;


public class LoginService {
    /**
     * У���˻��Ƿ���ȷ
     * @param userName
     * @return
     */
    public UserLogin VerifyAccount(String userName) {
        SqlSession session = null;
        UserLogin user = null;
        try {
            session = MybatisUtil.getSesseion();
            LoginMapper loginMapper = session.getMapper(LoginMapper.class);
            user = loginMapper.SelectByName(userName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return user;
    }

    public int UpdateAccount(UserLogin user) {
        SqlSession session = null;
        int result = 0;
        try {
            session = MybatisUtil.getSesseion();
            LoginMapper loginMapper = session.getMapper(LoginMapper.class);
            result = loginMapper.UpdateUserInfo(user.getName(), user.getPhoto(),user.getEmployeeId());
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return result;
    }

    public UserLogin getUserByName(String username){
        SqlSession session = null;
        UserLogin user = new UserLogin();
        try {
            session = MybatisUtil.getSesseion();
            LoginMapper loginMapper = session.getMapper(LoginMapper.class);
            user = loginMapper.SelectByName(username);
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
        return user;
    }

    public ArrayList<UserLogin> getAllUsers() {
        SqlSession session = null;
        ArrayList<UserLogin> allUsers = null;
        try {
            session = MybatisUtil.getSesseion();
            LoginMapper loginMapper = session.getMapper(LoginMapper.class);
            allUsers = loginMapper.SelectAllUsers();
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
        return allUsers;
    }
}
