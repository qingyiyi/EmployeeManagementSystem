package service;

import dao.LoginMapper;
import entity.UserLogin;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;



public class LoginService {
    /**
     * 校验账户是否正确
     * @param userName
     * @return
     */
    public UserLogin VerifyAccount(String userName) {
        SqlSession session = null;
        UserLogin user = null;
        try {
            session = MybatisUtil.getSesseion();   //Mybatis的工具类完成session工厂的建立与返回session
            LoginMapper loginMapper = session.getMapper(LoginMapper.class);
            user = loginMapper.SelectByName(userName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {   //finally字段保证即使出现错误，也将执行完该代码块
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
            session = MybatisUtil.getSesseion();   //Mybatis的工具类完成session工厂的建立与返回session
            LoginMapper loginMapper = session.getMapper(LoginMapper.class);
            result = loginMapper.UpdateUserInfo(user.getName(), user.getPhoto(),user.getEmployeeId());
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
}
