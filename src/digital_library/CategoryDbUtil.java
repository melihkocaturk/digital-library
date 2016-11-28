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

public class CategoryDbUtil {

	private static CategoryDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/digital_library";
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public static CategoryDbUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new CategoryDbUtil();
		}
		
		return instance;
	}
	
	private CategoryDbUtil() throws Exception {		
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		
		return theDataSource;
	}
		
	public List<Category> getCategories() throws Exception {

		List<Category> categories = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "SELECT * FROM categories ORDER BY id DESC";

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("name");

				// create new category object
				Category category = new Category(id, name);

				// add it to the list of categories
				categories.add(category);
			}
			
			return categories;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}

	public void addCategory(Category theCategory) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "INSERT INTO categories (name) values (?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theCategory.getName());
			
			myStmt.execute();			
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	
	public Category getCategory(int categoryId) throws Exception {
	
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "SELECT * FROM categories WHERE id=?";

			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, categoryId);
			
			myRs = myStmt.executeQuery();

			Category theCategory = null;
			
			// retrieve data from result set row
			if (myRs.next()) {
				int id = myRs.getInt("id");
				String name = myRs.getString("name");

				theCategory = new Category(id, name);
			}
			else {
				throw new Exception("Could not find category id: " + categoryId);
			}

			return theCategory;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
	
	public void updateCategory(Category theCategory) throws Exception {
		logger.info("theCategory: " + theCategory);
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "UPDATE categories "
						+ " SET name=?"
						+ " WHERE id=?";

			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theCategory.getName());
			myStmt.setInt(2, theCategory.getId());
			
			myStmt.execute();
			
			logger.info("myStmt: " + myStmt.toString());
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	
	public void deleteCategory(int categoryId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "DELETE FROM categories WHERE id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, categoryId);
			
			myStmt.execute();
		}
		finally {
			close (myConn, myStmt);
		}		
	}
	
	public List<Book> getBooks(int categoryId) throws Exception {

		List<Book> books = new ArrayList<>();

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "SELECT * FROM books WHERE category_id=? ORDER BY id DESC";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, categoryId);

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
