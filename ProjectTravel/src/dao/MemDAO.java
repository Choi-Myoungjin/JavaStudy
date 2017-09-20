package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.PageIn;
import dto.MemDTOIn;

public class MemDAO {

	
	public Connection con;
	
	public PreparedStatement pstm;
	
	public int ret;
	
	ResultSet rs;
	
	public Statement stm;

	//회원가입//
	public boolean reg(MemDTOIn dto) throws SQLException {

		String id = dto.getId();
		String pw = dto.getPw();
		String phone = dto.getPhone();

		con = DBCP.getConnection();

		String sql = "insert into member set id=?, pw=sha1(?), phone=?, reg_date=now();";

		pstm = con.prepareStatement(sql);

		pstm.setString(1, id);
		pstm.setString(2, pw);
		pstm.setString(3, phone);
		
		ret = pstm.executeUpdate();
		
		pstm.close();
		con.close();
		
		return ret == 1;
		
	}
	
	//로그인//
	public boolean login(String id, String pw) throws SQLException {
		
		System.out.println("MemDAO id : "+ id);
		System.out.println("MemDAO pw : "+ pw);
		
		con = DBCP.getConnection();
	
		String sql = "select * from member where id=? and pw=sha1(?)";
		
		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, id);
		pstm.setString(2, pw);
		
		System.out.println("login:sql=" + sql);
		
		ResultSet rs = pstm.executeQuery();
		
