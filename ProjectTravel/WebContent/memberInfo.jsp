<%@page import="java.util.function.Function"%>
<%@page import="dto.MemDTOIn"%>
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

<script>

	function move(){
		
		window.location.href="main.jsp";
		
	}
	
   function fileupload(){
	   
	   var pic      = document.getElementById("pic");  //파일 선택 태그 찾기
	   var filename = document.getElementById("filename"); //스팬 태그 찾기
	   
	
	   		   
   }
   
   //전화번호 숫자만입력받기
	function onlyNumber(event){
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ){ 
			return;
   
   		}else {
			return false;
		}
	}
	function removeChar(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ){ 
			return;
		}else{
			event.target.value = event.target.value.replace(/[^0-9]/g, "");
		}
	}
	
	//입력확인체크
   function Check() {

		var phone = $("#phone").val();
		var name = $("#name").val();
		var info = $("#info").val();
		var photo= $("#pic").val();

		var ext = photo.slice(photo.lastIndexOf(".") + 1).toLowerCase();
		
		if(phone !="" && phone.length == 11 && name !="" && info !=""){

			if(ext == "gif" || ext == "jpg" || ext == "png") {
				
				alert("수정완료");
				update();
				return true;		
			}else{
	
				alert("이미지파일 (.jpg, .png, .gif ) 만 업로드 가능합니다.");
				return false;
			}
			
		}else{
			alert("수정실패");
			return false;
		}
   }
   
   function update(){
	   
	   memform.submit();   
   }
	
</script>
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
	
<!-- MemberInfo -->


	<form name="memform" method="post" enctype="multipart/form-data" action="memInfoUp.mem">
		<div>
			<ul>
				<li>
				<%if(dtoa.getPhoto() == null){ %>
					<img src="images/me.jpg" alt="사진" class="imgw200">
				<%}else{ %>
					<img src="images/<%=dtoa.getPhoto() %>" alt="사진" class="imgw200">
					<input type="hidden" name="photoONE" id="photoONE" value="<%=dtoa.getPhoto() %>">
				<%} %>
					<label for="pic" class="filebox">사집업로드파일</label>
					<input type="file" name="pic" id="pic" onChange="fileupload()">					
				</li>
				<li>아이디 : <%=UserID %></li>
				<li>닉네임 : <input type="text" name="name" id="name" value="<%=dtoa.getName() %>"> </li>
				<li>자기소개 :<textarea name="info"><%=dtoa.getInfo() %></textarea></li>
				<li>전화번호 : 
					<input type="text" name="phone" id="phone" value="<%=dtoa.getPhone() %>" onkeydown="return onlyNumber(event)">
				</li>
				<li>가입일 : <%=dtoa.getReg_date().substring(2,11) %></li>
			</ul>
			
			<button type="button" class="ck" onClick="javascript:Check()">수정</button>
			<button type="button" onClick="move()" class="ck">MAIN</button>
			
		</div>
	</form>
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


