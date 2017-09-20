<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.MemDTOIn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function delUser()
	{
		var DD = confirm("탈퇴 하시겠습니까?")
		
		if(DD == true){
			
			$.ajax({
				type:"GET",
				url:"del.mem",
				dataType:"JSON",
				success:function(data){
					
					if(data.ret == true){
						
						alert("탈퇴완료");
						
						location.href = "main.jsp";
						
					}else{
						
						alert("탈퇴 에러");
					}
				},
				
				error:function(){
				
					alert("실행에러");
				}
			})
			
		} else{
			
			alert("취소");
		}
	}
</script>

<body>

	<%
		String uri = request.getRequestURI();	
	
		String UserID =(String) session.getAttribute("UserID"); 
		
		Integer UserLv =  (Integer) session.getAttribute("UserLv");
		
		MemDTOIn dtoa = (MemDTOIn) session.getAttribute("memberInfo");
		
		
		
	%>
		
<!-- nav 페이지 -->
	<nav id="slidebar-wrapper">
		<a href="#" id="menu-close" class="btn-close"><i class="fa fa-close"></i></a>
		<div class="slidebarwrap">
		<%if(dtoa == null){ %>
			<div class="slidebar-brand" style="background-image:URL(images/me.jpg); background-size:cover; background-repeat:no-repeat; background-position:center center;">
		<%}else{ %>
		<div class="slidebar-brand" style="background-image:URL(images/<%=dtoa.getPhoto() %>);  background-size:cover; background-repeat:no-repeat; background-position:center center;">
		<%} %>
			<ul class="cir-cam"><li><a href="memberInfo.mem"><i class="fa fa-camera"></i></a></li></ul>
			</div>
		</div>
		
			<!--mail box-->
				<div class="maildiv">
					<i class="fa fa-envelope-o mail"></i>
					<span class="mailAddress">&nbsp;&nbsp;&nbsp;
					<%if(UserID != null){
						out.print(UserID);%> 님 로그인&nbsp;&nbsp;&nbsp;&nbsp;</span>
					<a href="memberInfo.mem">정보수정<i class="fa fa-caret-down down"></i></a>
					<%} else{ %> 로그인 하세요
					<%} %>
					 
					
				</div>
			
			<!--sidebar-nav-->
				<ul class="sidebar-nav">
					<li><a href="main.jsp"><i class="fa  fa-home active"></i>HOME</a></li>
				<%if(UserID == null){%>
					<li><a href="member.jsp"><i class="fa fa-user-plus"></i>회원가입</a></li>
					<li><a href="login.jsp"><i class="fa  fa-user"></i>로그인</a></li>	
					
				<%}else if(UserID != null && UserLv == 1) { %>
				
					<li><a href="adminview.mem?pageNo=0&pageSize=10"><i class="fa  fa-user"></i>회원관리</a></li>
					
					<li><a href="adminwrite.jsp"><i class="fa fa-user"></i>관리글쓰기</a></li>
										
					<li><a href="location.jsp"><i class="fa fa-location-arrow"></i>위치정보</a></li>
					
					<li><a href="album.jsp"><i class="fa fa-picture-o"></i>앨범</a></li>
					
					<li><a href="logout.mem" ><i class="fa fa-user"></i>로그아웃</a></li>
					
				<%}else if(UserID != null && UserLv == 0) { %>
					
					<li><a href="location.jsp"><i class="fa fa-location-arrow"></i>위치정보</a></li>
					
					<li><a href="album.jsp"><i class="fa fa-picture-o"></i>앨범</a></li>
					
					<li><a href="logout.mem" ><i class="fa fa-user"></i>로그아웃</a></li>					
					
					<li><a href="#" onclick="delUser()"><i class="fa fa-user-plus"></i>회원탈퇴</a></li>
					
				<%} %>
					
				</ul>
	</nav>
				
				
</body>
</html>