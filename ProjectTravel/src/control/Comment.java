package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dto.CommentDTO;
import dto.PageIn;
import dto.PageOut;


@WebServlet("*.comment")
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CommentDAO dao = new CommentDAO();
       
	
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
    
    public Comment() {
        super();

    }
    //´ñ±Û ¾²±â
    void comment1write(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	String id = request.getParameter("nid"); 
    	String pw = request.getParameter("npw"); 
    	String content = request.getParameter("ncontent");
    	
    	String num1 = request.getParameter("num");
    	
    	int link = Integer.parseInt(num1);
    	
    	System.out.println(id+"///"+pw+"///"+content+"///"+link);
    	
    	CommentDAO dao = new CommentDAO();
    	
    	CommentDTO dto = new CommentDTO(id, pw, content, link);
    	
    	if(dao.write(dto) == true) {
    		
    		forward(request, response, "tripread.bo");
    	}
    	
    }
    void comment2write(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	String id = request.getParameter("nid"); 
    	String pw = request.getParameter("npw"); 
    	String content = request.getParameter("ncontent");
    	
    	String num1 = request.getParameter("num");
    	
    	int link = Integer.parseInt(num1);
    	
    	System.out.println(id+"///"+pw+"///"+content+"///"+link);
    	
    	CommentDAO dao = new CommentDAO();
    	
    	CommentDTO dto = new CommentDTO(id, pw, content, link);
    	
    	if(dao.write2(dto) == true) {
    		
    		forward(request, response, "tripread2.bo");
    	}
    	
    }
    void comment3write(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	String id = request.getParameter("nid"); 
    	String pw = request.getParameter("npw"); 
    	String content = request.getParameter("ncontent");
    	
    	String num1 = request.getParameter("num");
    	
    	int link = Integer.parseInt(num1);
    	
    	System.out.println(id+"///"+pw+"///"+content+"///"+link);
    	
    	CommentDAO dao = new CommentDAO();
    	
    	CommentDTO dto = new CommentDTO(id, pw, content, link);
    	
    	if(dao.write3(dto) == true) {
    		
    		forward(request, response, "tripread3.bo");
    	}
    	
    }
    
    //´ñ±ÛÀÐ±â
    void read(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	String num1 = request.getParameter("num");
    	
    	int link = Integer.parseInt(num1);
    	
    	System.out.println("¸µÅ©Ã¼Å© :" + link);
    	
    	ArrayList<CommentDTO> list = dao.read(link);
    	
    	int count = (int) dao.countAll(link);
    	
    	request.setAttribute("ArrayList", list);
    	
    	request.setAttribute("count", count);
    	
    	forward(request, response, "tripread.jsp");
    	
    }
    void read2(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	String num1 = request.getParameter("num");
    	
    	int link = Integer.parseInt(num1);
    	
    	System.out.println("¸µÅ©Ã¼Å© :" + link);
    	
    	ArrayList<CommentDTO> list = dao.read2(link);
    	
    	int count = (int) dao.countAll2(link);
    	
    	request.setAttribute("ArrayList", list);
    	
    	request.setAttribute("count", count);
    	
    	forward(request, response, "tripread2.jsp");
    	
    }
    void read3(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	String num1 = request.getParameter("num");
    	
    	int link = Integer.parseInt(num1);
    	
    	System.out.println("¸µÅ©Ã¼Å© :" + link);
    	
    	ArrayList<CommentDTO> list = dao.read3(link);
    	
    	int count = (int) dao.countAll3(link);
    	
    	request.setAttribute("ArrayList", list);
    	
    	request.setAttribute("count", count);
    	
    	forward(request, response, "tripread3.jsp");
    	
    }
    
    //´ñ±Û»èÁ¦
    
    void del(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	String id = request.getParameter("id");
    	
    	String num = request.getParameter("num");
    	
    	System.out.println("idÃ¼Å© :" + id);
    	
    	CommentDAO dao = new CommentDAO();
    	
    	dao.del(id);
    	
    	request.setAttribute("num", num);
    	
    	forward(request, response, "tripread.bo");	
    }
    void del2(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	String id = request.getParameter("id");
    	
    	String num = request.getParameter("num");
    	
    	System.out.println("idÃ¼Å© :" + id);
    	
    	CommentDAO dao = new CommentDAO();
    	
    	dao.del2(id);
    	
    	request.setAttribute("num", num);
    	
    	forward(request, response, "tripread2.bo");	
    }
    void del3(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	String id = request.getParameter("id");
    	
    	String num = request.getParameter("num");
    	
    	System.out.println("idÃ¼Å© :" + id);
    	
    	CommentDAO dao = new CommentDAO();
    	
    	dao.del3(id);
    	
    	request.setAttribute("num", num);
    	
    	forward(request, response, "tripread3.bo");	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cmd = parseCommand(request);

		System.out.println("¼­ºí¸´ ½ÇÇà cmd : " + cmd);
		
		try{
			
			if(cmd.equals("comment1write.comment") == true ){
				
				System.out.println("´ñ±Û1ÀÛ¼º : comment1write.comment");
			
				comment1write(request, response);
	
			}else if(cmd.equals("comment2write.comment") == true ){
				
				System.out.println("´ñ±Û2ÀÛ¼º : comment2write.comment");
			
				comment2write(request, response);
	
			}else if(cmd.equals("comment3write.comment") == true ){
				
				System.out.println("´ñ±Û3ÀÛ¼º : comment3write.comment");
			
				comment3write(request, response);
	
			}
			else if(cmd.equals("read.comment") == true ){
				
				System.out.println("´ñ±Û1ÀÐ´Â : read.comment");
				
				read(request, response);
				
			}else if(cmd.equals("read2.comment") == true ){
				
				System.out.println("´ñ±Û2ÀÐ´Â : read2.comment");
				
				read2(request, response);
				
			}else if(cmd.equals("read3.comment") == true ){
				
				System.out.println("´ñ±Û3ÀÐ´Â : read3.comment");
				
				read3(request, response);
			}
			else if(cmd.equals("del.comment") == true ){
				
				System.out.println("´ñ±Û1»èÁ¦ : del.comment");
				
				del(request, response);
			}else if(cmd.equals("del2.comment") == true ){
				
				System.out.println("´ñ±Û2»èÁ¦ : del2.comment");
				
				del2(request, response);
			}else if(cmd.equals("del3.comment") == true ){
				
				System.out.println("´ñ±Û3»èÁ¦ : del3.comment");
				
				del3(request, response);
			}
			
		}catch(SQLException e){
			
			System.out.println("¿¡·¯"+ e.getMessage());
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("¿¡·¯"+ e.getMessage());
			e.printStackTrace();
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
