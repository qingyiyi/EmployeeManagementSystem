package cotroller;

import entity.UserLogin;
import service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListServlet", value = "/ListServlet")
public class ListServlet extends HttpServlet {
    //��Servlet���ڷ�����childҳ��
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");   //���ñ���
        response.setCharacterEncoding("utf-8");

        String name = request.getParameter("User");
        LoginService loginService = new LoginService();
        UserLogin userLogin = loginService.VerifyAccount(name);
        request.setAttribute("User",userLogin);
        //����Ա�����ǹ���Ա�����ԣ���ת����ͬ����ͼ
        if(userLogin.getIsAdministrator()==0) {
            request.getRequestDispatcher("child.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("child2.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
