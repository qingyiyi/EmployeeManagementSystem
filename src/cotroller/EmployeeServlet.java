package cotroller;

import entity.Employee;
import entity.UserLogin;
import service.EmployeeService;
import service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("test/html;charset=UTF-8");

        String State = request.getParameter("State");
        EmployeeService employeeService = new EmployeeService();
        LoginService loginService = new LoginService();
        if(State.equals("insert")){
            // insert页面有一个简历图片上传，还需要一个头像上传,多了一个用户名输入（或许是登录账号那块？）
            // 目前我给新建的userlogin账号填写的name是username
            String username = request.getParameter("username");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String sex = request.getParameter("sex");
            String employeeId = request.getParameter("employeeid");
            String department = request.getParameter("department");
            String position = request.getParameter("position");
            String strranking = request.getParameter("ranking");
            int ranking = Integer.parseInt(strranking);
            String resume = request.getParameter("resume");
//            String photo = request.getParameter("photo");
            String photo = "images/photo/default.jpg";
            String level = request.getParameter("level");

            Employee employee = new Employee();
            employee.setName(username);
            employee.setEmployeeId(employeeId);
            employee.setSex(sex);
            employee.setDepartment(department);
            employee.setPosition(position);
            employee.setLevel(level);
            employee.setRanking(ranking);
            employee.setAuthority("0");
            employee.setResume(resume);

            UserLogin userLogin = new UserLogin();
            userLogin.setEmployeeId(employeeId);
            userLogin.setPassword(password);
            userLogin.setDepartment(department);
            userLogin.setPosition(position);
            userLogin.setIsAdministrator(0);
            userLogin.setName(name);
            userLogin.setPhoto(photo);
            Date regTime = new Date();
            userLogin.setTime(regTime);

            loginService.insertUser(userLogin);
            employeeService.checkRankingConflict(ranking);
            employeeService.insertEmployee(employee);
        }else if(State.equals("update")){
            String id = request.getParameter("updateid");
            Employee employee = employeeService.setlectEmployeeById(Integer.parseInt(id));
            int result=0;
            if(employee!=null){
                int originalRank = employee.getRanking();
                int newRank = Integer.parseInt(request.getParameter("ranking"));
                employeeService.updateSortConflict(originalRank,newRank);
                employee.setRanking(newRank);
                employee.setName(request.getParameter("name"));
                employee.setEmployeeId(request.getParameter("employeeid"));
                employee.setSex(request.getParameter("sex"));
                employee.setDepartment(request.getParameter("department"));
                employee.setPosition(request.getParameter("position"));
                employee.setLevel(request.getParameter("level"));
                employee.setResume(request.getParameter("resume"));
                employeeService.updateEmployee(employee);
                result = 1;
            }else{result=0;}
            // update成功返回1，否则返回0
            request.setAttribute("updateresult",result);
        }else if(State.equals("delete")){
            // 前端返回要删除的对象的id
            String id = request.getParameter("deleteid");
            int result = employeeService.deleteEmployeeById(Integer.parseInt(id));
            // 删除成功返回1，否则返回0
            request.setAttribute("result",result);
        }else{
        ArrayList<Employee> employees = new ArrayList<>();
        employees =  employeeService.selectAll();
        request.setAttribute("employees",employees);
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
