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

public class BookDbUtil {

	private static BookDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/digital_library";
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public static BookDbUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new BookDbUtil();
		}
		
		return instance;
	}
	
	private BookDbUtil() throws Exception {		
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		
		return theDataSource;
	}
		
	public List<Book> getBooks() throws Exception {

		List<Book> books = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "SELECT * FROM books ORDER BY id DESC";

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				int category_id = myRs.getInt("category_id");
				String title = myRs.getString("title");
				String description = myRs.getString("description");
				String author = myRs.getString("author");
				String image = myRs.getString("image");
				String pdf = myRs.getString("pdf");

				// create new book object
				Book book = new Book(id, category_id, title, description, author, image, pdf);

				// add it to the list of books
				books.add(book);
			}
			
			return books;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
	
	public List<Book> searchBook(String keyword) throws Exception {
		logger.info("keyword: " + keyword);
		
		List<Book> books = new ArrayList<>();

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "SELECT * FROM books WHERE title LIKE ? ORDER BY id DESC";

			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, "%" + keyword + "%");

			myRs = myStmt.executeQuery();
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				int category_id = myRs.getInt("category_id");
				String title = myRs.getString("title");
				String description = myRs.getString("description");
				String author = myRs.getString("author");
				String image = myRs.getString("image");
				String pdf = myRs.getString("pdf");

				// create new book object
				Book book = new Book(id, category_id, title, description, author, image, pdf);

				// add it to the list of books
				books.add(book);
			}
			
			return books;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}

	public void addBook(Book theBook) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "INSERT INTO books (category_id, title, description, author, image, pdf) values (?, ?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, theBook.getCategory_id());
			myStmt.setString(2, theBook.getTitle());
			myStmt.setString(3, theBook.getDescription());
			myStmt.setString(4, theBook.getAuthor());
			myStmt.setString(5, theBook.getImage());
			myStmt.setString(6, theBook.getPdf());
			
			myStmt.execute();			
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	
	public Book getBook(int bookId) throws Exception {
	
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "SELECT * FROM books WHERE id=?";

			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, bookId);
			
			myRs = myStmt.executeQuery();

			Book theBook = null;
			
			// retrieve data from result set row
			if (myRs.next()) {
				int id = myRs.getInt("id");
				int category_id = myRs.getInt("category_id");
				String title = myRs.getString("title");
				String description = myRs.getString("description");
				String author = myRs.getString("author");
				String image = myRs.getString("image");
				String pdf = myRs.getString("pdf");

				theBook = new Book(id, category_id, title, description, author, image, pdf);
			}
			else {
				throw new Exception("Could not find book id: " + bookId);
			}

			return theBook;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
	
	public void updateBook(Book theBook) throws Exception {
		logger.info("theBook: " + theBook);
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "UPDATE books "
						+ " SET category_id=?, title=?, description=?, author=?, image=?, pdf=?"
						+ " WHERE id=?";

			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, theBook.getCategory_id());
			myStmt.setString(2, theBook.getTitle());
			myStmt.setString(3, theBook.getDescription());
			myStmt.setString(4, theBook.getAuthor());
			myStmt.setString(5, theBook.getImage());
			myStmt.setString(6, theBook.getPdf());
			myStmt.setInt(7, theBook.getId());
			
			myStmt.execute();
			
			logger.info("myStmt: " + myStmt.toString());
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	
	public void deleteBook(int bookId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "DELETE FROM books WHERE id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, bookId);
			
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
