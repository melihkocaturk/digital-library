package digital_library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProblemDbUtil {

	private static ProblemDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/digital_library";
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public static ProblemDbUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new ProblemDbUtil();
		}
		
		return instance;
	}
	
	private ProblemDbUtil() throws Exception {		
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		
		return theDataSource;
	}
		
	public List<Problem> getProblems() throws Exception {

		List<Problem> problems = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "SELECT * FROM problems ORDER BY id DESC";

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				int book_id = myRs.getInt("book_id");
				String content = myRs.getString("content");

				// create new problem object
				Problem problem = new Problem(id, book_id, content);

				// add it to the list of problems
				problems.add(problem);
			}
			
			return problems;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}

	public void addProblem(Problem theProblem) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "INSERT INTO problems (book_id, content) values (?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, theProblem.getBook_id());
			myStmt.setString(2, theProblem.getContent());
			
			myStmt.execute();			
		}
		finally {
			close (myConn, myStmt);
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
