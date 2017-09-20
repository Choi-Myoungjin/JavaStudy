package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.PageOut;
import dao.MemDAO;
import dto.BoardDTO;
import dto.MemDTOIn;
import dto.PageIn;


@WebServlet("*.mem")
public class MemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	MemDAO dao = new MemDAO();
	
    public MemberCtrl() {
        super();
       
    }
    
    
    String parseCommand(HttpServletRequest request) {
    	
    	String uri = request.getRequestURI();
    	
    	String path = request.getContextPath();
    	
    	String cmd = uri.substring(path.length() + 1);

		return cmd;
    	
    }

    void sendRedirect(HttpServletResponse response, String view) throws ServletException, IOException, SQLException {
    	
    	response.sendRedirect(view);
    }
    
    void forward(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException{
    	
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	
    	rd.forward(request, response);
    	
    }
    
    //회원가입
    void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	
    	String id = request.getParameter("id"); 
    	String pw = request.getParameter("pw"); 
    	String phone = request.getParameter("phone"); 
    	 
    	
    	System.out.println(id);
    	System.out.println(pw);
    	System.out.println(phone);
    	
    	MemDTOIn dto = new MemDTOIn(id, pw, phone);
    	
    	if(dao.reg(dto) == true){
    		
    		//직접로그인//
    		this.sendRedirect(response, "login.jsp");
    		
    		
    		//회원가입후 자동 로그인//
    		/******************************
    		1.세션 정보
    		2.세션정보추가
    		3.페이지 이동
    		HttpSession session = request.getSession();
    		
    		session.setAttribute("UserId", id);
    		
    		this.sendRedirect(response, "login.jsp");
    		*****************************/
    	}
    }
    
    
    //로그인
    void log(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	
    	String id = request.getParameter("id"); 
    	String pw = request.getParameter("pw");
    			
    	System.out.println("입력 id : " + id);
    	System.out.println("입력 pw : " + pw);
    	
    	HttpSession session = request.getSession();

    	MemDAO dao = new MemDAO();
    	

    	
		if (dao.login(id, pw) == true) {

			session.setAttribute("UserID", id);//로그인 아이디값 가져오기
			
	    	int lv = (int) dao.lv(id);
	    	
			session.setAttribute("UserLv", lv);
			
			response.sendRedirect("main.jsp");

		} else {

			System.out.println("로긴1실패");
			response.sendRedirect("fail.jsp");
			
		}
    	
    }
    
    //로그아웃
    void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		
    	HttpSession session = request.getSession();
    	
    	session.invalidate();
    	    	
    	sendRedirect(response, "main.jsp");
		
	}
    
 // 아이디체크
 	void doIdCheck(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 		System.out.println("아디체크");
 		
 		String id = request.getParameter("id");
 		
 		PrintWriter out = response.getWriter();
 		
 		if (dao.idcheck(id) == true) {
 			System.out.println("이미있는 아이디입니다.");
 			out.print("{\"ret\":" + true + "}");
 			//out.print("{\"ret\":true}");
 			
 		} else {
 			System.out.println("사용가능한 아이디입니다.");
 			//out.print("{\"ret\":false}");
 			out.print("{\"ret\":" + false + "}");
 		}
 		
 		out.close();
 	}
 	
 	
//회원탈퇴
 	void RegDel(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 		System.out.println("회원탈퇴");
 		
 		HttpSession session = request.getSession();
 		
 		String id = (String) session.getAttribute("UserID");
 		
 		PrintWriter out = response.getWriter();
 		
 		System.out.println("id : " + id);
 		
 		if (dao.del(id) == true) {
 			
			System.out.println("회원탈퇴 성공");
			
			session.invalidate();
			
			out.print("{\"ret\":true}");
			
		} else {
			// 탈퇴실패
			out.print("{\"ret\":false}");
		}
		out.close();	
 	}
 	
//관리자용 회원삭제
 	void adminDel(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 		System.out.println("회원삭제");
 		
 		String id = request.getParameter("id");
 		
 		System.out.println("id : " + id);
 		
 		dao.del(id);
 			
		System.out.println("회원탈퇴 성공");
		
		forward(request, response, "adminview.mem");
		
 	}
 	
//admin페이지 회원보기
 	void adminview(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		/*
 		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		*/
 		int pageNo;
 		int pageSize;
 		
 		try {
 			pageNo = Integer.parseInt(request.getParameter("pageNo"));
 			pageSize = Integer.parseInt(request.getParameter("pageSize"));
 		} catch(NumberFormatException e) {
 		
 			pageNo = 0;
 			pageSize = 10;
 		}
 		
		int start = pageNo * pageSize;
		
		PageIn dto = new PageIn(pageNo, pageSize, 0, "", "");
		
 		ArrayList<MemDTOIn> list = dao.getMemberlist(dto);
 		
 		System.out.println(list.get(0).getId());
 		
 		request.setAttribute("ArrayList", list);
 		
		////////////////////////////////////
		int total = (int) dao.countAll();
		
		int pageNum = total / pageSize;
		if (total % pageSize != 0)
		pageNum++;
		
		int prevPage = pageNo - 1;
		int nextPage = pageNo + 1;
		if (nextPage >= pageNum)
		nextPage = -1;
		
		PageOut pageOut = new PageOut(pageNo, pageSize, total, pageNum, prevPage, nextPage);
		
		request.setAttribute("PAGEOUT", pageOut);
 		
 		forward(request, response, "adminpage.jsp");
 		

 	}
 	
