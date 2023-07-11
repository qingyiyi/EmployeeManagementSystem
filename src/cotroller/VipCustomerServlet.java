package cotroller;

import entity.VipCustomer;
import service.VipCustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VipCustomerServlet", value = "/VipCustomerServlet")
public class VipCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //default setup
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        VipCustomer vip = new VipCustomer();
        VipCustomerService vipCustomerService = new VipCustomerService();
        //get information from website
        vip.setProductType(request.getParameter("producttype"));
        vip.setCompanyName(request.getParameter("companyname"));
        vip.setWebsite(request.getParameter("website"));
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        vip.setId(id);
        String regTime = request.getParameter("regtime");
        vip.setRegTime(regTime);
        vip.setPassword(request.getParameter("password"));
        String amount = request.getParameter("contractamount");
        double contractAmount = Double.parseDouble(amount);
        vip.setRecharge(request.getParameter("recharge"));
        vip.setContactPerson(request.getParameter("contactperson"));
        vip.setContractAmount(contractAmount);
        vip.setEmployee(request.getParameter("employee"));
        //add to sql
        vipCustomerService.addVipCus(vip);
        //finish window (to be done
    }
}
