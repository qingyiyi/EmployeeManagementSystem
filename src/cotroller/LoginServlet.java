package cotroller;

import entity.UserLogin;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");   //设置编码
        response.setCharacterEncoding("utf-8");

        String Username = request.getParameter("UserName");
        String PassWord = request.getParameter("PassWord");

        //校验用户信息是否正确
        LoginService loginService = new LoginService();
        UserLogin user = loginService.VerifyAccount(Username);

        if(PassWord.equals(user.getPassword())){
            request.setAttribute("User",user);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else{

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
