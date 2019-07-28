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
        <script src="${ctx}/resource/js/jquery.js"></script>
	   <script src="${ctx}/resource/js/jeDate/jedate.js" ></script>
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
<%--              <c:if test="${userName ==null }"> --%>
<%--                 <span style="background: rgb(246, 204, 7);">未登录&nbsp;</span> <a href="${ctx}/login_index.do">登录</a> --%>
<%--             </c:if> --%>
            </div>
        </nav><!--/nav-->
    </header><!--/header-->


   <section id="portfolio">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title wow fadeInDown">民宿在线预定</h2>
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
            
       
            <c:forEach items="${pagers.datas}" var="room" varStatus="status">  
                <form action="book_bookRoom.do"method="post">
                <div class="portfolio-item designing">
                    <div class="portfolio-item-inner" style="width:300px;height:470px;float:left;padding-left: 20px">
                        <img class="img-responsive" src="${room.image}"  alt="" style="width:300px;height: 300px;">
                         <input type="hidden" name="roomId"  value="${room.id}"/>
                         <div>
                           <table>
                            <tr>
                                 <td colspan="2">&nbsp;&nbsp;价&nbsp;格：&nbsp;&nbsp;￥${room.room_cat.price }</td>
                               
                            </tr>
                            <tr>
                                 <td colspan="2">&nbsp;&nbsp;类&nbsp;型：&nbsp;&nbsp;${room.room_cat.roomCatName }</td>
                               
                            </tr>
                            <tr>
                                 <td colspan="2">&nbsp;&nbsp;楼&nbsp;层：&nbsp;&nbsp;${room.floor}层</td>
                               
                            </tr>
                             <tr><td>
		                     <ul class="inline" style="margin-left:-30px;margin-bottom: 0px">
		                    <span> 到达日期:</span>
		                    <input class="inline laydate-icon start" id="start${status.index}" value="${reachTime}" name="reachTime" style="width:200px; margin-right:10px; list-style: none; position:relative;"/>
	                     	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                     	<span>离开日期:</span>
	                     	<input class="inline laydate-icon end" id="end${status.index}"value="${leaveTime}" name="leaveTime" style="width:200px; list-style: none; position:relative;"/>
		                     </ul>
		                      </td>
									<td></td>
                              </tr>
                              <tr>
                               <td><input type="submit" class="submit" value="立即预定" style="margin-left: 10px;margin-top: 2px;background-color: #006fff;"></td>
                              </tr>
                           </table>
                         </div>
                    </div>
                </div>
                     </form>  
	        </c:forEach>
	 
	        
            </div>
        </div>
    </section>
     <script src="${ctx}/resource/js/laydate.js"></script> 
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
!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	for(var i = 0; i < $(".start").length; i ++){
		//alert(i)
		laydate({elem: '#start' + i });//绑定元素
		laydate({elem: '#end' + i});//绑定元素
	}
	
}();

for(var i = 0; i < $(".start").length; i ++){
	//日期范围限制
	var start = {
	    elem: '#start' + i,
	    format: 'YYYY-MM-DD',
	    min: laydate.now(), //设定最小日期为当前日期
	    max: '2099-06-16', //最大日期
	    istime: true,
	    istoday: false,
	    choose: function(datas){
	         end.min = datas; //开始日选好后，重置结束日的最小日期
	         end.start = datas //将结束日的初始值设定为开始日
	    }
	};
	
	var end = {
	    elem: '#end' + i,
	    format: 'YYYY-MM-DD',
	    min: laydate.now(),
	    max: '2099-06-16',
	    istime: true,
	    istoday: false,
	    choose: function(datas){
	        start.max = datas; //结束日选好后，充值开始日的最大日期
	    }
	};
	laydate(start);
	laydate(end);
}
//自定义日期格式
laydate({
    elem: '#test1',
    format: 'YYYY年MM月DD日',
    festival: true, //显示节日
    choose: function(datas){ //选择日期完毕的回调
        alert('得到：'+datas);
    }
});

//日期范围限定在昨天到明天
laydate({
    elem: '#hello3',
    min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
    max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
});
</script>
</body>
</html>