<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="${ctx}/resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/resource/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/resource/css/animate.min.css" rel="stylesheet"> 
    <link href="${ctx}/resource/css/prettyPhoto.css" rel="stylesheet">
    <link href="${ctx}/resource/css/styles.css" rel="stylesheet"> 
	
        <link rel="stylesheet" type="text/css" href="${ctx}/resource/css/slider-style.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/resource/css/slider-custom.css" />
		<script type="text/javascript" src="${ctx}/resource/js/modernizr.custom.79639.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="${ctx}/resource/images/ico/favicon.ico"> 
</head>
<body id="home">
    <header id="header">
        <nav id="main-nav" class="navbar navbar-default navbar-fixed-top" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="${ctx}/resource/images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="scroll active"><a href="${ctx}/login_index.do">主页</a></li>  
<!--                         <li class="scroll"><a href="#services">服务</a></li> -->
<!--                         <li class="scroll"><a href="#about">关于我们</a></li>  -->
<!-- 						<li class="scroll"><a href="#portfolio">民宿图片</a></li> -->
<!--                         <li class="scroll"><a href="#pricing">价格</a></li> -->
<!--                         <li class="scroll"><a href="#contact-us">联系我们</a></li>  -->
                        <li class="scroll"><a href="${ctx}/login_login.do">用户登录</a></li>
                         <li class="scroll"><a href="${ctx}/login_register.do">用户注册</a></li>                    
                    </ul>
                </div>
            </div>
             <div style="width:150px;float:right;">
            <c:if test="${userName !=null }">
                <span style="background: rgb(246, 204, 7);">欢迎您：${userName}&nbsp;</span> <a href="${ctx}/login_tuichu.do">退出</a>
            </c:if>
            </div>
        </nav><!--/nav-->
    </header><!--/header-->


   <section id="portfolio">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title wow fadeInDown">商品在线购买</h2>
            </div>

            <div class="text-center" style="display:none;">
                <ul class="portfolio-filter">
                    <li><a class="active" href="#" data-filter="*">All Works</a></li>
                    <li><a href="#" data-filter=".designing">Designing</a></li>
                    <li><a href="#" data-filter=".mobile">Mobile App</a></li>
                    <li><a href="#" data-filter=".development">Development</a></li>
                </ul><!--/#portfolio-filter-->
            </div>
            <div class="portfolio-items">
            <c:forEach items="${pagers.datas}" var="item" varStatus="status">  
                <div class="portfolio-item designing">
                    <div class="portfolio-item-inner" style="width:300px;height:500px;float:left;padding-left: 20px">
                        <img class="img-responsive" src="${item.image}"  alt="" style="width:300px;height: 300px;"></a>
                         <div>
                           <table>
                            <tr>
                                 <td>&nbsp;&nbsp;价&nbsp;格：&nbsp;&nbsp;</td><td>${item.item_cat.price }</td>
                               
                            </tr>
                            <tr>
                                 <td>&nbsp;&nbsp;类&nbsp;型：&nbsp;&nbsp;</td><td>${item.item_cat.cname }</td>
                               
                            </tr>
                            <tr>
                                 <td>&nbsp;&nbsp;名&nbsp;称：&nbsp;&nbsp;</td><td>${item.itemName}</td>
                               
                            </tr>
                              <tr>
                                <td><a class="btn" href="${ctx}/book_bookItem.do?itemId=${item.id}" title="立即购买">立即购买</a>
                               </td>
                            </tr>
                           </table>
                         </div>
                    </div>
                </div>
	        </c:forEach>
            </div>
        </div>
    </section>
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/bootstrap.min.js"></script> 
    <script src="${ctx}/resource/js/mousescroll.js"></script>
    <script src="${ctx}/resource/js/smoothscroll.js"></script>
    <script src="${ctx}/resource/js/jquery.prettyPhoto.js"></script>
    <script src="${ctx}/resource/js/jquery.isotope.min.js"></script>
    <script src="${ctx}/resource/js/jquery.inview.min.js"></script>
    <script src="${ctx}/resource/js/wow.min.js"></script>
	<script type="text/javascript" src="${ctx}/resource/js/jquery.ba-cond.min.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/jquery.slitslider.js"></script>
	<script type="text/javascript" src="${ctx}/resource/js/slitslider-custom.js"></script>
    <script src="${ctx}/resource/js/custom-scripts.js"></script>
<script type="text/javascript">

$(function(){
	//加载日期插件
	$('#createTime').datetimepicker({
		timepicker:false,
		format:'Y-m-d',
		formatDate:'Y-m-d',
		lang:'ch',
	});
	//加载日期插件
	$('#noticeBeginTime').datetimepicker({
		timepicker:false,
		format:'Y-m-d',
		formatDate:'Y-m-d',
		lang:'ch',
	});
});

</script>
</body>
</html>