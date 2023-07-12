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

<body class="layui-layout-body control_box">
	<!-- 背景 -->
	<div class="bg_box" style="background: url(images/20190415.jpg) no-repeat center center; background-size: cover;"></div>
	<!-- content box-->
	<div class="layui-layout layui-layout-admin">
		<!-- top -->
		<div class="layui-header">
			<div class="top_box">
		        <div class="logo">
		        	<img src="images/logo_touming.gif">
		        	<span></span>
		        	<b><img src="images/word.png" /></b>
		        </div>

				<div class="top_user">
					<span><img src=${User.photo} /></span>
					<dl>
						<dt><b>姓名：</b>${User.name}</dt>
						<dd><b>部门：</b>${User.department}</dd>
						<dd><b>级别：</b>员工用户
							<b>上次登录时间：</b> ${User.time}
						</dd>
					</dl>
				</div>

		        <div class="top_icon">
		        	<a href="IndexServlet?User=${User.name}" title="首页"><img src="images/top_home.png"></a>
		        	<a href="ConfigurationServlet" target="main_self_frame" title="个人设置"><img src="images/top_person.png"></a>
		        	<a href="LoginServlet?State=Exit&User=${User.name}" title="退出"><img src="images/top_exit.png"></a>
		        </div>
		    </div>
		</div> 
	    <!-- side menu -->
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree"  lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed">
						<a class="" href="javascript:;"><i class="fa fa-clipboard fa-fw"></i>日用资料</a>
						<dl class="layui-nav-child">
							<dd><a href="daily_mykh.jsp" target="main_self_frame">我的意向客户管理</a></dd>
							<dd><a href="daily_list.html" target="main_self_frame">意向客户信息列表</a></dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;"><i class="fa fa-address-book fa-fw"></i>VIP客户信息管理</a>
						<dl class="layui-nav-child">
							<dd><a href="VipCustomerServlet?User=${User.name}" target="main_self_frame">VIP客户信息录入</a></dd>
							<dd><a href="vip_list.jsp" target="main_self_frame">VIP客户信息列表</a></dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;"><i class="fa fa-shield fa-fw"></i>客户保护</a>
						<dl class="layui-nav-child">
							<dd><a href="KeHuBH_tj.jsp"  target="main_self_frame">添加保护系统</a></dd>
							<dd><a href="CustomerProtectionListServlet?User=${User.name}"  target="main_self_frame">我的保护系统列表</a></dd>
							<dd><a href="KeHuBH_list1.html"  target="main_self_frame">员工保护系统列表</a></dd>
						</dl>
					</li> 
					<li class="layui-nav-item">
						<a href="javascript:;"><i class="fa fa-address-card fa-fw"></i>回访记录</a>
						<dl class="layui-nav-child">
							<dd><a href="HuiFangJL_tj.html" target="main_self_frame">添加回访记录</a></dd>
							<dd><a href="HuiFangJL_my.html" target="main_self_frame">我的回访记录</a></dd>
						</dl>
					</li> 
					<li class="layui-nav-item">
						<a href="javascript:;"><i class="fa fa-file-text fa-fw"></i>回访列表</a>
						<dl class="layui-nav-child">
							<dd><a href="HuiFanglist.html" target="main_self_frame">员工回访列表</a></dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;"><i class="fa fa-users fa-fw"></i>员工管理</a>
						<dl class="layui-nav-child">
							<dd><a href="YuanGonglist.html" target="main_self_frame">公司员工列表</a></dd>
						</dl>
					</li> 
					<li class="layui-nav-item">
						<a href="javascript:;"><i class="fa fa-sitemap fa-fw"></i>部门管理</a>
						<dl class="layui-nav-child">
							<dd><a href="BuMenGL_list1.html" target="main_self_frame">公司部门列表</a></dd>
							<dd><a href="BuMenGL_list.html" target="main_self_frame">部门职位列表</a></dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;"><i class="fa fa-hourglass-half fa-fw"></i>工单进程</a>
						<dl class="layui-nav-child">
							<dd><a href="GongDJC.html" target="main_self_frame">工单列表</a></dd>
							<dd><a href="GongDJC_my.html" target="main_self_frame">我的工单</a></dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;"><i class="fa fa-hourglass-half fa-fw"></i>设置</a>
						<dl class="layui-nav-child">
							<dd><a href="ConfigurationServlet?User=${User.name}" target="main_self_frame">个人设置</a></dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
	  
		<div class="layui-body">
			<!-- 展开收起按钮 -->
			<div class="open_shrink open" title="展开/收起">
				<span></span>
			</div>
			<script type="text/javascript">
				$(function(){
					$(".open_shrink").click(function(){
						if ($(this).hasClass("open")) {
							$(this).removeClass("open");
							$(".layui-side").stop().animate({left:-220},300);
							$(".layui-body").stop().animate({left:0},300);
						}else{
							$(this).addClass("open");
							$(".layui-side").stop().animate({left:0},300);
							$(".layui-body").stop().animate({left:220},300);
						}
					})
				})
			</script>
			<!-- iframe -->
			<iframe src="daily_mykh.jsp" name="main_self_frame" frameborder="0" class="layadmin-iframe" scrolling="yes"></iframe>
		</div>
	  
	</div>
	<!-- layui js -->
	<script src="layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function(){
		  var element = layui.element;
		  
		});
		
	</script>

</body>

</html>

