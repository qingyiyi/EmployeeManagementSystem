package cotroller;

import entity.UserLogin;
import service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");   //���ñ���
        response.setCharacterEncoding("utf-8");

        String State = request.getParameter("State");
        if(State==null) {
            String Username = request.getParameter("UserName");
            String PassWord = request.getParameter("PassWord");

            //У���û���Ϣ�Ƿ���ȷ
            LoginService loginService = new LoginService();
            UserLogin user = loginService.VerifyAccount(Username);
            //У����ȷ
            if (PassWord.equals(user.getPassword())) {
                request.setAttribute("User", user);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                //У�鲻��ȷ

            }
        }else if(State.equals("Exit")){
            //�û��˳�ʱ
            String name = request.getParameter("User");
            LoginService loginService = new LoginService();
            UserLogin user = loginService.VerifyAccount(name);
            user.setTime(new Date());
            request.getSession().invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
