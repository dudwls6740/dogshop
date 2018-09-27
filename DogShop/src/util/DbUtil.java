package util;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

public class DbUtil {
	/*
	 * static{ try{ Class.forName("oracle.jdbc.driver.OracleDriver"); //Class :
	 * 자바API에서 제공되는 클래스 //forName : 파라미터로 지정된 클래스를 인스턴스 메모리에 올리는 역할을 하는 메소드 //쉽게 말하면
	 * 오라클과 에플리케이션이 연동하기 위해 오라클 드라이버를 메모리로 올리는 부분. } catch(ClassNotFoundException
	 * e){ e.printStackTrace(); } } public static Connection getConnection(){
	 * Connection con=null; try{ con = DriverManager.
	 * getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java","java");
	 * con.setAutoCommit(false); } catch(SQLException e){ e.printStackTrace(); }
	 * return con; }
	 */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class : 자바API에서 제공되는 클래스
			// forName : 파라미터로 지정된 클래스를 인스턴스 메모리에 올리는 역할을 하는 메소드
			// 쉽게 말하면 오라클과 에플리케이션이 연동하기 위해 오라클 드라이버를 메모리로 올리는 부분.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/dog");
			con = dataFactory.getConnection();
			con.setAutoCommit(false);

		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			System.out.println("commit fail");
		}
	}

	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			System.out.println("rollback fail");
		}
	}
}
