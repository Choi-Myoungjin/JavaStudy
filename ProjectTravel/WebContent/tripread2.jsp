<%@page import="dto.CommentDTO"%>
<%@page import="dto.PageOut"%>
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
<script>

	function del(num, photo){
		
		location.href = "del2.bo?num="+num + "&photo=" + photo;
		
	}
	
	function update(){
		
		formAdminco.submit();
		
	}
	
	function cmt1write(){
		
		comment1.submit();
	}
	
	function delok(id, num){
		
		location.href = "del2.comment?id="+id + "&num=" + num;
	}
	
	//더보기페이징처리
	<%
		int listMore = 5;
		
		int count = (int)request.getAttribute("count");
	%>
	window.onload=paging
	function paging(){
		<%
		
			 for (int i = 1; i <= count; i++){
				 
			      if (i <= listMore){
		%>
	
	document.getElementById("dispRow<%=i%>").style.display = '';

		<%
			      }
			 }
			 if (count > listMore){
		%>
		
	document.getElementById("dispMore").style.display = ''; 
		
		<%
			 }
		%>
	}
	
	function listMore(count){
	  
		event.preventDefault();
		for (i = 1 + 1; i <= count; i++){
			
			document.getElementById("dispRow"+i).style.display = ''; 
	    }
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


	<%
	
		BoardDTO dto = (BoardDTO) request.getAttribute("Boardread");
		
						
	%>
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
		
		<div class="tripread">
			<div>
				<div>
					<img src="images/<%=dto.getPhoto() %>" alt="명소" class="imgw200">
				</div>
				<div class="reader">
					<ul>
						<li><p>등록 : <%=dto.getReg_date().substring(0,11) %></p></li>
						
						<li><p><%=dto.getName() %></p></li>
						<br>
						<li><p><%=dto.getContent() %></p></li>
					</ul>
				</div>
			</div>
			<div id="map">
				<%=dto.getMap() %>
				<%if(UserID != null && UserLv == 1) { %>
				<form name="formAdminco" method="post"  class="loginform" action="adminco.jsp">
					<input type="hidden" name="num11" value="<%=dto.getNum()%>">
					<input type="hidden" name="name11" value="<%=dto.getName()%>">
					<input type="hidden" name="content11" value="<%=dto.getContent() %>">
					<input type="hidden" name="photo11" value="<%=dto.getPhoto()%>">
				</form>
				<button type="button" class="ck" onClick="update();">글수정</button>
				<button type="button" onClick="del('<%=dto.getNum() %>','<%=dto.getPhoto() %>');" class="ck">삭제</button>
				<%} %>
				<hr>
			</div>
			
		</div>
			
			
			
		<div>
			<hr>
			<table style="max-width:1900px;">
				
					<tr>
						<th class="m-none" scope="col">No.</th>
						<th class="m-none" scope="col">닉네임</th>
						<th scope="col" style="text-align:left;">&nbsp;&nbsp;내용</th>
						<th scope="col" >등록</th>
						<th scope="col">삭제</th>
					</tr>
				
				
				<%
					ArrayList list =(ArrayList) request.getAttribute("ArrayList");
					
					for(int i = 0 ; i < list.size(); i++){
						
						CommentDTO dto1 = (CommentDTO)list.get(i);

				%>
				
		
					<tr id="dispRow<%=i+1%>" style="display:none;">
						<td class="m-none tdclassNo"><%=i+1 %></td>
						<th id="id22" scope="row" class="tdclassId"><%=dto1.getId() %></th>
						<td class="tdclassCont"><%=dto1.getContent() %></td>
						<td class="tdclassDate"><%=dto1.getReg_date().substring(2,11) %></td>
						
						<td class="tdclassDel">
					<%if(UserID != null && UserLv == 1) { %>
						<button onclick = "delok('<%=dto1.getId() %>', '<%=dto.getNum() %>')">삭제</button></td>
					<%} %>
					</tr>
					<%} %>
					
				
			</table>
			<div id="dispMore" style="display:none"><a href="#" onclick="listMore('<%=count%>')"><p>전체댓글보기</p></a></div>
			
			
				
			<form name="comment1" method="post"  class="comment1" action="comment2write.comment">
				<div class="com1">
					<div>
						<ul>
							<li class="in1"><label for="nid"></label><input type="text" name="nid" placeholder="닉네임" id="nid" class="comtinp"></li>
						</ul>
					</div>
						
						
					<div>
						<ul>
							<li class="in1"><label for="npw"></label><input type="password" name="npw" placeholder="비밀번호" id="npw" class="comtinp"></li>
						</ul>
					</div>
				</div>
				
				<div class="com2">
					<textarea name="ncontent" placeholder="내용" id="ncontent" class="comtext"></textarea>
				</div>
				
				<div class="com3">
					<input type="hidden" name="num" value="<%=dto.getNum() %>">
					<button type="button" onClick="cmt1write();" class="ck1">등록</button>
				</div>
	
			</form>
			<hr>
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


