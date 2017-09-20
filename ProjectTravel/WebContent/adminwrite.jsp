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
	   function check()
	   {
		   if(myform.title.value.trim() =="")
		   {
			   alert("제목을 입력해 주세요");
			   return;
		   }
		   
		   if(myform.content.value.trim() =="")
		   {
			   alert("글 내용을 입력해 주세요");
			   return;
		   }
		   
		   myform.submit();   //폼을 전송을 함
	   }
	
	   function fileupload()
	   {
		   var pic      = document.getElementById("pic");  //파일 선택 태그 찾기
		   var filename = document.getElementById("filename"); //스팬 태그 찾기
		   
		   filename.innerHTML = pic.value; //선택한 파일 이름 스팬태그에 출력	
		   
		   var div = document.getElementById("filediv"); //파일 div
		   div.style.display="block";		   
	   }
	   
	   function filedelete()
	   {
		   var pic = document.getElementById("pic");  //파일 선택 태그 찾기
		       
		       pic.value="";  //이전에 선택한 파일 경로 지우기
		       
		       //file input 태그 초기화
		       pic.type="";
		       pic.type="file";
		       
		   var div = document.getElementById("filediv"); //파일 div
		   div.style.display="none";		   
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
	
<!-- admin -->
	<div class="adminbox">
		
	<form name="myform" method="post" enctype="multipart/form-data" action="write.bo">
		<h2 style="font-size:10px; padding-bottom:2px;">		
			<select name="type">
				<option value="1"> 관광명소 글쓰기 </option>
				<option value="2"> 역사관광 소개하기 </option>
				<option value="3"> 공원 </option>	
			</select>
			
		</h2>
	
		<ul class="login pdt20 adarea">
			<li>
				<label for="idd" class="readonly">여행지 이름을 입력하세요</label><input type="text" name="title" placeholder="여행지 이름입력" id="title" title="여행지 이름입력해 주세요">
			</li>
			<li>
				<label for="idd" class="readonly">여행지소개 입력</label>
				<textarea name="content"></textarea>
			</li>
			<li>
			  <label for="pic" class="filebox">사집업로드파일</label>
			  <input type="file" name="pic" id="pic" onChange="fileupload()">
			</li>
			<li>
				<button type="button" onClick="window.open('https://www.google.co.kr/maps/')" class="ok">구글지도찾기</button>
				<input type="text" name="map" id="map" placeholder="구글지도주소입력">
			</li>
			<li class="paddinggo">
				<button type="button" onClick="javascript:check();" class="ok">확인</button>
				<button type="button" onClick="javascript:history.back();" class="cancel">취소</button>
			</li>
		</ul>
	</form>
	
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


