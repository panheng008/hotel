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
                        <li class="scroll"><a href="#services">服务</a></li>
                        <li class="scroll"><a href="#about">关于我们</a></li> 
						<li class="scroll"><a href="#portfolio">民宿图片</a></li>
						<li class="scroll"><a href="#item">商品图片</a></li>
<!--                         <li class="scroll"><a href="#pricing">价格</a></li> -->
                        <li class="scroll"><a href="#contact-us">联系我们</a></li> 
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

    <section class="demo-2">
           <div id="slider" class="sl-slider-wrapper">

				<div class="sl-slider">
				
					<div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-25" data-slice2-rotation="-25" data-slice1-scale="2" data-slice2-scale="2">
						<div class="sl-slide-inner">
							<div class="bg-img bg-img-1"></div>
							 
						</div>
					</div>
					
					<div class="sl-slide" data-orientation="vertical" data-slice1-rotation="10" data-slice2-rotation="-15" data-slice1-scale="1.5" data-slice2-scale="1.5">
						<div class="sl-slide-inner">
							<div class="bg-img bg-img-2"></div>
							 
						</div>
					</div>
					
					<div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="3" data-slice2-rotation="3" data-slice1-scale="2" data-slice2-scale="1">
						<div class="sl-slide-inner">
							<div class="bg-img bg-img-3"></div>
							 
						</div>
					</div>					
				</div><!-- /sl-slider -->

				<nav id="nav-dots" class="nav-dots">
					<span class="nav-dot-current"></span>
					<span></span>
					<span></span> 
				</nav>

			</div><!-- /slider-wrapper -->

    </section><!--/#main-slider-->

 <section id="services" >
        <div class="container">

            <div class="section-header">
                <h2 class="section-title wow fadeInDown animated" style="visibility: visible; animation-name: fadeInDown;">我们的服务</h2>
                <p class="wow fadeInDown animated" style="visibility: visible; animation-name: fadeInDown;"></p>
            </div>

            <div class="row">
                <div class="features">
                    <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="0ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 0ms; animation-name: fadeInUp; height: 194px;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-futbol-o"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">餐厅 &amp; 吧台</h4>
                                <p>多元化的餐厅，让您尽享国内外美食。个性化的吧台，一定能让您的体验得到满足。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="100ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 100ms; animation-name: fadeInUp;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-compass"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">豪华客房</h4>
                                <p>这里，将一份温温软软，悄然安放于旅行的希冀之中，您定不会失望。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="200ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 200ms; animation-name: fadeInUp;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-database"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">宴会招待</h4>
                                <p>周全的礼仪，个性化的需求，一定能让您的宾客感到舒适之至。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->
                		
                		<div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 500ms; animation-name: fadeInUp;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-bullseye"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">客房服务</h4>
                                <p>您可以拨打客房内的电话或者到前台登记您想要的客房服务。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->
                		
                		
                    <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="300ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 300ms; animation-name: fadeInUp;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-bar-chart"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">无线覆盖</h4>
                                <p>全店WiFi覆盖，即使身在异地，也不会影响你的随时办公和视频通话。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="400ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 400ms; animation-name: fadeInUp;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-paper-plane-o"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">24/7 服务</h4>
                                <p>7天24小时不间断服务，始终如一，为客户着想，是我们不变的理念。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->

                    
                </div>
            </div><!--/.row-->    
        </div><!--/.container-->
    </section><!--/#services-->

  
 <section id="about">
        <div class="container">

            <div class="section-header">
                <h2 class="section-title wow fadeInDown">关于我们</h2>
                <p class="wow fadeInDown">您可以通过以下信息了解以下我们民宿的相关信息</p>
            </div>

            <div class="row">
                <div class="col-sm-6 wow fadeInLeft">
                  <img class="img-responsive" src="${ctx}/resource/images/about.jpg" alt="">
                </div>

                <div class="col-sm-6 wow fadeInRight">
                    <h3 class="column-title">我们民宿</h3>
                    <p>洲际民宿是全球首个真正意义上的国际民宿品牌，旗下的五星级民宿遍布世界60多个国家，60多年的丰富经验让我们真正深入洞悉地了解每一个目的地。从传统的高贵优雅，到大都会的摩登时尚，再到热带海滨的轻松与恬静，每一间民宿都有各自 独特的风格，为我们品味独到的旅行者们带来万种风情。</p>
 <p>我们为用户提供多种个性化的服务，大致有以下这么几条：</p>

<ul class="listarrow">
<li><i class="fa fa-angle-double-right"></i>人性化的客房服务</li>
<li><i class="fa fa-angle-double-right"></i>客房直拨设备</li>
<li><i class="fa fa-angle-double-right"></i>洗衣服务</li>
<li><i class="fa fa-angle-double-right"></i>旅游问讯咨询</li> 
<li><i class="fa fa-angle-double-right"></i>多元化餐厅和咖啡厅</li>
<li><i class="fa fa-angle-double-right"></i>代客停车服务</li>
<li><i class="fa fa-angle-double-right"></i>叫醒服务</li>
</ul> 

                </div>
            </div>
        </div>
    </section><!--/#about-->
