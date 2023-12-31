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
    <title>办公管理系统</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/children.css">

    <!-- 在线图标库 地址：http://fontawesome.dashgame.com/-->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- layui css -->
    <link rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    
</head>

<body>
    <div class="wangid_conbox">
        <!-- 当前位置 -->
        <div class="zy_weizhi bord_b">
            <i class="fa fa-home fa-3x"></i>
            <a>首页</a>
            <a>我的信息</a>
            <span>修改密码</span>
        </div>
        <!-- 内容 -->    
        <div class="wenxts_ke">
            <p><i>温馨提示：</i>修改密码后请牢记新密码，避免忘记密码影响工作进程</p>
        </div>  
        <!-- 下面写内容 -->
        <div class="kehubh_tj_k">
            <form class="layui-form layui-form-pane" method="post" action="ConfigurationServlet" enctype="multipart/form-data">
                <input type="hidden" name="State" value="Update">
                <input type="hidden" name="User" value="${User.name}">
                <ul>
                    <li>
                        <div class="left">姓名:</div>
                        <div class="right">
                            <input type="text" name="UserName" required lay-verify="required" placeholder="wangid" autocomplete="off" class="layui-input" value=${User.name}>
                        </div>
                    </li>
                    <li>
                        <div class="left">员工号：</div>
                        <div class="right">
                            <p>${User.employeeId}</p>
                        </div>
                    </li>
                    <li>
                        <div class="left">部门：</div>
                        <div class="right">
                            <p>${User.department}</p>
                        </div>
                    </li>
                    <li>
                        <div class="left">职位：</div>
                        <div class="right">
                            <p>${User.position}</p>
                        </div>
                    </li>
                    <li>
                        <div class="left">
                            <p>当前头像：</p>
                        </div>
                        <div class="right">
                            <img src="${User.photo}" alt="头像" class="img" style="width: 50px; height: 50px;">
                        </div>
                    </li>
                    <li>
                        <div class="left">
                            <p>上传头像：</p>
                        </div>
                        <div class="right">
                            <div class="tu"><input type="file" name="File"></div>
                        </div>
                    </li>
                    <li>
                        <div class="left"> &nbsp;</div>
                        <div class="right">
                            <button class="button_qr" type="submit" value="提交">确认修改信息</button>
                        </div>
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <!-- layui js -->
    <script src="layui/layui.js"></script>
</body>
</html>
