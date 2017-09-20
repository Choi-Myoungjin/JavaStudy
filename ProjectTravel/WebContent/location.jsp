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
	
<!--location-->
	<div id="f-locateAnchor" class="ui-locate-blockopt">
		<div class="locate-map">
			
			<div class="marker">
				
					<div class="marker-locate-1" id = "marker-locate-1"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-2" id="marker-locate-2"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-3"  id="marker-locate-3"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-4"  id="marker-locate-4"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-5"  id="marker-locate-5"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-6"  id="marker-locate-6"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-7"  id="marker-locate-7"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-8"  id="marker-locate-8"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-9"  id="marker-locate-9"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-10"  id="marker-locate-10"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-11"  id="marker-locate-11"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-12"  id="marker-locate-12"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-13"  id="marker-locate-13"><i class="fa fa-map-marker" ></i></div>
					<div class="marker-locate-14"  id="marker-locate-14"><i class="fa fa-map-marker" ></i></div>
			
			
			
					<div class="marker-1">
						<button type="button" value="hapdeok" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">합덕읍</button>
					</div>
				
					<div class="marker-2">
							<button type="button" value="songak"  onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">송악읍</button>
					</div>
				
					<div class="marker-3">
						<button type="button" value="godae" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">고대면</button>
					</div>
				
					<div class="marker-4">
						<button type="button" value="seokmun" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">석문면</button>
					</div>
				
					<div class="marker-5">
						<button type="button" value="daehoji" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">대호지면</button>
					</div>
				
					<div class="marker-6">
						<button type="button" value="jeongmi" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">정미면</button>
					</div>
				
					<div class="marker-7">
						<button type="button" value="myeoncheon" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">면천면</button>
					</div>
				
					<div class="marker-8">
						<button type="button" value="sunseong" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">순성면</button>
					</div>
				
					<div class="marker-9">
						<button type="button" value="wugang" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">우강면</button>
					</div>
				
					<div class="marker-10">
						<button type="button" value="shinpyeong" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">신평면</button>
					</div>
				
					<div class="marker-11">
						<button type="button" value="songsan" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">송산면</button>
					</div>
				
					<div class="marker-12">
						<button type="button" value="1dong" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">당진1동</button>
					</div>
				
					<div class="marker-13">
					<button type="button" value="2dong" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">당진2동</button>
					</div>
				
					<div class="marker-14">
						<button type="button" value="3dong" onMouseover="this.style.color='red';" onMouseout="this.style.color='black';">당진3동</button>
					</div>
				
			</div>
		</div>
	

	<div class="locate-search">
				<div class="loca-search-1">
				
					<span>SEARCH</span>
										<div class="button-group" >
							<div>
								<button type="button" class="dongBtn" id="hapdeok" value="hapdeok" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';"  onclick="doDisplay1()">합덕읍</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="songak" value="songak" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay2()">송악읍</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="godae" value="godae" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay3()">고대면</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="seokmun" value="seokmun" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay4()">석문면</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="daehoji" value="daehoji" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay5()">대호지면</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="jeongmi" value="jeongmi" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black'; " onclick="doDisplay6()">정미면</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="myeoncheon" value="myeoncheon" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay7()">면천면</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="sunseong" value="sunseong" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay8()">순성면</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="wugang" value="wugang" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay9()">우강면</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="shinpyeong" value="shinpyeong" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay10()">신평면</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="songsan" value="songsan" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay11()">송산면</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="1dong" value="1dong" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay12()">당진1동</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="2dong" value="2dong" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay13()">당진2동</button>
							</div>
						
							<div>
								<button type="button" class="dongBtn" id="3dong" value="3dong" onMouseover="this.style.color='blue';" onMouseout="this.style.color='black';" onclick="doDisplay14()">당진3동</button>
							</div>
						
					</div>
					<div class="loca-option">
						<label >언&nbsp;&nbsp;&nbsp;제?</label>
						<select id="type" name="contentMonthCode">
							<option value="">전체</option>
							<option value="01">1월</option>
							<option value="02">2월</option>
							<option value="03">3월</option>
							<option value="04">4월</option>
							<option value="05">5월</option>
							<option value="06">6월</option>
							<option value="07">7월</option>
							<option value="08">8월</option>
							<option value="09">9월</option>
							<option value="10">10월</option>
							<option value="11">11월</option>
							<option value="12">12월</option>
						</select>
					</div>
					<div class="loca-option">
						<label>누구와?</label>
						<select id="type1" name="searchUseYn">
							<option value="">전체</option>
							
								<option value="WHO001">나홀로</option> 
							
								<option value="WHO002">가족</option> 
							
								<option value="WHO003">연인</option> 
							
								<option value="WHO004">친구</option> 
							
								<option value="WHO005">모임</option> 
							
						</select>
					</div>
					<div class="loca-option">
						<label>어디로?</label>
						<select id="type2" name="searchCondition">
							<option value="">전체</option>
							
								<option value="TC001">당진9경</option>
							
								<option value="TC002">관광명소</option>
							
								<option value="TC003">역사관광</option>
							
								<option value="TC006">체험관광</option>
							
								<option value="TC007">공원</option>
							
								<option value="TC004">문화예술</option>
							
								<option value="TC008">박물관</option>
							
								<option value="TC005">축제</option>
							
						</select>
					</div>

					<div class="search-input">
						<label class="skip" for="findInp">검색어를 입력해주세요</label>
						<div class="input-box">
							<input type="text" class="findTxt" name="searchKeyword" id="findInp" value="" placeholder="검색어를 입력해주세요">
						</div>
						<div class="input-btn">
							<input type="submit" class="btn-find" value="검색">
						</div>
					</div>
					
					<div id="map">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d144392.3795053695!2d126.61713498789018!3d36.89869747522019!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357aff4a121505e9%3A0xb7090294d6f71b90!2z64yA7ZWc66-86rWtIOy2qeyyreuCqOuPhCDri7nsp4Tsi5w!5e0!3m2!1sko!2skr!4v1504482981139" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
					</div>
					
		</div>
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

	<script>
	
	<!--location btn-->
		function  doDisplay1() {
			
			var  positionImg = document.getElementById("marker-locate-1");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
					return;
			} else {
					positionImg.style.display = "none";
			}
		}
		
		function  doDisplay2() {
			
			var  positionImg = document.getElementById("marker-locate-2");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		function  doDisplay3() {
			
			var  positionImg = document.getElementById("marker-locate-3");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		
		function  doDisplay4() {
			
			var  positionImg = document.getElementById("marker-locate-4");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		function  doDisplay5() {
			
			var  positionImg = document.getElementById("marker-locate-5");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		
		function  doDisplay6() {
			
			var  positionImg = document.getElementById("marker-locate-6");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		function  doDisplay7() {
			
			var  positionImg = document.getElementById("marker-locate-7");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		
		function  doDisplay8() {
			
			var  positionImg = document.getElementById("marker-locate-8");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		function  doDisplay9() {
			
			var  positionImg = document.getElementById("marker-locate-9");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		
		function  doDisplay10() {
			
			var  positionImg = document.getElementById("marker-locate-10");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		function  doDisplay11() {
			
			var  positionImg = document.getElementById("marker-locate-11");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		
		function  doDisplay12() {
			
			var  positionImg = document.getElementById("marker-locate-12");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		function  doDisplay13() {
			
			var  positionImg = document.getElementById("marker-locate-13");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
		
		function  doDisplay14() {
			
			var  positionImg = document.getElementById("marker-locate-14");
			
			if( positionImg.style.display == "none") {
					positionImg.style.display = "block";
			} else {
					positionImg.style.display = "none";
			}
		}
	</script>
</body>

</html>


