package cotroller;

import entity.Department;
import service.DepartmentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "DepartmentServlet", value = "/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");   //设置编码
        response.setCharacterEncoding("utf-8");

        String State = request.getParameter("State");
        DepartmentService departmentService = new DepartmentService();
        //仅后端操作，没有写页面跳转
        if(State.equals("insert")){
            // 从前端获取数据
            String departmentName = request.getParameter("departmentname");
            String ranking = request.getParameter("ranking");
            String introduction = request.getParameter("introduction");

            // 创建对象，赋值
            Department department = new Department();
            department.setRanking(Integer.parseInt(ranking));
            department.setIntroduction(introduction);
            department.setName(departmentName);

            departmentService.insertDepartment(department);

        }else if(State.equals("delete")){
            // 从前端获取ID
            String id = request.getParameter("departmentid");
            departmentService.deleteDepartmentById(Integer.parseInt(id));
        } else if(State.equals("change")){
            // 点击修改时调用该函数,需要前端返回该用户的id，后端读取数据后写回前端，在输入框中填写
            // 点击确认后传update再次获取这些数据并改入数据库中

            String id = request.getParameter("departmentid");
            Department department = departmentService.selectDepartmentById(Integer.parseInt(id));
            request.setAttribute("departmentname",department.getName());
            request.setAttribute("ranking",department.getRanking());
            request.setAttribute("introduction",department.getIntroduction());

        }else if(State.equals("update")){
            // 点击修改确认时调用该函数
            String id = request.getParameter("id");
            Department updateDepartment = departmentService.selectDepartmentById(Integer.parseInt(id));
            if(updateDepartment!=null){
                int originalRanking = updateDepartment.getRanking();

                updateDepartment.setName(request.getParameter("departmentname"));
                int newRanking = Integer.parseInt(request.getParameter("ranking"));
                updateDepartment.setRanking(newRanking);
                updateDepartment.setIntroduction(request.getParameter("introduction"));
                // 产生ranking冲突时调用
                if(originalRanking!=newRanking&&departmentService.checkIfRankingConflict(newRanking)){
                    departmentService.updateSortConflict(newRanking,originalRanking);
                }
            }
            // 查不到的时候会返回null
            request.setAttribute("updatedepartment",updateDepartment);
        }else {
            ArrayList<Department> departments = departmentService.selectAllDepartment();
            request.setAttribute("departments",departments);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
