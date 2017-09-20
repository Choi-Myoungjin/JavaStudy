package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.BoardDTO;

public class BoardDAO {

	public Connection con;

	public PreparedStatement pstm;

	public int ret;

	ResultSet rs;

	public Statement stm;

	public ArrayList<BoardDTO> trip1() throws SQLException {

		System.out.println("BoardDAO : 여기들어왔닝?");

		con = DBCP.getConnection();

		String sql = "select name, photo, num from board order by reg_date desc";

		pstm = con.prepareStatement(sql);

		rs = pstm.executeQuery();

		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		try {
			while (rs.next()) {

				BoardDTO vo = new BoardDTO();

				vo.setName(rs.getString(1));
				vo.setPhoto(rs.getString(2));
				vo.setNum(rs.getInt(3));

				list.add(vo);
			}
		} catch (Exception e) {

			System.out.println("에러 : " + e.getMessage());

		} finally {
			rs.close();
			pstm.close();
			con.close();
		}

		return list;
	}

	public ArrayList<BoardDTO> trip2() throws SQLException {

		System.out.println("BoardDAO 222: 여기들어왔닝?");

		con = DBCP.getConnection();

		String sql = "select name, photo, num from board1 order by reg_date desc";

		pstm = con.prepareStatement(sql);

		rs = pstm.executeQuery();

		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		try {
			while (rs.next()) {

				BoardDTO vo = new BoardDTO();

				vo.setName(rs.getString(1));
				vo.setPhoto(rs.getString(2));
				vo.setNum(rs.getInt(3));

				list.add(vo);
			}
		} catch (Exception e) {

			System.out.println("에러 : " + e.getMessage());

		} finally {
			rs.close();
			pstm.close();
			con.close();
		}

		return list;
	}

	public ArrayList<BoardDTO> trip3() throws SQLException {

		System.out.println("BoardDAO 333: 여기들어왔닝?");

		con = DBCP.getConnection();

		String sql = "select name, photo, num from board2 order by reg_date desc";

		pstm = con.prepareStatement(sql);

		rs = pstm.executeQuery();

		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		try {
			while (rs.next()) {

				BoardDTO vo = new BoardDTO();

				vo.setName(rs.getString(1));
				vo.setPhoto(rs.getString(2));
				vo.setNum(rs.getInt(3));

				list.add(vo);
			}
		} catch (Exception e) {

			System.out.println("에러 : " + e.getMessage());

		} finally {
			rs.close();
			pstm.close();
			con.close();
		}

		return list;
	}

