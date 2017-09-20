package control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.BoardDTO;

@WebServlet("*.bo")
public class BoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardDAO dao = new BoardDAO();

	String parseCommand(HttpServletRequest request) {

		String uri = request.getRequestURI();

		String path = request.getContextPath();

		String cmd = uri.substring(path.length() + 1);

		return cmd;

	}

	void sendRedirect(HttpServletResponse response, String view) throws ServletException, IOException, SQLException {

		response.sendRedirect(view);
	}

	void forward(HttpServletRequest request, HttpServletResponse response, String view)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher(view);

		rd.forward(request, response);

	}

	public BoardCtrl() {
		super();
	}

	void trip1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		System.out.println("trip1 메소드 여기 들어오니?");

		BoardDAO dao = new BoardDAO();

		ArrayList<BoardDTO> list = dao.trip1();

		request.setAttribute("ArrayList", list);

		forward(request, response, "trip.jsp");

	}

	void trip2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		System.out.println("trip2 메소드 여기 들어오니?");

		BoardDAO dao = new BoardDAO();

		ArrayList<BoardDTO> list = dao.trip2();

		request.setAttribute("ArrayList", list);

		forward(request, response, "trip2.jsp");

	}

	void trip3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		System.out.println("trip3 메소드 여기 들어오니?");

		BoardDAO dao = new BoardDAO();

		ArrayList<BoardDTO> list = dao.trip3();

		request.setAttribute("ArrayList", list);

		forward(request, response, "trip3.jsp");

	}

	void tripread(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		System.out.println("tripread 메소드 여기 들어오니?");

		String num1 = request.getParameter("num");

		BoardDAO dao = new BoardDAO();

		int num = Integer.parseInt(num1);

		BoardDTO dto = dao.tripread(num);

		request.setAttribute("Boardread", dto);

		forward(request, response, "read.comment");

	}

	void tripread2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		System.out.println("tripread2 메소드 여기 들어오니?");

		String num1 = request.getParameter("num");

		BoardDAO dao = new BoardDAO();

		int num = Integer.parseInt(num1);

		BoardDTO dto = dao.tripread2(num);

		request.setAttribute("Boardread", dto);

		forward(request, response, "read2.comment");

	}

	void tripread3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		System.out.println("tripread3 메소드 여기 들어오니?");

		String num1 = request.getParameter("num");

		BoardDAO dao = new BoardDAO();

		int num = Integer.parseInt(num1);

		BoardDTO dto = dao.tripread3(num);

		request.setAttribute("Boardread", dto);

		forward(request, response, "read3.comment");

	}

	void write(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		String rpath = request.getRealPath("images");
		System.out.println(rpath);
		String path = null;
		int size = 1024 * 1024 * 100;
		String encType = "utf-8";

		MultipartRequest mr = new MultipartRequest(request, rpath, size, encType, new DefaultFileRenamePolicy());

		String type = mr.getParameter("type");
		String name = mr.getParameter("title");
		String content = mr.getParameter("content");
		String photo = mr.getFilesystemName("pic");
		String map = mr.getParameter("map");

		System.out.println(name);
		System.out.println(type + "/타입번호임");
		BoardDTO dto = new BoardDTO(name, content, photo, map);

		if (type.equals("1")) {

			if (dao.write(dto) == true) {

				response.sendRedirect("trip1.bo");
			}

		} else if (type.equals("2")) {

			if (dao.write2(dto) == true) {

				response.sendRedirect("trip2.bo");
			}

		} else if (type.equals("3")) {

			if (dao.write3(dto) == true) {

				response.sendRedirect("trip3.bo");
			}
		}

	}

	void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		String num1 = request.getParameter("num");

		int num = Integer.parseInt(num1);

		BoardDAO dao = new BoardDAO();

		String rpath = request.getRealPath("images");

		String photoONE = request.getParameter("photo");
		System.out.println(photoONE);
		File f = new File(rpath + "/" + photoONE);

		if (dao.del(num)) {
			if (f.delete()) {

				System.out.println("사진삭제완료1");

				forward(request, response, "trip1.bo");
			} else {
				System.out.println("사진삭제실패1");
				forward(request, response, "trip1.bo");

			}
		}

	}

	void del2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		String num1 = request.getParameter("num");

		int num = Integer.parseInt(num1);

		BoardDAO dao = new BoardDAO();

		String rpath = request.getRealPath("images");

		String photoONE = request.getParameter("photo");
		System.out.println(photoONE);
		File f = new File(rpath + "/" + photoONE);

		if (dao.del2(num)) {
			if (f.delete()) {

				System.out.println("사진삭제완료2");

				forward(request, response, "trip2.bo");
			} else {
				System.out.println("사진삭제실패2");
				forward(request, response, "trip2.bo");

			}
		}

	}

	void del3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		String num1 = request.getParameter("num");

		int num = Integer.parseInt(num1);

		BoardDAO dao = new BoardDAO();

		String rpath = request.getRealPath("images");

		String photoONE = request.getParameter("photo");
		System.out.println(photoONE);
		File f = new File(rpath + "/" + photoONE);

		if (dao.del3(num)) {
			if (f.delete()) {

				System.out.println("사진삭제완료3");

				forward(request, response, "trip3.bo");
			} else {
				System.out.println("사진삭제실패3");
				forward(request, response, "trip3.bo");

			}
		}

	}

	void adminco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		String rpath = request.getRealPath("images");
		System.out.println(rpath);
		String path = null;
		int size = 1024 * 1024 * 100;
		String encType = "utf-8";

		MultipartRequest mr = new MultipartRequest(request, rpath, size, encType, new DefaultFileRenamePolicy());

		String name = mr.getParameter("title");
		String content = mr.getParameter("content");
		String photo = mr.getFilesystemName("pic");
		String map = mr.getParameter("map");
		String num1 = mr.getParameter("num");
		int num = Integer.parseInt(num1);

		String photoONE = mr.getParameter("photoONE");
		System.out.println(photoONE);
		File f = new File(rpath + "/" + photoONE);

		String type = mr.getParameter("type");

		BoardDTO dto = new BoardDTO(name, content, map, photo, num);
		
		if (type.equals("1")) {
			
			if (dao.update(dto) == true) {
				if (f.delete()) {
					System.out.println("삭제완료1");
					response.sendRedirect("trip1.bo");
				} else {
					System.out.println("삭제실패1");
					response.sendRedirect("trip1.bo");
				}
			}
		} else if (type.equals("2")) {
			if (dao.update2(dto) == true) {
				if (f.delete()) {
					System.out.println("삭제완료2");
					response.sendRedirect("trip2.bo");
				} else {
					System.out.println("삭제실패2");
					response.sendRedirect("trip2.bo");
				}
			}

		} else if (type.equals("3")) {
			if (dao.update3(dto) == true) {
				if (f.delete()) {
					System.out.println("삭제완료3");
					response.sendRedirect("trip3.bo");
				} else {
					System.out.println("삭제실패3");
					response.sendRedirect("trip3.bo");
				}
			}
		}else{
			System.out.println("오류에요오류에요");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = parseCommand(request);

		System.out.println("서블릿 실행 cmd : " + cmd);

		try {

			if (cmd.equals("trip1.bo") == true) {

				System.out.println("관광명소 : trip1.bo");

				trip1(request, response);

			} else if (cmd.equals("trip2.bo") == true) {

				System.out.println("역사관광 : trip2.bo");

				trip2(request, response);

			} else if (cmd.equals("trip3.bo") == true) {

				System.out.println("공원 : trip3.bo");

				trip3(request, response);

			} else if (cmd.equals("tripread.bo") == true) {

				System.out.println("읽어봅시다 : tripread.bo");

				tripread(request, response);

			} else if (cmd.equals("tripread2.bo") == true) {

				System.out.println("읽어봅시다 : tripread2.bo");

				tripread2(request, response);

			} else if (cmd.equals("tripread3.bo") == true) {

				System.out.println("읽어봅시다 : tripread3.bo");

				tripread3(request, response);

			} else if (cmd.equals("write.bo") == true) {

				System.out.println("글써봅시다 : write.bo");

				write(request, response);

			} else if (cmd.equals("del.bo") == true) {

				System.out.println("글지워봅니다 : del.bo");

				del(request, response);

			} else if (cmd.equals("del2.bo") == true) {

				System.out.println("글지워봅니다 : del2.bo");

				del2(request, response);

			} else if (cmd.equals("del3.bo") == true) {

				System.out.println("글지워봅니다 : del3.bo");

				del3(request, response);

			} else if (cmd.equals("adminco.bo") == true) {

				System.out.println("글수정해봅시다 : adminco.bo");

				adminco(request, response);
			}

		} catch (SQLException e) {

			System.out.println("에러" + e.getMessage());
			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("에러" + e.getMessage());
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
