package cotroller;

import entity.DepartmentPosition;
import service.DepartmentPositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DepartmentPositionServlet", value = "/DepartmentPositionServlet")
public class DepartmentPositionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");   //设置编码
        response.setCharacterEncoding("utf-8");

        String State = request.getParameter("State");

        DepartmentPositionService positionService = new DepartmentPositionService();
        // 仅实现后端方法，forward未实现
        if(State.equals("add")){
            DepartmentPosition position = new DepartmentPosition();
            position.setDepartmentName(request.getParameter("departmentname"));
            int newRank = Integer.parseInt(request.getParameter("ranking"));
            positionService.checkRankingConflict(newRank);
            position.setRanking(newRank);
            position.setPositionIntroduction(request.getParameter("introduction"));
            position.setPositionName(request.getParameter("positionname"));
            positionService.insertPosition(position);

        }else if(State.equals("update")){
            String id = request.getParameter("updateid");
            DepartmentPosition position = positionService.selectPositionById(Integer.parseInt(id));
            if(position!=null){
                int originalRank = position.getRanking();
                position.setDepartmentName(request.getParameter("departmentname"));
                int newRank = Integer.parseInt(request.getParameter("ranking"));
                positionService.updateSortConflict(originalRank,newRank);
                position.setRanking(newRank);
                position.setPositionIntroduction(request.getParameter("introduction"));
                position.setPositionName(request.getParameter("positionname"));
                positionService.updatePosition(position);
            }

        }else if(State.equals("delete")){
            // 前端返回要删除的对象的id
            String id = request.getParameter("deleteid");
            int result = positionService.deletePositionById(Integer.parseInt(id));
            // 删除成功返回1，否则返回0
            request.setAttribute("result",result);
        }else{
            ArrayList<DepartmentPosition> positions = new ArrayList<DepartmentPosition>();
            positions = positionService.selectAllPosition();
            request.setAttribute("positions",positions);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