		if (rs.next() == true) {
			
			rs.close();
			pstm.close();
			con.close();
			
			return true;

		} else {
			
			rs.close();
			pstm.close();
			con.close();
			
			return false;
		}

	}
	
	//회원 정보 가져오기
	public MemDTOIn memberInfo(String id) throws SQLException{
		
		System.out.println("id :" + id);
		
		con = DBCP.getConnection();
		
		String sql = "select pw, phone, reg_date, name, info, photo from member where id=?";
		
		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, id);
		
		rs = pstm.executeQuery();
		
		MemDTOIn dto = new MemDTOIn();
		
		if(rs.next()) {
			
			dto.setPw(rs.getString("pw"));
			dto.setPhone(rs.getString("phone"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setName(rs.getString("name"));
			dto.setInfo(rs.getString("info"));
			dto.setPhoto(rs.getString("photo"));
			
			rs.close();
			pstm.close();
			con.close();
			
			return dto;
			
		}else {
			
			rs.close();
			pstm.close();
			con.close();
			
			return null;
		}
	}
	
	//회원정보수정		
	public boolean memUpdate(MemDTOIn dto) throws SQLException{
		
		con = DBCP.getConnection();
		
		String sql = "update member set name=?, info=?, photo=?, phone=? where id=?";
		
		String name = dto.getName();
		String info = dto.getInfo();
		String photo = dto.getPhoto();
		String phone = dto.getPhone();
		String id = dto.getId();
		
		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, name);
		pstm.setString(2, info);
		pstm.setString(3, photo);
		pstm.setString(4, phone);
		pstm.setString(5, id);
		
		ret = pstm.executeUpdate();
		
		pstm.close();
		
		con.close();
		
		return ret == 1;
		
	}
	
	
	//레벨 가져오기
	public int lv(String id) throws SQLException{
		
		System.out.println("id :" + id);
		
		int lv = 0;
		con = DBCP.getConnection();
		
		String sql = "select lv from member where id=?";
		
		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, id);
		
		rs = pstm.executeQuery();
		
		if(rs.next()) {
			lv = rs.getInt("lv");
		}
				
		rs.close();
		pstm.close();
		con.close();
		
		return lv;
		
	}
	
		// 아이디 중복체크
		public boolean idcheck(String id) throws SQLException {
			
			System.out.println("MemDAO id : "+ id);
			
			con = DBCP.getConnection();
			
			String sql = "select id from member where id=?";

			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, id);
			
			System.out.println("sql : " + sql);

			ResultSet rs = pstm.executeQuery();
			
			
			if (rs.isBeforeFirst()) {
				System.out.println("아이디있다");
				
				rs.close();
				pstm.close();
				con.close();		
				
				return true;
				
			} else {
				System.out.println("아이디없다");
				
				rs.close();
				pstm.close();
				con.close();
				
				return false;
			}

		}
		
	// 회원탈퇴 
		public boolean del(String id) throws SQLException {
			
			System.out.println("id : "+ id);

			con = DBCP.getConnection();
			
			String sql = "delete from member where id =?";

			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, id);
			
			ret = pstm.executeUpdate();
			
			pstm.close();
			
			con.close();
			
			return ret == 1;
			
		}
	
	//amdin 페이지
	  
		public ArrayList<MemDTOIn> getMemberlist(PageIn dto) throws SQLException{
			
			int pageNo = dto.getPageNo();
			int pageSize = dto.getPageSize();
			
			int start = pageNo * pageSize;
			
			con = DBCP.getConnection();
			
			String sql = "select * from member order by id desc limit ?, ?";

			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, start);
			pstm.setInt(2, pageSize);
			
			System.out.println("sql : " + sql);
			

			ResultSet rs = pstm.executeQuery();
			
	        ArrayList<MemDTOIn> list = new ArrayList<MemDTOIn>();
	       
	        try{
	        	           
	            while(rs.next()){
	            	MemDTOIn vo = new MemDTOIn();
	               
	                vo.setId(rs.getString(1));
	                vo.setPw(rs.getString(2));
	                vo.setPhone(rs.getString(3));
	                vo.setReg_date(rs.getString(4));
	                vo.setLv(rs.getInt(5));
	                
	                list.add(vo);
	            }
	        }catch(Exception e){          
	            System.out.println("에러 : " + e.getMessage());        
	        } finally {
	        	rs.close();
	        	pstm.close();
	        	con.close();
	        }
	        
	        
	        return list;
	        
	    }
		
	//count ID
		public int countAll() throws SQLException{
			
			con = DBCP.getConnection();
			
			String sql="select count(*) from member";
			
			pstm=con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			rs.next();
			
			int count = rs.getInt("count(*)");
			rs.close();
			
			pstm.close();
			
			con.close();
			
			return count;
		}
		
	//levelup
		public void levelup(int lv, String id) throws SQLException{

			con = DBCP.getConnection();
			
			String sql = "update member set lv=? where id=?";

			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, lv);
			pstm.setString(2, id);
			
			ret = pstm.executeUpdate();
			
			pstm.close();
			
			con.close();
			
		}
	//search
		
		public ArrayList<MemDTOIn> getMemberlist1(PageIn dto) throws SQLException{
			
			int pageNo = dto.getPageNo();
			int pageSize = dto.getPageSize();
			
			int start = pageNo * pageSize;
			
			String word = dto.getWord();
			
			con = DBCP.getConnection();
			
			
			String sql = "select * from member where id like ?";

			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, "%"+word+"%");
			
			
			System.out.println("sql : " + sql);
			
			rs = pstm.executeQuery();
			
	        ArrayList<MemDTOIn> list = new ArrayList<MemDTOIn>();
	        
	        try{
 	           
	            while(rs.next()){
	            	MemDTOIn vo = new MemDTOIn();
	               
	                vo.setId(rs.getString(1));
	                vo.setPw(rs.getString(2));
	                vo.setPhone(rs.getString(3));
	                vo.setReg_date(rs.getString(4));
	                vo.setLv(rs.getInt(5));
	                
	                list.add(vo);
	            }
	            
	        }catch(Exception e){   
	        	
	            System.out.println("에러 : " + e.getMessage());
	            
	        } finally {
	        	rs.close();
	        	pstm.close();
	        	con.close();
	        }
	        
	        
	        return list;
			
		}
}
