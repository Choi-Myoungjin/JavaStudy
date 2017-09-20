package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCP {

	public static Connection getConnection() {

		Context context = null;
		DataSource dataSource = null;
		Connection con  = null;

		try {
			
			context = new InitialContext();
			
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/MyConn");
			
			con = dataSource.getConnection();

		} catch (NamingException e) {

			System.out.println("네이밍 에러 : " + e.getMessage());
			
		} catch (SQLException e) {
			
			System.out.println("sql 에러 : "+ e.getMessage());
		}

		return con;

	}
}
