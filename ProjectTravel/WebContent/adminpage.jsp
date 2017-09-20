<%@page import="dto.PageOut"%>
<%@page import="dto.MemDTOIn"%>
<%@page import="dao.MemDAO"%>
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
	
	function delok(id)
	{
		 location.href = "adminDEL.mem?id="+id;
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
	<%
	
	ArrayList list =(ArrayList) request.getAttribute("ArrayList");
	
	PageOut pageinfo = (PageOut) request.getAttribute("PAGEOUT");
    %>

<div claass="adminpage">
	<div>
	
		<table>
		
			<thead>
				<tr>
					<th class="m-none" scope="col">No.</th>
					<th scope="col">ID</th>
					<th scope="col">가입일</th>
					<th scope="col">등급</th>
					<th scope="col">LEVEL</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			
			<tbody>
				<%
					for(int i = 0 ; i < list.size(); i++){
						
						MemDTOIn dto = (MemDTOIn)list.get(i);
						
				%>
				<tr>
					<td class="m-none"><%=i+1 %></td>
					<th id="id22" scope="row"><%=dto.getId() %></th>
					<td><%=dto.getReg_date().substring(2,11) %></td>
					<td><%if(dto.getLv() == 1){
							out.print("관리자");
							}else if(dto.getLv() == 0){
								out.print("일반");
						} %>
					</td>
					<td>
						<form action="levelup.mem" metgod="GET">
							<select name="selectlevel">
								<option selected value="0">-선택하세요-
								<option value="1">Admin
								<option value="0">Member
							</select>
							<input type="hidden" name="id" value="<%=dto.getId() %>">
							<input type="submit" value="적용">
						</form>	 
					</td>
					<td><button onclick="delok('<%=dto.getId() %>')">삭제</button></td>
				</tr>
				<%} %>
				
			</tbody>
		</table>
		
		<div>
			<div class="paging">
				<ul>
				
				<!--이전페이지 기능-->
				<%
				
				int prevPage = pageinfo.getPrevPage();
				int pageSize = pageinfo.getPageSize();
				
				if(prevPage != -1){
				
				%>
				<li><a href="adminview.mem?pageNo=<%=prevPage%>&&pageSize=<%=pageSize%>">
				<i class="fa  fa-angle-double-left"></i></li>
				<% } %>
				
				
				<!--  페이지 번호 출력 / 페이지 이동 -->
				<%
				
				int pageNum = pageinfo.getPageNum(); //전체페이지개수
				int pageNo= pageinfo.getPageNo();	//현재 페이지 번호
				
				for(int i = 0 ; i < pageNum ; i++) {
				
				%>
					
					<%if(i == pageNo){ %>
						<li><strong><%=i+1 %></strong></li>
					
					<%}else{%>
						<li><a href="adminview.mem?pageNo=<%=i%>&pageSize=<%=pageSize%>"><%=i+1 %></a></li>
					<%} %>
				<%} %>
				
				<!-- 다음 페이지 이동 기능 -->	
				<%
					int nextPage = pageinfo.getNextPage();//다음 페이지 번호
					                                //-1은 다음 페이지 이동이 없음
					if(nextPage != -1)
					{
				%>	
					<li><a href="adminview.mem?pageNo=<%=nextPage%>&&pageSize=<%=pageSize%>">		
						<i class="fa fa-angle-double-right"></i>
					</a></li>
				<%}%>	
				
				</ul>
			</div>
			
			<form action="search.mem" name="search" method ="get" class="search">
	            <input type="text" name="word" value="">
	            <input type="submit" value="검색">
            </form>
		</div>
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


