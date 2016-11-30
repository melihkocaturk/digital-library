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

public class CommentDbUtil {

	private static CommentDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/digital_library";
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public static CommentDbUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new CommentDbUtil();
		}
		
		return instance;
	}
	
	private CommentDbUtil() throws Exception {		
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		
		return theDataSource;
	}
		
	public List<Comment> getComments() throws Exception {

		List<Comment> comments = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "SELECT * FROM comments ORDER BY id DESC";

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				int book_id = myRs.getInt("book_id");
				String title = myRs.getString("title");
				String content = myRs.getString("content");

				// create new comment object
				Comment comment = new Comment(id, book_id, title, content);

				// add it to the list of comments
				comments.add(comment);
			}
			
			return comments;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}

	public void addComment(Comment theComment) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "INSERT INTO comments (book_id, title, content) values (?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, theComment.getBook_id());
			myStmt.setString(2, theComment.getTitle());
			myStmt.setString(3, theComment.getContent());
			
			myStmt.execute();			
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
		
	public void deleteComment(int commentId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "DELETE FROM comments WHERE id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, commentId);
			
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
