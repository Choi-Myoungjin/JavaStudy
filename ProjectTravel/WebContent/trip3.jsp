<%@page import="dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
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

<!--관광정보 게시글페이지 -->
		<div class="nbsppage">
			<div class="tab_cont">
					<header>
						<h2 class="readonly">탭메뉴</h2>
					</header>
				
					<ul>
						<li class="act1 hiddenc" >
							<a href="#" class="txxt1">원스탑</a>
							<a href="#"  class="circle1" id="circle1-my"><div class="cl1">맞춤<br/>여행</div></a>
						</li>
						<li class="act2 hiddenc">
							<a href="#" class="txxt2">미리 떠나는</a>
							<a href="#"  class="circle2"  id="circle2-my"><div class="cl2">나만의<br/>여행</div></a>
						</li>
						<li class="active"><a href="main.jsp">M&nbsp;&nbsp;A&nbsp;&nbsp;I&nbsp;&nbsp;N</a></li>
						<li><a href="trip1.bo">관광명소</a></li>
						<li><a href="trip2.bo">역사관광</a></li>
						<li><a href="trip3.bo">공       원</a></li>
					</ul>
			</div>
		</div>
		
		<div class="trip-1">
		<div>
			
			<ul>
			<%
				ArrayList list =(ArrayList) request.getAttribute("ArrayList");
				
				for(int i = 0 ; i < list.size(); i++){
					
					BoardDTO dto = (BoardDTO)list.get(i);
					
			%>
				<a href="tripread3.bo?num=<%=dto.getNum()%>"><li>
				<img src="images/<%=dto.getPhoto() %>" alt="명소" class="imgw100"><br>
				<span><%=dto.getName() %></span>
				</li></a>
			<%} %>
			</ul>
		</div>
	</div>
		
<!-- 	<footer class="footer">
		<p>COPYRIGHT  KKKKK ALL RIGHTS RESERVED</p>
	</footer> -->
	<footer class="footer">
			<div class="finfo">
					<div class="footer_menu">
						<ul>
							 <li><a href="#">개인정보처리방침</a></li>
							 <li><a href="#">저작권보호정책</a></li>
							 <li><a href="#">국가상징알아보기</a></li>
							 <li><a href="#">행정전화번호부</a></li>
							 <li><a href="#">오시는길</a></li>	
						</ul>
					</div>
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


