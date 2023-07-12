package cotroller;

import entity.Customer;
import entity.UserLogin;
import service.CustomerService;
import service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");   //设置编码
        response.setCharacterEncoding("utf-8");

        //通过从web获取state来确定执行的指令
        String State = request.getParameter("State");

        //获取当前员工账户，从web拉取员工的name来获取账户
        String username = request.getParameter("User");
        LoginService loginService = new LoginService();
        UserLogin user = loginService.getUserByName(username);

        CustomerService customerService = new CustomerService();
        //是管理员
        if(user.getIsAdministrator()==1){
            if(State.equals("showlist")||State==null){
                ArrayList<Customer> customers = customerService.selectCustomerByLimits("全部","全部");
                // 所有员工，用于在员工列表
                ArrayList<UserLogin> users = loginService.getAllUsers();
                //回传给web
                request.setAttribute("customers",customers);
                request.setAttribute("users",users);
                request.getRequestDispatcher("daily_list.jsp").forward(request, response);
            }else if(State.equals("search")){
                //条件筛选下拉框“意向”的值
                String yixiang = request.getParameter("yixiang");
                //下拉框员工部分
                String yuangong = request.getParameter("yuangong");
                //关键词部分（tobedone）

                ArrayList<Customer> customers = customerService.selectCustomerByLimits(yixiang,yuangong);
                //回传给web
                request.setAttribute("customers",customers);
            }
        }
        // 非管理员
        else{
            if(State.equals("showlist")||State==null){
                ArrayList<Customer> customers = customerService.selectMyCustomerByLimits("全部","全部",username);
                //回传给web
                request.setAttribute("customers",customers);
                request.getRequestDispatcher("daily_list.jsp").forward(request, response);
            }else if(State.equals("search")){
                //条件筛选下拉框“意向”的值
                String yixiang = request.getParameter("yixiang");
                //下拉框员工部分
                String yuangong = request.getParameter("yuangong");
                //关键词部分（tobedone）

                ArrayList<Customer> customers = customerService.selectMyCustomerByLimits(yixiang,yuangong,username);
                //回传给web
                request.setAttribute("customers",customers);
            }else if(State.equals("add")){
                //本部分实现的是”我的意向客户管理“中”+“部分功能（添加客户）
                Customer customer = new Customer();
                customer.setInterest(request.getParameter("yixiang"));
                customer.setWebsite(request.getParameter("website"));
                customer.setCompanyName(request.getParameter("companyname"));
                customer.setContactPerson(request.getParameter("contactperson"));
                customer.setContactNumber(request.getParameter("contactnumber"));
                customer.setContactResult(request.getParameter("contactresult"));
                customer.setCompanyAddress(request.getParameter("companyaddress"));
                customer.setEmployee(username);
                java.sql.Date time = new java.sql.Date(new java.util.Date().getTime());
                customer.setAddTime(time);
                customerService.addCustomer(customer);
            }else if(State.equals("delete")){
                //选中点击后返回该对象的id即可
                String cusid = request.getParameter("customerid");
                customerService.deleteCustomerById(cusid);
            }else if(State.equals("change")){
                // 更改按钮在前端没有给出页面，可以用类似增加的弹窗实现（大概）
                // 需要前端返回该用户的id，后端读取数据后写回前端，在输入框中填写，点击确认后传checkchange再次获取这些数据并改入数据库中

                String cusid = request.getParameter("customerid");
                Customer customer = customerService.selectCustomerById(Integer.parseInt(cusid));
                request.setAttribute("yixiang",customer.getInterest());
                request.setAttribute("website",customer.getWebsite());
                request.setAttribute("companyname",customer.getCompanyName());
                request.setAttribute("contactperson",customer.getContactPerson());
                request.setAttribute("contactnumber",customer.getContactNumber());
                request.setAttribute("contactresult",customer.getContactResult());
                request.setAttribute("companyaddress",customer.getCompanyAddress());
            }else if(State.equals("checkchange")){
                String cusid = request.getParameter("customerid");
                Customer customer = customerService.selectCustomerById(Integer.parseInt(cusid));
                customer.setInterest(request.getParameter("yixiang"));
                customer.setWebsite(request.getParameter("website"));
                customer.setCompanyName(request.getParameter("companyname"));
                customer.setContactPerson(request.getParameter("contactperson"));
                customer.setContactNumber(request.getParameter("contactnumber"));
                customer.setContactResult(request.getParameter("contactresult"));
                customer.setCompanyAddress(request.getParameter("companyaddress"));
                customerService.updateCustomer(customer);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
