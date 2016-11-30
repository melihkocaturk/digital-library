package digital_library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginDbUtil {
	private static LoginDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/digital_library";
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public static LoginDbUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new LoginDbUtil();
		}
		
		return instance;
	}
	
	private LoginDbUtil() throws Exception {		
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		
		return theDataSource;
	}
	
	public boolean validate(String username, String password) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "SELECT * FROM users WHERE username=? AND password=?";

			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		finally {
			close (myConn, myStmt, myRs);
		}		
		
	}
	
	private Connection getConnection() throws Exception {

		Connection theConn = dataSource.getConnection();
		
		return theConn;
	}
	
	private void close(Connection theConn, Statement theStmt) {
		close(theConn, theStmt, null);
	}
	
	private void close(Connection theConn, Statement theStmt, ResultSet theRs) {

		try {
			if (theRs != null) {
				theRs.close();
			}

			if (theStmt != null) {
				theStmt.close();
			}

			if (theConn != null) {
				theConn.close();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
