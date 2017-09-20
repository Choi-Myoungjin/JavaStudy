<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<title>당진나들이</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/mystyle.css" rel="stylesheet">
</head>
<body>
	
	<!-- header 페이지 -->
	<header class="header">
		<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon"></i></a>
		<h1 class="logo"><span class="txt1">당진</span><span class="txt2">나들이</span></h1>
		<a href="#" class="btn_search"><i class="fa fa-search headericon"></i></a>
		
		<!-- search 페이지 -->
		<div class="bar-search">
		<div class="inner">
			<form name="mysearch">
				<label for="search" class="readonly">검색단어 입력</label>
				<input type="text" name="search" class="search" id="search">
			</form>
		</div>
	</div>
	</header>
	
		<!-- 네비바-->
	<%@include file="sidebar.jsp" %>
	
<!--album-->
		<div class="albumbox-1">
					<a href="javascript:history.go(-1)" class="albumbox-1-icon1"><i class="fa  fa-chevron-left"></i></a>
					<a href="main.jsp"><i class="fa  fa-home active"></i></a>
					<a href="javascript:history.go(+1)" class="albumbox-1-icon2"><i class="fa fa-chevron-right"></i></a>
		</div>
		
		<div class="album">
			<div class="album-box">
				<ul>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					
				</ul>
			</div>
		</div>
	
<!-- 	<footer class="footer">
		<p>COPYRIGHT  KKKKK ALL RIGHTS RESERVED</p>
	</footer> -->
	<footer class="footer">
			<div class="finfo">
				<p>COPYRIGHT ⓒ 2017. CHOI. ALL RIGHTS RESEVED.</p>
			</div>
			<div class="footerlayout"></div>
	</footer>
	
	<!-- jquery -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#slidebar-wrapper").toggleClass("active");
		});
		$("#menu-close").click(function(e) {
			e.preventDefault();
			$("#slidebar-wrapper").toggleClass("active");
		});
		$(".btn_search").click(function() {
			$(".bar-search").toggle();
		});
		
		<!--one-stop-jquery-->
		$("#circle1-my").click(function(e) {
			e.preventDefault();
			$("#one-stop").toggleClass("active");
		});
		$("#one-stop-close").click(function(e) {
			e.preventDefault();
			$("#one-stop").toggleClass("active");
		});
		<!--one-stop-my-Jquery-->
		$("#circle2-my").click(function(e) {
			e.preventDefault();
			$("#one-stop-mybox").toggleClass("active");
		});
		$("#one-stop-close1").click(function(e) {
			e.preventDefault();
			$("#one-stop-mybox").toggleClass("active");
		});
		
	</script>
</body>
</html>