<section id="hero-action-section" class="hero-action-section">
		<!-- .Container -->
		<div class="container ow-section">
			<h4 class="hero-action-title">为了满足所有你对浪漫的渴望</h4>
			<p><a href="${ctx}/room_roomIndex.do" class="get-started">立刻预定!!</a></p>
		</div><!-- /.Container -->
	</section>
   
  <section id="portfolio">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title wow fadeInDown">民宿图片</h2>
                <p class="wow fadeInDown">在这里，您可以欣赏到我们民宿的图片</p>
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
            <c:forEach items="${pagers.datas}" var="pic" varStatus="status">  
                <div class="portfolio-item designing">
                    <div class="portfolio-item-inner">
                    <a href="${ctx}/room_roomIndex.do?roomCatId=${pic.id}">
                        <img class="img-responsive" src="${pic.image}" alt="pic.roomCatName"></a>
                    </div>
                </div>
	        </c:forEach>
            </div>
        </div>
    </section>

    <section id="item">
    <div >
        <div class="" style="width:1100px; margin: 0 auto;">
            <div class="section-header">
                <h2 class="section-title wow fadeInDown">商品图片</h2>
                <p class="wow fadeInDown">在这里，您可以购买到我们民宿提供商品的图片</p>
            </div>

            <div class="text-center" style="display:none;">
                <ul class="portfolio-filter">
                    <li><a class="active" href="#" data-filter="*">All Works</a></li>
                    <li><a href="#" data-filter=".designing">Designing</a></li>
                    <li><a href="#" data-filter=".mobile">Mobile App</a></li>
                    <li><a href="#" data-filter=".development">Development</a></li>
                </ul>
            </div>
            <div class="portfolio-items" >
            <c:forEach items="${pager.datas}" var="pic" varStatus="status">  
                <div class="portfolio-item designing">
                    <div class="portfolio-item-inner">
                    	<a href="${ctx}/item_itemIndex.do?itemCatId=${pic.cid}">
                        <img class="img-responsive" src="${pic.image}" alt="pic.cname" style="width:260px;height: 250px;padding: 10px;"></a>
                    </div>
                </div>
	        </c:forEach>
	        </div>
	        </div>
	        </div>
    </section>
   
    <section id="business-stats">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title wow fadeInDown">民宿配置</h2>
            </div>

            <div class="row text-center">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
                        <div class="business-stats" data-digit="1000" data-duration="1000"></div>
                        <strong>可入住客人总数</strong>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="wow fadeInUp" data-wow-duration="400ms" data-wow-delay="100ms">
                        <div class="business-stats" data-digit="400" data-duration="1000"></div>
                        <strong>房间数</strong>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="wow fadeInUp" data-wow-duration="400ms" data-wow-delay="200ms">
                        <div class="business-stats" data-digit="1000" data-duration="1000"></div>
                        <strong>曾举办过婚礼</strong>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="wow fadeInUp" data-wow-duration="400ms" data-wow-delay="300ms">
                        <div class="business-stats" data-digit="3000" data-duration="1000"></div>
                        <strong>曾举办过宴会</strong>
                    </div>
                </div>
            </div>
        </div>
    </section><!--/#business-stats-->

  
  <section id="contact-us">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title wow fadeInDown">联系我们</h2>
                <p class="wow fadeInDown">您可以通过以下方式联系我们，您的任何问题都能解决.</p>
            </div>
        </div>
  
        <div class="container">
            <div class="container contact-info">
                <div class="row">
				  <div class="col-sm-4 col-md-4">
                        <div class="contact-form">
                            <h3>联系方式</h3>

                            <address>
                              <strong>Amazing Hotel, Inc.</strong><br>
                              上海市浦东新区康桥路1605号<br>
                              国际旅游度假区罗山路民宿<br>
                              <abbr title="Phone">TEL:</abbr>  021-33758898<br>
                              <abbr title="Fax">Fax:</abbr>  021-68082638
                            </address>
					</div></div>
                    <div class="col-sm-8 col-md-8">
                        <div class="contact-form">
                       
                            <form id="main-contact-form" name="contact-form" method="post" action="user_fankui.do">
<!--                                 <div class="form-group"> -->
<!--                                     <input type="text" name="name" class="form-control" placeholder="用户名" required> -->
<!--                                 </div> -->
<!--                                 <div class="form-group"> -->
<!--                                     <input type="email" name="email" class="form-control" placeholder="邮件地址" required> -->
<!--                                 </div> -->
<!--                                 <div class="form-group"> -->
<!--                                     <input type="text" name="subject" class="form-control" placeholder="主题" required> -->
<!--                                 </div> -->
                                <div class="form-group">
                                    <textarea name="aaa" class="form-control" rows="8" placeholder="反馈内容" required></textarea>
                                </div>
                                <button type="submit" class="btn btn-primary">反馈建议</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
   </section><!--/#bottom-->

    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">Copyright &copy; 2016.Amazing Hotel All rights reserved.</div>
            </div>
        </div>
    </footer><!--/#footer-->

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

</body>
</html>