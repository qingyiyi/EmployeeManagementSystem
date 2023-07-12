package cotroller;

import entity.UserLogin;
import entity.VipCustomer;
import service.LoginService;
import service.VipCustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "VipCustomerServlet", value = "/VipCustomerServlet")
public class VipCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("User");
        LoginService loginService = new LoginService();
        UserLogin userLogin = loginService.VerifyAccount(name);
        request.setAttribute("User",userLogin);
        request.getRequestDispatcher("vip_luru.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //default setup
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String State = request.getParameter("State");
        if(State==null){
            String name = request.getParameter("User");
            LoginService loginService = new LoginService();
            UserLogin userLogin = loginService.VerifyAccount(name);
            request.setAttribute("User",userLogin);
            request.getRequestDispatcher("vip_luru.jsp").forward(request,response);

        }else if(State.equals("Add")) {
            VipCustomer vip = new VipCustomer();
            VipCustomerService vipCustomerService = new VipCustomerService();
            //get information from website

            String sid = request.getParameter("id");
            vip.setCompanyName(request.getParameter("companyname"));
            vip.setProductType(request.getParameter("producttype"));
            vip.setPassword(request.getParameter("password"));
            String amount = request.getParameter("contractamount");
            vip.setRecharge(request.getParameter("recharge"));
            vip.setContactPerson(request.getParameter("contactperson"));
            vip.setWebsite(request.getParameter("website"));

            int id = Integer.parseInt(sid);
            vip.setId(id);
            String regTime = new Date().toString();
            vip.setRegTime(regTime);
            vip.setEmployee(request.getParameter("employee"));
            double contractAmount = Double.parseDouble(amount);
            vip.setContractAmount(contractAmount);
            vip.setContractId(request.getParameter("contractId"));
            //add to sql
            int result = vipCustomerService.addVipCus(vip);
            //finish window (to be done
            //写回结果
            response.getWriter().print(result>0);
            request.getRequestDispatcher("vip_list.jsp").forward(request,response);
        }else if(State.equals("Delete")){

        }
    }
}