//levelup
 	
 	void levelup(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 		String id = request.getParameter("id");
 		
 		int selectlevel = Integer.parseInt(request.getParameter("selectlevel"));
 		
 		System.out.println(id+"///"+selectlevel);
 		
 		dao.levelup(selectlevel, id);
 		
 		forward(request, response, "adminview.mem");
 		
 	}
 	
 	//관리자페이지 -- 검색기능
 	void search(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 		String word = request.getParameter("word");
 		
 		System.out.println("word : " + word);
 		
 		int pageNo;
 		int pageSize;
 		
 		try {
 			pageNo = Integer.parseInt(request.getParameter("pageNo"));
 			pageSize = Integer.parseInt(request.getParameter("pageSize"));
 		} catch(NumberFormatException e) {
 		
 			pageNo = 0;
 			pageSize = 10;
 		}
 		
		int start = pageNo * pageSize;
		
		PageIn dto = new PageIn(pageNo, pageSize, 0, word);
		
 		ArrayList<MemDTOIn> list = dao.getMemberlist1(dto);
 		
 		
 		request.setAttribute("ArrayList", list);
 		
		////////////////////////////////////
		int total = (int) dao.countAll();
		
		int pageNum = total / pageSize;
		if (total % pageSize != 0)
		pageNum++;
		
		int prevPage = pageNo - 1;
		int nextPage = pageNo + 1;
		if (nextPage >= pageNum)
		nextPage = -1;
		
		PageOut pageOut = new PageOut(pageNo, pageSize, total, pageNum, prevPage, nextPage);
		
		request.setAttribute("PAGEOUT", pageOut);
 		
 		forward(request, response, "adminpage.jsp");
 		
 	}
    
 	//회원정보
 	void memberInfo(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 		HttpSession session = request.getSession();
 		
 		String id = (String) session.getAttribute("UserID");
 		
 		System.out.println("id 값 가져왓니? " + id);
 		
 		MemDTOIn dtoa = dao.memberInfo(id);
 		
 		session.setAttribute("memberInfo", dtoa);
 		
 		forward(request, response, "memberInfo.jsp");
 		
 	}
 	
 	
 	//정보수정
 	void memInfoUp(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 	   	String rpath=request.getRealPath("images");
    	System.out.println(rpath);
    	String path    = null;
    	int    size    = 1024*1024*100;  
    	String encType = "utf-8";
    	
    	MultipartRequest mr = new MultipartRequest(request, 
												   rpath,
												   size,
												   encType,
												   new DefaultFileRenamePolicy());
    	
    	
    	HttpSession session = request.getSession();
 		
 		String id = (String) session.getAttribute("UserID");
    	
 		String name  = mr.getParameter("name");  
    	String info = mr.getParameter("info"); 
    	String photo   = mr.getFilesystemName("pic");
    	String phone = mr.getParameter("phone");
    	
    	String photoONE = mr.getParameter("photoONE");
    	System.out.println(photoONE);
    	File f = new File(rpath+"/"+photoONE);
    	
    	
    	MemDTOIn dto = new MemDTOIn(id, name, info, photo, phone);
    	
    	if(dao.memUpdate(dto) == true)
    	{
    		if(f.delete()){
        		System.out.println("삭제완료");
        		response.sendRedirect("memberInfo.mem");
        	}else{
        		System.out.println("삭제실패");
        		response.sendRedirect("memberInfo.mem");
        	}
    		
    		 
    	}
 		
 	}
 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String cmd = parseCommand(request);

		System.out.println("서블릿 실행 cmd : " + cmd);
		
		
		try{
		
			if(cmd.equals("reg.mem") == true ){
				
				System.out.println("회원가입 : reg.mem");
			
				reg(request, response);
	
			}else if(cmd.equals("log.mem") == true){
				System.out.println("로그인 : log.mem ");
				
				log(request, response);
			}else if(cmd.equals("logout.mem") == true) {
				
				System.out.println("로그이웃 : logout.mem");
				logout(request, response);
				
			} else if (cmd.equals("idCheck.mem") == true) {

				System.out.println("아이디쳌 : idCheck.mem");
				doIdCheck(request, response);
				
			} else if(cmd.equals("del.mem") == true ){
				
				System.out.println("회원탈퇴 : del.mem");
				RegDel(request, response);
				
			} else if(cmd.equals("adminview.mem") == true){
				
				System.out.println("회원관리체크 : adminview.mem");
				adminview(request, response);
				
			} else if(cmd.equals("adminDEL.mem") == true){
				
				System.out.println("회원삭제 : adminDel.mem");
				adminDel(request, response);
				
			} else if(cmd.equals("levelup.mem") == true) {
				
				System.out.println("레벨올려 : levelup.mem");
				levelup(request, response);
				
			} else if(cmd.equals("search.mem") == true) {
				
				System.out.println("검색해봐임마 : search.mem");
				search(request, response);
			} else if(cmd.equals("memberInfo.mem") == true ){
				
				System.out.println("맴버정보 : memberInfo.mem");
				memberInfo(request, response);
			} else if(cmd.equals("memInfoUp.mem") == true){
				
				System.out.println("맴버정보수정 : memberInfo.mem");
				memInfoUp(request, response);
			}
			
		}catch(SQLException e){
			
			System.out.println("에러"+ e.getMessage());
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("에러"+ e.getMessage());
			e.printStackTrace();
		}

	}


	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		
		
	}

}
