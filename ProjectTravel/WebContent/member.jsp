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
	
	<script>
	
	var id = document.getElementById('id');
    var pw = document.getElementById('pww');
    var phone = document.getElementById('phone');
    var idCheck = 0;
    var pwdCheck = 0;
    

		 //아이디 체크  중복확인 비번체크   
	    function checkId() {
	        var inputed = $('#idd').val();
	        $.ajax({
	       		type:"GET",
	            data : {
	                id : inputed
	            },
	            url : "idCheck.mem",
	            dataType:"json",
	            error : function() {
					alert('통신실패!!');
		        },
	            success : function(data) {
	               console.log("ajax success");
	               console.log(data.ret);
	               if(inputed=="" && data.ret == false){
	            	   $(".signupbtn").prop("disabled", true);
	                   $(".signupbtn").css("background-color", "#aaaaaa")
	            	   
	            	   idCheck=0;
	            	   document.getElementById("idd").style.backgroundColor="#FFCECE";
	            	   
	               } else if (data.ret == true || inputed.length > 16) {
	            	   
	            	   console.log("1번");
	            	   document.getElementById("idd").style.backgroundColor="#FFCECE";
	            	   $(".signupbtn").prop("disabled", true);
	                   $(".signupbtn").css("background-color", "#FFCECE");
	                    
	            	   idCheck=0;
					   
	                   
	                } else if (data.ret == false || inputed.length < 16){
	                	
	                	console.log("2번");
	                	document.getElementById("idd").style.backgroundColor="#B0F6AC";

	                	idCheck=1;
		            	   if(idCheck==1 && pwdCheck == 1) {
		                        $(".signupbtn").prop("disabled", false);
		                        $(".signupbtn").css("background-color", "#B0F6AC");
		                        signupCheck();
		            	   }
	             
	                }
	   		     }
	        });
	        
	        
	    }
	    //비밀번호 중복체크
	    function checkPwd() {
	        var inputed = $('#pww').val();
	        var reinputed = $('#pww11').val();
	        
	        if(reinputed=="" && (inputed != reinputed || inputed == reinputed)){

	           document.getElementById("pww11").style.backgroundColor="#FFCECE";
	           // $("#pww11").css("background-color", "#FFCECE");
	           
	           $(".signupbtn").prop("disabled", true);
	           $(".signupbtn").css("background-color", "#FFCECE");
	            
	        }
	        else if (inputed == reinputed && inputed.length < 12) {
	           document.getElementById("pww11").style.backgroundColor="#B0F6AC";
	           
	           pwdCheck = 1;
	            if(idCheck==1 && pwdCheck == 1) {
	                $(".signupbtn").prop("disabled", false);
	                $(".signupbtn").css("background-color", "#B0F6AC");
	                signupCheck();
	            }

	        } else if (inputed != reinputed) {
	        	pwdCheck = 0;
	            document.getElementById("pww11").style.backgroundColor="#FFCECE";
	            $(".signupbtn").prop("disabled", true);
	            $(".signupbtn").css("background-color", "#FFCECE");
	        }
	    }
	    
	    

	    function signupCheck() {
	        var phone = $("#phone").val();
	        
	        if(phone == "") {
	        	console.log("1번");
	        	$(".signupbtn").prop("disabled", true);
	            $(".signupbtn").css("background-color", "#FFCECE");
	            
	        } else if(idCheck==1 && pwdCheck == 1 && phone !="" && phone.length == 11){
	        	console.log("2번");
	        	$(".signupbtn").prop("disabled", false);
                $(".signupbtn").css("background-color", "#B0F6AC");
	        } else{
	        	console.log("3번");
	        	$(".signupbtn").prop("disabled", true);
	            $(".signupbtn").css("background-color", "#FFCECE");
	        }
	    }
	    function okokok(){
	    	myformidpw.submit();
	    }
	    
	    

	    
	    //옛날 함수로그인체크한거//
		function logcheck() {
			if(myformidpw.id.value=="") {
				alert("아이디입력");
				myformidpw.id.focus();
				return;
			}
			if(myformidpw.pw.value=="") {
				alert("패스워드입력");
				myformidpw.pw.focus();
				return;
			}
			if(myformidpw.phone.value=="") {
				alert("전화번호를 - 없이 입력해주세요");
				myformidpw.phone.focus();
				return;
			}
			myformidpw.submit();
		}
		
	</script>
	
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
	
<!--login-->
	<div class="loginbox">
		<div class="loginbox-top"></div>
		
		<form name="myformidpw" method="post"  class="loginform" action="reg.mem">
			<label for="idd"></label><input type="text" name="id" required class="id" placeholder="아이디입력(한글/영어 16자이하)" id="idd" class="loginform-id" oninput="checkId()">
			<label for="pww"></label><input type="password" name="pw" placeholder="패스워드입력(12글자 미만)" id="pww" required class="pass" oninput="checkPwd()">
			<label for="pww"></label><input type="password" name="pw11" placeholder="패스워드확인" id="pww11" required class="pass" oninput="checkPwd()">
			<label for="phone"></label><input type="text" name="phone" placeholder="전화번호 - 없이 입력" id="phone" onkeyup="signupCheck()">
		</form>
					
		<button class="signupbtn" disabled="disabled" onclick="okokok()"><i class="fa fa-user-plus"></i>&nbsp;&nbsp;&nbsp;회원가입</button>
		
		<div class="login-mail">
			<ul>
				
				<!-- <li class="login-join"><a href="#" onClick="javascript:logcheck();">회원가입</a></li> -->
				<li class="login-naver"><a href="#">네이버 아이디</a></li>
				<li class="login-facebook"><a href="#">페이스북 아이디</a></li>
			</ul>
		</div>
		
		<p><a href="#">아이디 </a>또는<a href="#"> 비밀번호</a> 찾기</p>
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


