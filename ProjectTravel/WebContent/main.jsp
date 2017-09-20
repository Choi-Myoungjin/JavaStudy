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
	
	<!-- One- Stop-->
	<nav id="one-stop">
		<a href="#" id="one-stop-close" class="one-stop-btn-close"><i class="fa fa-close"></i></a>
		<div class="one-stop-box1">
			<div class="stopbox1">
				<p>나만의 맞춤여행</p>
			</div>
			
		<div class="one-stop-line1">
			<p>언제?</p>
				<form class="one-bar-search">
						<SELECT NAME=one-bar-search-sl SIZE=1 class="o-b-s-s">
							<OPTION VALUE=1 >1월</OPTION>
							<OPTION VALUE=2>2월</OPTION>
							<OPTION VALUE=3>3월</OPTION>
							<OPTION VALUE=4>4월</OPTION>
							<OPTION VALUE=5>5월</OPTION>
							<OPTION VALUE=6>6월</OPTION>
							<OPTION VALUE=7>7월</OPTION>
							<OPTION VALUE=8>8월</OPTION>
							<OPTION VALUE=9>9월</OPTION>
							<OPTION VALUE=10>10월</OPTION>
							<OPTION VALUE=11>11월</OPTION>
							<OPTION VALUE=12>12월</OPTION>
							<OPTION VALUE=13 SELECTED>전&nbsp;&nbsp;체</OPTION>
						</SELECT>
				</form>
		</div>
		
		<div class="one-stop-line2">
			<p>누구와?</p>
				<div class="one-bar-search2">
						<form name="one-mysearch2">
							<SELECT NAME=one-bar-search-sl SIZE=1 class="o-b-s-s1">
								<OPTION VALUE=1>나홀로</OPTION>
								<OPTION VALUE=2>가족</OPTION>
								<OPTION VALUE=3>모임</OPTION>
								<OPTION VALUE=4 SELECTED>연인</OPTION>
							</SELECT>						
						</form>
					</div>
		</div>
		
		<div class="one-stop-line3">
			<div class="one-stop-line-box1"><p>어디로?</p>
			</div>	
			<div class="one-stop-line3-box">
				<ul class="one-stop-nav">
					<li><a href="#"><i class="fa fa-th"></i>전체</a></li>
					<li><a href="#"><i class="fa fa-area-chart"></i>당진9경</a></li>
					<li><a href="#"><i class="fa fa-image"></i>관광명소</a></li>
					<li><a href="#"><i class="fa fa-fort-awesome"></i>역사관광</a></li>
				</ul>
			</div>
			<div class="one-stop-line3-box1">
				<ul class="one-stop-nav1">
					<li><a href="#"><i class="fa fa-modx"></i>문화예술</a></li>
					<li><a href="#"><i class="fa fa-pagelines"></i>축제</a></li>
					<li><a href="#"><i class="fa fa-tree"></i>공원</a></li>
					<li><a href="#"><i class="fa fa-pied-piper-alt"></i>체험관광</a></li>
				</ul>
			</div>
			<div class="one-stop-line3-box2">
				<div  class="osbox1"><a href="location.html">검색하기</a>
				</div>
			</div>
		</div>
	</div>
</nav>
	
	
	<!--one stop my-->
	<nav id="one-stop-mybox">
		<a href="#" id="one-stop-close1" class="one-stop-btn-close"><i class="fa fa-close"></i></a>
		<div class="mybox-box">	
			<div class="mybox-box1">
			</div>
			<div class="mybox-box2">
			<span class="mybox-text1">미리 떠나는</span> <span class="mybox-text2">나만의 여행</span><span><br><br>시작해 볼까요?</span>
			</div>
			<div class="mybox-box3">
				<div  class="mybox--1"><a href="location.jsp">시작하기</a>
				</div>
			</div>
		</div>
	</nav>
	
	<!--main_visual-->
	<section class="main_visual">
		<header>
			<h2 class="readonly">광고 메인비쥬얼</h2>
		</header>	
		<!-- ** 슬라이딩이미지-->
		<div class="inner">
			<div class="backgroundchange">
				<div class="backgroundimg" id="back1"></div>
				<div class="backgroundimg" id="back2"></div>
				<div class="backgroundimg" id="back3"></div>
				<div class="backgroundimg" id="back4"></div>
				<div class="backgroundimg" id="back5"></div>
			</div>
		</div>
		
	</section>
	<section class="tab_bar">
		<div class="tab_cont">
			<header>
				<h2 class="readonly">탭메뉴</h2>
			</header>
		
			<ul>
				<li class="act1">
					<a href="#" class="txxt1">원스탑</a>
					<a href="#"  class="circle1" id="circle1-my"><div class="cl1">맞춤<br/>여행</div></a>
				</li>
				<li class="act2">
					<a href="#" class="txxt2">미리 떠나는</a>
					<a href="#"  class="circle2"  id="circle2-my"><div class="cl2">나만의<br/>여행</div></a>
				</li>
				<li class="active"><a href="trip.html">전       체</a></li>
				<li><a href="trip1.bo">관광명소</a></li>
				<li><a href="trip2.bo">역사관광</a></li>
				<li><a href="trip3.bo">공       원</a></li>
			</ul>
		</div>
		
<div class="tab1_cont">
			<ul>
				<li>
					<a href="trip1.bo">
					<img src="images/con1.png" alt="명소" class="imgw100">
					</a>
				</li>
				<li>
					<a href="trip1.bo">
					<img src="images/con2.png" alt="명소" class="imgw100">
					</a>
				</li>
				<li>
					<a href="trip1.bo">
					<img src="images/con3.png" alt="명소" class="imgw100">
					</a>
				</li>
				<li>
					<a href="trip1.bo">
					<img src="images/con4.png" alt="명소" class="imgw100">
					</a>
				</li>
				<li>
					<a href="trip1.bo">
					<img src="images/con5.png" alt="명소" class="imgw100">
					</a>
				</li>
				<li>
					<a href="trip1.bo">
					<img src="images/con6.png" alt="명소" class="imgw100">
					</a>
				</li>
				<li>
					<a href="trip1.bo">
					<img src="images/con4.png" alt="명소" class="imgw100">
					</a>
				</li>
				<li>
					<a href="trip1.bo">
					<img src="images/con5.png" alt="명소" class="imgw100">
					</a>
				</li>
				<li>
					<a href="trip1.bo">
					<img src="images/con5.png" alt="명소" class="imgw100">
					</a>
				</li>				
			</ul>
		</div>
	</section>
	
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


