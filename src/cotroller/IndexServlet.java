package cotroller;

import entity.UserLogin;
import service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");   //…Ë÷√±‡¬Î
        response.setCharacterEncoding("utf-8");

        String State = request.getParameter("State");

        if(State==null){
            String name = request.getParameter("User");
            LoginService loginService = new LoginService();
            UserLogin userLogin = loginService.VerifyAccount(name);
            request.setAttribute("User",userLogin);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
