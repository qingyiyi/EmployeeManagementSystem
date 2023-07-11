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
        request.setCharacterEncoding("utf-8");   //设置编码
        response.setCharacterEncoding("utf-8");

        String State = request.getParameter("State");
        if(State==null) {
            String Username = request.getParameter("UserName");
            String PassWord = request.getParameter("PassWord");

            //校验用户信息是否正确
            LoginService loginService = new LoginService();
            UserLogin user = loginService.VerifyAccount(Username);
            //校验正确
            if (PassWord.equals(user.getPassword())) {
                request.setAttribute("User", user);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                //校验不正确

            }
        }else if(State.equals("Exit")){
            //用户退出时
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
