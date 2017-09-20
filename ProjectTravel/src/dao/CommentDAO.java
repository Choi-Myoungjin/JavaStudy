package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.CommentDTO;
import dto.PageIn;

public class CommentDAO {
	
	public Connection con;
	
	public PreparedStatement pstm;
	
	public int ret;
	
	ResultSet rs;

	public Statement stm;
	
	//댓글쓰기//
	public boolean write(CommentDTO dto) throws SQLException{
		
		con = DBCP.getConnection();
		
		String id = dto.getId();
		String pw = dto.getPw();
		String content = dto.getContent();
		int link = dto.getLink();
		
		String sql = "insert comment set id=?, pw=?, content=?, link=?";
		
		
		pstm = con.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.setString(2, pw);
		pstm.setString(3, content);
		pstm.setInt(4, link);
		
		int ret = pstm.executeUpdate();
		
		pstm.close();
		con.close();
		
		return ret == 1;
		
	}
	public boolean write2(CommentDTO dto) throws SQLException{
		
		con = DBCP.getConnection();
		
		String id = dto.getId();
		String pw = dto.getPw();
		String content = dto.getContent();
		int link = dto.getLink();
		
		String sql = "insert comment2 set id=?, pw=?, content=?, link=?";
		
		
		pstm = con.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.setString(2, pw);
		pstm.setString(3, content);
		pstm.setInt(4, link);
		
		int ret = pstm.executeUpdate();
		
		pstm.close();
		con.close();
		
		return ret == 1;
		
	}
	public boolean write3(CommentDTO dto) throws SQLException{
		
		con = DBCP.getConnection();
		
		String id = dto.getId();
		String pw = dto.getPw();
		String content = dto.getContent();
		int link = dto.getLink();
		
		String sql = "insert comment3 set id=?, pw=?, content=?, link=?";
		
		
		pstm = con.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.setString(2, pw);
		pstm.setString(3, content);
		pstm.setInt(4, link);
		
		int ret = pstm.executeUpdate();
		
		pstm.close();
		con.close();
		
		return ret == 1;
		
	}
	//댓글읽기
	public ArrayList<CommentDTO> read(int link) throws SQLException{
		
		System.out.println("링크번호 : " + link);
		
		con = DBCP.getConnection();
		
		String sql = "select id, content, reg_date from comment where link=? order by num";
		
		pstm = con.prepareStatement(sql);
		
		pstm.setInt(1, link);
		
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();
		
		try{
			while(rs.next()){
				
				CommentDTO dd = new CommentDTO();
				
				dd.setId(rs.getString(1));
				dd.setContent(rs.getString(2));
				dd.setReg_date(rs.getString(3));
				
				list.add(dd);
			}
		} catch(SQLException e){
			
			System.out.println("댓글읽기에러" + e.getMessage());
			 e.printStackTrace();
			 
		} finally{
			
			rs.close();
			pstm.close();
			con.close();
		}
		
		return list;				
	}
	
	public ArrayList<CommentDTO> read2(int link) throws SQLException{
		
		System.out.println("링크번호 : " + link);
		
		con = DBCP.getConnection();
		
		String sql = "select id, content, reg_date from comment2 where link=? order by num";
		
		pstm = con.prepareStatement(sql);
		
		pstm.setInt(1, link);
		
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();
		
		try{
			while(rs.next()){
				
				CommentDTO dd = new CommentDTO();
				
				dd.setId(rs.getString(1));
				dd.setContent(rs.getString(2));
				dd.setReg_date(rs.getString(3));
				
				list.add(dd);
			}
		} catch(SQLException e){
			
			System.out.println("댓글읽기에러" + e.getMessage());
			 e.printStackTrace();
			 
		} finally{
			
			rs.close();
			pstm.close();
			con.close();
		}
		
		return list;				
	}
	
	public ArrayList<CommentDTO> read3(int link) throws SQLException{
		
		System.out.println("링크번호 : " + link);
		
		con = DBCP.getConnection();
		
		String sql = "select id, content, reg_date from comment3 where link=? order by num";
		
		pstm = con.prepareStatement(sql);
		
		pstm.setInt(1, link);
		
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();
		
		try{
			while(rs.next()){
				
				CommentDTO dd = new CommentDTO();
				
				dd.setId(rs.getString(1));
				dd.setContent(rs.getString(2));
				dd.setReg_date(rs.getString(3));
				
				list.add(dd);
			}
		} catch(SQLException e){
			
			System.out.println("댓글읽기에러" + e.getMessage());
			 e.printStackTrace();
			 
		} finally{
			
			rs.close();
			pstm.close();
			con.close();
		}
		
		return list;				
	}
	
	//총 댓글
	public int countAll(int link) throws SQLException {
		
		con = DBCP.getConnection();
		
		String sql="select count(*) from comment where link=?";
		
		pstm=con.prepareStatement(sql);
		
		pstm.setInt(1, link);
		
		rs = pstm.executeQuery();
		
		rs.next();
		
		int count = rs.getInt("count(*)");
		
		rs.close();
		
		pstm.close();
		
		con.close();
		
		return count;
	}
	public int countAll2(int link) throws SQLException {
		
		con = DBCP.getConnection();
		
		String sql="select count(*) from comment2 where link=?";
		
		pstm=con.prepareStatement(sql);
		
		pstm.setInt(1, link);
		
		rs = pstm.executeQuery();
		
		rs.next();
		
		int count = rs.getInt("count(*)");
		
		rs.close();
		
		pstm.close();
		
		con.close();
		
		return count;
	}
	
	public int countAll3(int link) throws SQLException {
		
		con = DBCP.getConnection();
		
		String sql="select count(*) from comment3 where link=?";
		
		pstm=con.prepareStatement(sql);
		
		pstm.setInt(1, link);
		
		rs = pstm.executeQuery();
		
		rs.next();
		
		int count = rs.getInt("count(*)");
		
		rs.close();
		
		pstm.close();
		
		con.close();
		
		return count;
	}
	
	//댓글삭제
	public boolean del(String id) throws SQLException{
		
		System.out.println("dao id 들왔냐? : " + id);
		
		con = DBCP.getConnection();
		
		String sql = "delete from comment where id=?";

		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, id);
		
		ret = pstm.executeUpdate();
		
		pstm.close();
		
		con.close();
		
		return ret == 1;
	}
	
	public boolean del2(String id) throws SQLException{
		
		System.out.println("dao id 들왔냐? : " + id);
		
		con = DBCP.getConnection();
		
		String sql = "delete from comment2 where id=?";

		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, id);
		
		ret = pstm.executeUpdate();
		
		pstm.close();
		
		con.close();
		
		return ret == 1;
	}
	
	public boolean del3(String id) throws SQLException{
		
		System.out.println("dao id 들왔냐? : " + id);
		
		con = DBCP.getConnection();
		
		String sql = "delete from comment3 where id=?";

		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, id);
		
		ret = pstm.executeUpdate();
		
		pstm.close();
		
		con.close();
		
		return ret == 1;
	}
				
}
