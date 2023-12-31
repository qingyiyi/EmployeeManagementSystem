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

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/Tdrag.min.js"></script>
	
</head>

<body>
	<!-- ie过低提示升级 -->
	<!--[if lt IE 9]>
		<style>
			.upgrade{text-align:center;line-height: 40px; position:fixed; width:100%; height:100%; background:#fff; z-index:9999;}
			.upgrade h2{margin:100px 0 50px 0;}
		</style>
		<div class="upgrade">
			<h2>天啦！你的浏览器版本好低，看不到T_T，请升级浏览器再浏览吧^_^Y！</h2>
			<h3>
				<p>360浏览器下载：<a target="_blank" href="http://se.360.cn/">http://se.360.cn/</a></p>
				<p>谷歌浏览器下载：<a target="_blank" href="https://www.google.cn/chrome/">https://www.google.cn/chrome/</a></p>
				<p>IE浏览器下载：<a target="_blank" href="https://support.microsoft.com/zh-cn/help/17621/internet-explorer-downloads">https://support.microsoft.com/zh-cn/help/17621/internet-explorer-downloads</a></p>
			</h3>
		</div>
	<![endif]-->
	<div class="bg_box" style="background: url(images/bg_default.jpg) no-repeat center center; background-size: cover;"></div>
	<div class="container">
		<div class="top_box">
	        <div class="logo">
	        	<img src="images/logo_touming.gif">
	        	<span></span>
	        	<b><img src="images/word.png" /></b>
	        </div>
	        <div class="top_icon">
	        	<a href="IndexServlet?User=${User.name}" title="主页"><img src="images/top_home.png"></a>
	        	<a href="ListServlet?User=${User.name}" title="个人设置"><img src="images/top_person.png"></a>
				<a href="LoginServlet?State=Exit&User=${User.name}" title="退出"><img src="images/top_exit.png"></a>
	        </div>
	    </div>
	    <div class="content_box">
	    	<div class="left_box">
	    		<div class="head">
	    			<i> <img src=${User.photo} /></i><!-- 注释去间隔-->
					<dl>
					<c:if test="${ empty User}">
                        <dd><b>姓名：</b><a href="login.jsp">您好，请登录</a></dd>
					</c:if>
					<c:if test="${ not empty User}">
						<dd><b>姓名：</b>${User.name}</dd>
	    				<dd><b>部门：</b>${User.department}</dd>
	    				<dd><b>职务：</b>${User.position}</dd>
	    				<dd><b>工号：</b>${User.employeeId}</dd>
					</c:if>
	    			</dl>
	    		</div>
	    		<div class="menu" id="style-3">

	    			<ul>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon01.png">
		    					<a>营销菜单</a>
		    					<em><img src="images/jt_left.png"></em>
		    				</h2>
	    					<dl>
	    						<dd><a href="ListServlet?User=${User.name}">日用资料</a></dd>
	    						<dd><a href="ListServlet?User=${User.name}">营销战况</a></dd>
	    						<dd><a href="ListServlet?User=${User.name}">渠道战况</a></dd>
	    						<dd><a href="ListServlet?User=${User.name}">碰单保护</a></dd>
	    						<dd><a href="ListServlet?User=${User.name}">拜访记录</a></dd>
	    						<dd><a href="ListServlet?User=${User.name}">客户维护</a></dd>
	    						<dd><a href="ListServlet?User=${User.name}">尾款催收</a></dd>
	    					</dl>
	    				</li>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon02.png">
		    					<a href="ListServlet?User=${User.name}">大数据库</a>
		    				</h2>
	    				</li>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon03.png">
		    					<a href="ListServlet?User=${User.name}">立项系统</a>
		    				</h2>
	    				</li>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon04.png">
		    					<a>备案查询</a>
		    					<em><img src="images/jt_left.png"></em>
		    				</h2>
	    					<dl>
	    						<dd><a href="ListServlet?User=${User.name}">备案查询</a></dd>
	    						<dd><a href="ListServlet?User=${User.name}">备案查询</a></dd>
	    					</dl>
	    				</li>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon05.png">
		    					<a>企业相关</a>
		    					<em><img src="images/jt_left.png"></em>
		    				</h2>
	    					<dl>
	    						<dd><a href="ListServlet?User=${User.name}">企业相关</a></dd>
	    						<dd><a href="ListServlet?User=${User.name}">企业相关</a></dd>
	    					</dl>
	    				</li>
	    			</ul>

	    			<script type="text/javascript">
	    				$(function(){
	    					var n=0;
	    					$(".left_box .menu ul li").mouseover(
	    						function(){
	    							n=$(this).index();
	    						}
	    					)
	    					$(".left_box .menu ul li h2").click(
	    						function(){
	    							$(".left_box .menu ul li").eq(n).find("dl").slideToggle();	
	    							$(".left_box .menu ul li").eq(n).siblings().find("dl").slideUp() 

	    							if ($(this).find("em").hasClass("xz")) {
										$(this).find("em").removeClass("xz")
										$(this).find("em").addClass("xz01")
									}else{
										$(this).find("em").addClass("xz")
										$(this).find("em").removeClass("xz01")
									}
									if ($(".left_box .menu ul li").eq(n).siblings().find("em").hasClass("xz")) {	
										$(".left_box .menu ul li").eq(n).siblings().find("em").removeClass("xz")	
									} 	
	    						}
	    					)
	    				})
	    			</script>
	    		</div>
	    	</div>
	    	<div class="right_box">
	    		<div class="icon_box">
	    			<ul class="boxList">
	    				<li class="list">
	    					<i>
	    						<img src="images/icon_01.png">
	    						<b></b>
	    					</i>
		    				<a href="index.html" target="blank">
		    					<span>通讯录</span>
		    				</a>
		    			</li>
		    			<li class="list">
	    					<i>
	    						<img src="images/icon_02.png">
	    						<b></b>
	    					</i>
		    				<a href="index.html" target="blank">
		    					<span>尾款催收</span>
		    				</a>
		    			</li>
		    			<li class="list">
	    					<i>
	    						<img src="images/icon_03.png">
	    						<b></b>
	    					</i>
		    				<a href="index.html" target="blank">
		    					<span>拜访记录</span>
		    				</a>
		    			</li>
		    			<li class="list">
	    					<i>
	    						<img src="images/icon_04.png">
	    						<b></b>
	    					</i>
		    				<a href="index.html" target="blank">
		    					<span>企业邮箱</span>
		    				</a>
		    			</li>
		    			<li class="list">
	    					<i>
	    						<img src="images/icon_05.png">
	    						<b></b>
	    					</i>
	    					<a href="index.html" target="blank">
		    					<span>通知公告</span>
		    				</a>
		    			</li>
		    			<li class="list">
	    					<i>
	    						<img src="images/icon_06.png">
	    						<b></b>
	    					</i>
	    					<a href="index.html" target="blank">
		    					<span>行政人事</span>
		    				</a>
		    			</li>
	    			</ul>
	    			<a href="#">
	    				<i>
    						<img src="images/icon_add.png">
    						<b></b>
    					</i>
    					<span>添加快捷方式</span>
	    			</a>
	    			<script>
						jQuery(function(){						    
						    //第九个例子的拖拽
						    $(".list").Tdrag({
						        scope:".boxList",
						        pos:true,
						        dragChange:true,
						        changeMode:"sort",
						        moveClass:"abc"
						    });
						})
					</script>
	    		</div>
	    		<!-- iconbox end -->
	    		<div class="info_box">
	    			<div class="box battle">
	    				<div class="tit">
	    					<a class="on">营销战况</a><a>渠道战况</a><!-- 注释去间隔注释去间隔 -->
							<div class="scrollnews">
	    	   					<span>WangID提醒您：</span>
	    	   					<ul>
	    	   						<li title="最新战报，章泽天 关晓彤 签名榜一个！2018-08-10 15:41:58">
	    	   							最新战报，<b>章泽天 关晓彤</b> 签名榜一个！<i>2018-08-10 15:41:58</i>
	    	   						</li>
	    	   						<li title="最新战报，章泽天 签名榜一个！2018-08-10 15:41:58">
	    	   							最新战报，<b>章泽天</b> 签名榜一个！<i>2018-08-10 15:41:58</i>
	    	   						</li>
	    	   						<li title="最新战报，秋名山 签名榜一个！2018-08-10 15:41:58">
	    	   							最新战报，<b>秋名山</b> 签名榜一个！<i>2018-08-10 15:41:58</i>
	    	   						</li>
	    	   					</ul>
	    	   					<script type="text/javascript">
	    	   						$(document).ready(function(){
					                    //滚动文字
					                    function runtxt(){
					                        $(".scrollnews ul").animate({marginTop:"-54px"},300,
					                            function(){
					                                $(".scrollnews ul li:last").after($(".scrollnews ul li:first"))
					                                $(".scrollnews ul").css("margin-top",0)
					                            }
					                        )
					                    }   
					                    $(".scrollnews ul li a").mouseenter(
					                        function(){
					                            clearInterval(timer)
					                        }
					                    )
					                    $(".scrollnews ul li a").mouseleave(
					                        function(){
					                            timer=setInterval(runtxt,4000)
					                        }
					                    )
					                    timer=setInterval(runtxt,4000)
					                })
	    	   					</script>
	    	   				</div>
	    				</div>
	    				<div class="conbox">
	    					<div class="con">
	    						<h1>营销部各大区本月新增业绩PK实时展示图</h1>
	    						<div class="countbox">
	    							<div class="count">
	    								<span class="x"><img src="images/X.png"> x/营销分区</span>
	    								<span class="y"><img src="images/Y.png"> y/营销业绩</span>
	    								<ul>
	    									<li class="y1" style="height: calc(2% * 2); background: #ff4e00;"></li>
	    									<li class="y2" style="height: calc(3% * 2); background: #ffa200;"></li>
	    									<li class="y3" style="height: calc(7% * 2); background: #fffc00;"></li>
	    									<li class="y6" style="height: calc(5% * 2); background: #00ff55;"></li>
	    									<li class="y8" style="height: calc(3% * 2); background: #00ffd5;"></li>
	    									<li class="y10" style="height: calc(8% * 2); background: #00c0ff;"></li>
	    									<li class="y11" style="height: calc(4% * 2); background: #0078ff;"></li>
	    									<li class="y12" style="height: calc(6% * 2); background: #4200ff;"></li>
	    									<li class="y13" style="height: calc(14% * 2); background: #fc00ff;"></li>
	    									<li class="y16" style="height: calc(8% * 2); background: #ff007e;"></li>
	    									<li class="y18 on" style="height: calc(40% * 2); background: #ff0000;">
	    								 		<img src="images/flag.png" />
	    								 	</li>
	    								 <!-- 计算出每个大区所占百分比 以两倍高度展示，所占比超过百分之五十的，超出百分百以外的隐藏 -->
	    								</ul>
	    							</div>
	    							<div class="num">
	    								<a>1区</a>
	    								<a>2区</a>
	    								<a>3区</a>
	    								<a>6区</a>
	    								<a>8区</a>
	    								<a>10区</a>
	    								<a>11区</a>
	    								<a>12区</a>
	    								<a>13区</a>
	    								<a>16区</a>
	    								<a>18区</a>
	    							</div>
	    						</div>
	    					</div>
	    					<div class="con">
	    						<h1>渠道部各部门本月新增业绩PK实时展示图</h1>
	    						<div class="countbox">
	    							<div class="count">
	    								<span class="x"><img src="images/X.png"> x/渠道部门</span>
	    								<span class="y"><img src="images/Y.png"> y/渠道业绩</span>
	    								<ul>
	    									<li class="y1" style="height: calc(40% * 2); background: #ff4e00;"></li>
	    									<li class="y2 on" style="height: calc(60% * 2); background: #ffa200;">
	    								 		<img src="images/flag.png" />
	    								 	</li>
	    								 <!-- 计算出每个大区所占百分比 以两倍高度展示，所占比超过百分之五十的，超出百分百以外的隐藏 -->
	    								</ul>
	    							</div>
	    							<div class="num">
	    								<a>6部</a>
	    								<a>8部</a>
	    							</div>
	    						</div>
	    					</div>
	    				</div>
    					<script type="text/javascript">
    						$(function(){
    							var n=0;
    							$(".right_box .info_box .battle .tit a").mouseover(
    								function(){
    									n=$(this).index();
    									$(this).addClass("on")
    									$(this).siblings().removeClass("on")
    									$(".right_box .info_box .battle .con").hide().eq(n).fadeIn()
    								}
    							)
    						})
    					</script>
	    			</div>
	    			<div class="box honor">
	    				<div class="tit">
	    					<a class="on">营销业绩排行榜</a><a>渠道业绩排行榜</a><!-- 注释去间隔
	    				 --><div></div>
	    				</div>
	    				<div class="conbox">
	    					<div class="con">
	    						<div>
		    						<ul>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>章泽天</dt>
		    									<dd>所属分区：营销1区</dd>
		    								</dl>
		    								<b><img src="images/honor_1.png"></b>
		    							</li>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>鹿晗</dt>
		    									<dd>所属分区：营销11区</dd>
		    								</dl>
		    								<b><img src="images/honor_2.png"></b>
		    							</li>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>关晓彤</dt>
		    									<dd>所属分区：营销3区</dd>
		    								</dl>
		    								<b><img src="images/honor_3.png"></b>
		    							</li>
		    						</ul>
		    						<dl>
		    							<dt>上月前三名</dt>
		    							<dd>鹿晗</dd>
		    							<dd>关晓彤</dd>
		    							<dd>张娜拉</dd>
		    						</dl>
		    					</div>
		    					<p>干的不错，小伙伴们继续加油哦！ 更多模板：<a href="http://www.cssmoban.com/" target="_blank">模板之家</a></p>
	    					</div>
	    					<div class="con">
	    						<div>
		    						<ul>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>章泽天</dt>
		    									<dd>所属分区：渠道6部</dd>
		    								</dl>
		    								<b><img src="images/honor_1.png"></b>
		    							</li>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>鹿晗</dt>
		    									<dd>所属分区：渠道8部</dd>
		    								</dl>
		    								<b><img src="images/honor_2.png"></b>
		    							</li>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>关晓彤</dt>
		    									<dd>所属分区：渠道8部</dd>
		    								</dl>
		    								<b><img src="images/honor_3.png"></b>
		    							</li>
		    						</ul>
		    						<dl>
		    							<dt>上月前三名</dt>
		    							<dd>鹿晗</dd>
		    							<dd>关晓彤</dd>
		    							<dd>张娜拉</dd>
		    						</dl>
		    					</div>
		    					<p>渠道部的同学们很给力，加油！</p>
	    					</div>
	    				</div>
	    				<script type="text/javascript">
    						$(function(){
    							var n=0;
    							$(".right_box .info_box .honor .tit a").mouseover(
    								function(){
    									n=$(this).index();
    									$(this).addClass("on")
    									$(this).siblings().removeClass("on")
    									$(".right_box .info_box .honor .con").hide().eq(n).fadeIn()
    								}
    							)
    						})
    					</script>
	    			</div>
	    		</div>
	    	</div>
	    </div>
    </div>

<style>
.copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>
<div class="copyrights">
  Collect from <a href="http://www.cssmoban.com/"  title="网站模板">模板之家</a>
  <a href="https://www.chazidian.com/"  title="查字典">查字典</a>
</div>
</body>

</html>