	public BoardDTO tripread(int num) throws SQLException {

		System.out.println("Board 읽기 여기들어왔나?");

		BoardDTO dto = new BoardDTO();

		con = DBCP.getConnection();

		String sql = "select name, content, reg_date, photo, map, num from board where num=?";

		pstm = con.prepareStatement(sql);

		pstm.setInt(1, num);

		rs = pstm.executeQuery();

		if (rs.next()) {

			dto.setName(rs.getString("name"));
			dto.setContent(rs.getString("content"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setPhoto(rs.getString("photo"));
			dto.setMap(rs.getString("map"));
			dto.setNum(rs.getInt("num"));

			rs.close();
			pstm.close();
			con.close();

			return dto;

		} else {

			rs.close();
			pstm.close();
			con.close();

			return null;
		}

	}
	
	public BoardDTO tripread2(int num) throws SQLException {

		System.out.println("Board2 읽기 여기들어왔나?");

		BoardDTO dto = new BoardDTO();

		con = DBCP.getConnection();

		String sql = "select name, content, reg_date, photo, map, num from board1 where num=?";

		pstm = con.prepareStatement(sql);

		pstm.setInt(1, num);

		rs = pstm.executeQuery();

		if (rs.next()) {

			dto.setName(rs.getString("name"));
			dto.setContent(rs.getString("content"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setPhoto(rs.getString("photo"));
			dto.setMap(rs.getString("map"));
			dto.setNum(rs.getInt("num"));

			rs.close();
			pstm.close();
			con.close();

			return dto;

		} else {

			rs.close();
			pstm.close();
			con.close();

			return null;
		}

	}
	
	public BoardDTO tripread3(int num) throws SQLException {

		System.out.println("Board3 읽기 여기들어왔나?");

		BoardDTO dto = new BoardDTO();

		con = DBCP.getConnection();

		String sql = "select name, content, reg_date, photo, map, num from board2 where num=?";

		pstm = con.prepareStatement(sql);

		pstm.setInt(1, num);

		rs = pstm.executeQuery();

		if (rs.next()) {

			dto.setName(rs.getString("name"));
			dto.setContent(rs.getString("content"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setPhoto(rs.getString("photo"));
			dto.setMap(rs.getString("map"));
			dto.setNum(rs.getInt("num"));

			rs.close();
			pstm.close();
			con.close();

			return dto;

		} else {

			rs.close();
			pstm.close();
			con.close();

			return null;
		}

	}

	public boolean write(BoardDTO dto) throws SQLException {

		con = DBCP.getConnection();

		String sql = "insert into board set name=?, content=?, photo=?, map=?";

		String name = dto.getName();
		String content = dto.getContent();
		String photo = dto.getPhoto();
		String map = dto.getMap();

		pstm = con.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setString(2, content);
		pstm.setString(3, photo);
		pstm.setString(4, map);

		int ret = pstm.executeUpdate();

		pstm.close();
		con.close();

		if (ret == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean write2(BoardDTO dto) throws SQLException {

		con = DBCP.getConnection();

		String sql = "insert into board1 set name=?, content=?, photo=?, map=?";

		String name = dto.getName();
		String content = dto.getContent();
		String photo = dto.getPhoto();
		String map = dto.getMap();

		pstm = con.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setString(2, content);
		pstm.setString(3, photo);
		pstm.setString(4, map);

		int ret = pstm.executeUpdate();

		pstm.close();
		con.close();

		if (ret == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean write3(BoardDTO dto) throws SQLException {

		con = DBCP.getConnection();

		String sql = "insert into board2 set name=?, content=?, photo=?, map=?";

		String name = dto.getName();
		String content = dto.getContent();
		String photo = dto.getPhoto();
		String map = dto.getMap();

		pstm = con.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setString(2, content);
		pstm.setString(3, photo);
		pstm.setString(4, map);

		int ret = pstm.executeUpdate();

		pstm.close();
		con.close();

		if (ret == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean del(int num) throws SQLException {

		System.out.println("daodel num 들왔냐? : " + num);

		con = DBCP.getConnection();

		String sql = "delete from board where num=?";

		pstm = con.prepareStatement(sql);

		pstm.setInt(1, num);

		ret = pstm.executeUpdate();

		pstm.close();

		con.close();

		return ret == 1;

	}
	
	public boolean del2(int num) throws SQLException {

		System.out.println("daodel2 num 들왔냐? : " + num);

		con = DBCP.getConnection();

		String sql = "delete from board1 where num=?";

		pstm = con.prepareStatement(sql);

		pstm.setInt(1, num);

		ret = pstm.executeUpdate();

		pstm.close();

		con.close();

		return ret == 1;

	}
	
	public boolean del3(int num) throws SQLException {

		System.out.println("daodel3 num 들왔냐? : " + num);

		con = DBCP.getConnection();

		String sql = "delete from board2 where num=?";

		pstm = con.prepareStatement(sql);

		pstm.setInt(1, num);

		ret = pstm.executeUpdate();

		pstm.close();

		con.close();

		return ret == 1;

	}

	public boolean update(BoardDTO dto) throws SQLException {

		con = DBCP.getConnection();

		String sql = "update board set name=?, content=?, map=?, photo=? where num=?";

		String name = dto.getName();
		String content = dto.getContent();
		String map = dto.getMap();
		String photo = dto.getPhoto();
		int num = dto.getNum();

		pstm = con.prepareStatement(sql);

		pstm.setString(1, name);
		pstm.setString(2, content);
		pstm.setString(3, map);
		pstm.setString(4, photo);
		pstm.setInt(5, num);

		ret = pstm.executeUpdate();

		pstm.close();

		con.close();

		return ret == 1;
	}
	
	public boolean update2(BoardDTO dto) throws SQLException {

		con = DBCP.getConnection();

		String sql = "update board1 set name=?, content=?, map=?, photo=? where num=?";

		String name = dto.getName();
		String content = dto.getContent();
		String map = dto.getMap();
		String photo = dto.getPhoto();
		int num = dto.getNum();

		pstm = con.prepareStatement(sql);

		pstm.setString(1, name);
		pstm.setString(2, content);
		pstm.setString(3, map);
		pstm.setString(4, photo);
		pstm.setInt(5, num);

		ret = pstm.executeUpdate();

		pstm.close();

		con.close();

		return ret == 1;
	}
	
	public boolean update3(BoardDTO dto) throws SQLException {

		con = DBCP.getConnection();

		String sql = "update board2 set name=?, content=?, map=?, photo=? where num=?";

		String name = dto.getName();
		String content = dto.getContent();
		String map = dto.getMap();
		String photo = dto.getPhoto();
		int num = dto.getNum();

		pstm = con.prepareStatement(sql);

		pstm.setString(1, name);
		pstm.setString(2, content);
		pstm.setString(3, map);
		pstm.setString(4, photo);
		pstm.setInt(5, num);

		ret = pstm.executeUpdate();

		pstm.close();

		con.close();

		return ret == 1;
	}
}
