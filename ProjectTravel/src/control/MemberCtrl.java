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
    
    //ȸ������
    void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	
    	String id = request.getParameter("id"); 
    	String pw = request.getParameter("pw"); 
    	String phone = request.getParameter("phone"); 
    	 
    	
    	System.out.println(id);
    	System.out.println(pw);
    	System.out.println(phone);
    	
    	MemDTOIn dto = new MemDTOIn(id, pw, phone);
    	
    	if(dao.reg(dto) == true){
    		
    		//�����α���//
    		this.sendRedirect(response, "login.jsp");
    		
    		
    		//ȸ�������� �ڵ� �α���//
    		/******************************
    		1.���� ����
    		2.���������߰�
    		3.������ �̵�
    		HttpSession session = request.getSession();
    		
    		session.setAttribute("UserId", id);
    		
    		this.sendRedirect(response, "login.jsp");
    		*****************************/
    	}
    }
    
    
    //�α���
    void log(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	
    	String id = request.getParameter("id"); 
    	String pw = request.getParameter("pw");
    			
    	System.out.println("�Է� id : " + id);
    	System.out.println("�Է� pw : " + pw);
    	
    	HttpSession session = request.getSession();

    	MemDAO dao = new MemDAO();
    	

    	
		if (dao.login(id, pw) == true) {

			session.setAttribute("UserID", id);//�α��� ���̵� ��������
			
	    	int lv = (int) dao.lv(id);
	    	
			session.setAttribute("UserLv", lv);
			
			response.sendRedirect("main.jsp");

		} else {

			System.out.println("�α�1����");
			response.sendRedirect("fail.jsp");
			
		}
    	
    }
    
    //�α׾ƿ�
    void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		
    	HttpSession session = request.getSession();
    	
    	session.invalidate();
    	    	
    	sendRedirect(response, "main.jsp");
		
	}
    
 // ���̵�üũ
 	void doIdCheck(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 		System.out.println("�Ƶ�üũ");
 		
 		String id = request.getParameter("id");
 		
 		PrintWriter out = response.getWriter();
 		
 		if (dao.idcheck(id) == true) {
 			System.out.println("�̹��ִ� ���̵��Դϴ�.");
 			out.print("{\"ret\":" + true + "}");
 			//out.print("{\"ret\":true}");
 			
 		} else {
 			System.out.println("��밡���� ���̵��Դϴ�.");
 			//out.print("{\"ret\":false}");
 			out.print("{\"ret\":" + false + "}");
 		}
 		
 		out.close();
 	}
 	
 	
//ȸ��Ż��
 	void RegDel(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 		System.out.println("ȸ��Ż��");
 		
 		HttpSession session = request.getSession();
 		
 		String id = (String) session.getAttribute("UserID");
 		
 		PrintWriter out = response.getWriter();
 		
 		System.out.println("id : " + id);
 		
 		if (dao.del(id) == true) {
 			
			System.out.println("ȸ��Ż�� ����");
			
			session.invalidate();
			
			out.print("{\"ret\":true}");
			
		} else {
			// Ż�����
			out.print("{\"ret\":false}");
		}
		out.close();	
 	}
 	
//�����ڿ� ȸ������
 	void adminDel(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 		System.out.println("ȸ������");
 		
 		String id = request.getParameter("id");
 		
 		System.out.println("id : " + id);
 		
 		dao.del(id);
 			
		System.out.println("ȸ��Ż�� ����");
		
		forward(request, response, "adminview.mem");
		
 	}
 	
//admin������ ȸ������
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
 	
 	//������������ -- �˻����
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
    
 	//ȸ������
 	void memberInfo(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
 		
 		HttpSession session = request.getSession();
 		
 		String id = (String) session.getAttribute("UserID");
 		
 		System.out.println("id �� �����Ӵ�? " + id);
 		
 		MemDTOIn dtoa = dao.memberInfo(id);
 		
 		session.setAttribute("memberInfo", dtoa);
 		
 		forward(request, response, "memberInfo.jsp");
 		
 	}
 	
 	
 	//��������
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
        		System.out.println("�����Ϸ�");
        		response.sendRedirect("memberInfo.mem");
        	}else{
        		System.out.println("��������");
        		response.sendRedirect("memberInfo.mem");
        	}
    		
    		 
    	}
 		
 	}
 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String cmd = parseCommand(request);

		System.out.println("���� ���� cmd : " + cmd);
		
		
		try{
		
			if(cmd.equals("reg.mem") == true ){
				
				System.out.println("ȸ������ : reg.mem");
			
				reg(request, response);
	
			}else if(cmd.equals("log.mem") == true){
				System.out.println("�α��� : log.mem ");
				
				log(request, response);
			}else if(cmd.equals("logout.mem") == true) {
				
				System.out.println("�α��̿� : logout.mem");
				logout(request, response);
				
			} else if (cmd.equals("idCheck.mem") == true) {

				System.out.println("���̵�n : idCheck.mem");
				doIdCheck(request, response);
				
			} else if(cmd.equals("del.mem") == true ){
				
				System.out.println("ȸ��Ż�� : del.mem");
				RegDel(request, response);
				
			} else if(cmd.equals("adminview.mem") == true){
				
				System.out.println("ȸ������üũ : adminview.mem");
				adminview(request, response);
				
			} else if(cmd.equals("adminDEL.mem") == true){
				
				System.out.println("ȸ������ : adminDel.mem");
				adminDel(request, response);
				
			} else if(cmd.equals("levelup.mem") == true) {
				
				System.out.println("�����÷� : levelup.mem");
				levelup(request, response);
				
			} else if(cmd.equals("search.mem") == true) {
				
				System.out.println("�˻��غ��Ӹ� : search.mem");
				search(request, response);
			} else if(cmd.equals("memberInfo.mem") == true ){
				
				System.out.println("�ɹ����� : memberInfo.mem");
				memberInfo(request, response);
			} else if(cmd.equals("memInfoUp.mem") == true){
				
				System.out.println("�ɹ��������� : memberInfo.mem");
				memInfoUp(request, response);
			}
			
		}catch(SQLException e){
			
			System.out.println("����"+ e.getMessage());
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("����"+ e.getMessage());
			e.printStackTrace();
		}

	}


	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		
		
	}

}
