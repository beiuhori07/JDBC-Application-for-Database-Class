package proiect_bd;

import java.sql.*;
import java.util.concurrent.Callable;


public class Model {
	static final String INITIAL_VALUE = "0";

	// private si gettere mai bine?
	public Connection con;
	public ResultSet rst;
	public ResultSetMetaData meta;
	public Statement stmt;
	public PreparedStatement pStmt;
	public CallableStatement cStmt;
	public int loginResult;

	Model() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (java.lang.ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: " + e);
		}

		final String url = "jdbc:mysql://localhost/proiect";
		final String uid = "user123";
		final String pw = "123";

		con = null;
		try {
			con = DriverManager.getConnection(url, uid, pw);
		}
		catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
			System.exit(1);
		}
		
		System.out.println("connection is good");

		try {
			stmt = con.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		this.loginResult = 0;	
	}
	
}
