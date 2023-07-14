<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit"/>
    <meta name="force-rendering" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="名榜,wangid">
    <title>WangID办公管理系统</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/children.css">

    <!-- 在线图标库 地址：http://fontawesome.dashgame.com/-->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- layui css -->
    <link rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <script  language="javascript">
        function validateForm() {
            var  password= document.forms["myfrom"]["password"].value;
            var  username= document.forms["myfrom"]["username"].value;
            var  name= document.forms["myfrom"]["name"].value;
            var  sex= document.forms["myfrom"]["sex"].value;
            var  employeeid= document.forms["myfrom"]["employeeid"].value;
            var  department= document.forms["myfrom"]["department"].value;
            var  position= document.forms["myfrom"]["position"].value;
            var  ranking= document.forms["myfrom"]["ranking"].value;
            // var  resume= document.forms["myfrom"]["resume"].value;
            var  level= document.forms["myfrom"]["level"].value;


            if (password == "") {
                alert("密码未填写");
                return false;
            }else if(username == ""){
                alert("用户名未填写");
                return false;
            } else if(name == ""){
                alert("姓名未填写");
                return false;
            }else if(sex == ""){
                alert("性别未填写");
                return false;
            }else if(employeeid == ""){
                alert("工号未填写");
                return false;
            }else if(department == "空"){
                alert("部门未选择");
                return false;
            }else if(position == ""){
                alert("部门职位未填写");
                return false;
            }else if(ranking == ""){
                alert("排序未填写");
                return false;
            }else if(level == ""){
                alert("身份未选择");
                return false;
            }else{
                return true;
            }
        }
        function postsubmit(){
            if(validateForm()){
                document.forms["myfrom"].post();
            }
        }
    </script>
</head>

<body>
    <div class="wangid_conbox">
        <!-- 当前位置 -->
        <div class="zy_weizhi bord_b">
            <i class="fa fa-home fa-3x"></i>
            <a>首页</a>
            <a>员工管理</a>
            <span>公司员工添加</span>
        </div>
        <!-- 内容 -->    
        <div class="wenxts_ke">
            <p><i>温馨提示：</i>请认真核对员工信息正确无误后再确定添加，并上传员工的对应简历图片</p>
        </div>
        <div class="kehubh_tj_k">
            <form class="layui-form layui-form-pane" action="EmployeeServlet" method="doGet" name="myfrom">
            <ul> 
                <li>
                    <div class="left">用户名：</div>
                    <div class="right"> 
                        <input type="text" name="username" required lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                    </div>
                </li>
                <li>
                    <div class="left">密码：</div>
                    <div class="right"> 
                        <input type="text" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </li>
                <li>
                    <div class="left">姓名：</div>
                    
                    <div class="right"> 
                        <input type="text" name="name" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                    </div>
                </li>
                <li>
                    <div class="left">性别：</div>
                    <div class="right">
                        男<input type="radio" value="男" checked="checked" name="sex"> <!--checked设置默认选中-->
                        女<input type="radio" value="女" name="sex">
                    </div>
                </li>
                <li>
                    <div class="left">工号：</div>
                    <div class="right"> 
                        <input type="text" name="employeeid" required lay-verify="required" placeholder="请输入工号" autocomplete="off" class="layui-input">
                    </div>
                </li>
                <li style="height: 38px; overflow:initial;">
                    <div class="left">部门：</div>
                    <div class="right"> 
                        <select name="department" lay-verify="">
                            <option value="空">请选择部门</option>
                            <option value="技术部">技术部</option>
                            <option value="人事部">人事部</option>
                            <option value="客服部">客服部</option>
                            <option value="营销部">营销部</option>
                        </select> 
                    </div>
                </li>
                <li>
                    <div class="left">部门职位：</div>
                    <div class="right">
                            <input type="text" name="position" required lay-verify="required" placeholder="请填写部门职位" autocomplete="off" class="layui-input">
                    </div>
                </li>
                <li>
                    <div class="left">排序：</div>
                    <div class="right">
                            <input type="text" name="ranking" required lay-verify="required" placeholder="请填写部门职位" autocomplete="off" class="layui-input">
                    </div>
                </li>
                <li>
                    <div class="left">头像：</div>
                    <div class="right">
                            <input style="margin-top: 8px;" type="file">
                    </div>
                </li>
                <li>
                    <div class="left"> 添加身份：</div>
                    <div class="right">
                        员工<input type="radio" value="员工" checked="checked" name="level"> <!--checked设置默认选中-->
                        经理<input type="radio" value="经理" name="level">
                    </div>
                </li>
                <li>
                    <div class="left"> &nbsp;</div>
                    <div class="right"> 
                        <button class="button_qr" onclick="postsubmit()" name="State" value="insert">确定添加</button>
                    </div>
                </li>
            </ul> 
            </form>
        </div>
    </div>   
    <style>
     
 .layui-form-pane .layui-form-checkbox {
    margin: 12px 0 4px 10px!important;
}
    </style>
	<!-- houl --> 
	<!-- 结束 -->
    <!-- layui js -->
    <script src="layui/layui.js"></script>
    
</body>

</html>
<script>
        layui.use(['form', 'layedit', 'laydate'], function(){
          var form = layui.form
          ,layer = layui.layer
          ,layedit = layui.layedit
          ,laydate = layui.laydate;
        });

</script>
