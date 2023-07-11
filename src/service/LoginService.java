package service;

import dao.LoginMapper;
import entity.UserLogin;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;



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
            session = MybatisUtil.getSesseion();   //Mybatis�Ĺ��������session�����Ľ����뷵��session
            LoginMapper loginMapper = session.getMapper(LoginMapper.class);
            user = loginMapper.SelectByName(userName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {   //finally�ֶα�֤��ʹ���ִ���Ҳ��ִ����ô����
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
            session = MybatisUtil.getSesseion();   //Mybatis�Ĺ��������session�����Ľ����뷵��session
            LoginMapper loginMapper = session.getMapper(LoginMapper.class);
            result = loginMapper.UpdateUserInfo(user.getName(), user.getPhoto(),user.getEmployeeId());
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {   //finally�ֶα�֤��ʹ���ִ���Ҳ��ִ����ô����
            if(session!=null){
                session.close();
            }
        }
        return result;
    }
}
