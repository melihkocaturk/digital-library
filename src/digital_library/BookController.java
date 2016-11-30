package digital_library;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
// import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
// import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

@ManagedBean(name = "bookController")
@SessionScoped
public class BookController {
	private List<Book> books;
	private List<Book> search;
	private List<Comment> comments;
	private String keyword;
	private Book book;
	private BookDbUtil bookDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	final String filedir = "E:\\workspace\\DigitalLibrary\\WebContent\\resources\\uploads\\";
	
	public BookController() throws Exception {
		books = new ArrayList<>();
		search = new ArrayList<>();
		comments = new ArrayList<>();
		
		bookDbUtil = BookDbUtil.getInstance();
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public List<Book> getSearch() {
		return search;
	}

	public void loadBooks() {
		
		logger.info("Loading books");
		books.clear();

		try {
			// get all books from database
			books = bookDbUtil.getBooks();
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading books", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
		
	}
	
	public String searchBook(String keyword) {
		
		logger.info("Search book");
		search.clear();

		try {
			// search book from database
			search = bookDbUtil.searchBook(keyword);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading search results", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "search?faces-redirect=true";
		
	}
		
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String addBook(Book theBook) {
		
		logger.info("Adding book: " + theBook);

		try {
			// upload book image			
			String image = getFileName(theBook.getImagePart());
			
		    try (InputStream input = theBook.getImagePart().getInputStream()) {
		        Files.copy(input, new File(filedir + "image\\", image).toPath());
		    }
		    
		    theBook.setImage(image);
		    
		    // upload book pdf		    
		    String pdf = getFileName(theBook.getPdfPart());
			
		    try (InputStream input = theBook.getPdfPart().getInputStream()) {
		        Files.copy(input, new File(filedir + "pdf\\", pdf).toPath());
		    }
		    
		    theBook.setPdf(pdf);
		    
			// add book to the database
			bookDbUtil.addBook(theBook);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding books", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		
		return "books?faces-redirect=true";
	}

	public String loadBook(int bookId, String url) {
		logger.info("loading book: " + bookId);
		
		try {
			// get book from database
			Book theBook = bookDbUtil.getBook(bookId);
			this.setBook(theBook);
			
			logger.info("loading book: " + this.book);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading book id:" + bookId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
				
		return url + "?faces-redirect=true";
	}
	
	public String updateBook() {
		Book theBook = this.book;
		
		try {			
			// upload book image
			if (theBook.getImagePart() != null) {
				String image = getFileName(theBook.getImagePart());
			
			    try (InputStream input = theBook.getImagePart().getInputStream()) {
			        Files.copy(input, new File(filedir + "image\\", image).toPath());
			    }
			    
			    theBook.setImage(image);
			}		    
		    
		    // upload book pdf
			if (theBook.getPdfPart() != null) {
				String pdf = getFileName(theBook.getPdfPart());
			
			    try (InputStream input = theBook.getPdfPart().getInputStream()) {
			        Files.copy(input, new File(filedir + "pdf\\", pdf).toPath());
			    }
			    
			    theBook.setPdf(pdf);
		    }
		    
			// update book in the database
			bookDbUtil.updateBook(theBook);
			// logger.info("updating book: " + theBook);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating book: " + theBook, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "books?faces-redirect=true";		
	}
	
	public String deleteBook(int bookId) {
		logger.info("Deleting book id: " + bookId);
		
		try {
			// delete the book from the database
			bookDbUtil.deleteBook(bookId);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting book id: " + bookId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "books";	
	}
	
	public void loadComments(int bookId) {
		
		logger.info("Loading comments");
		comments.clear();

		try {
			// get all comments from database
			comments = bookDbUtil.getComments(bookId);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading comments", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
		
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public List<Comment> getComments() {
		return comments;
	}	
	
	private String getFileName(Part part) {
		String header = part.getHeader("content-disposition");
	    
	    for (String content : header.split(";")) {
	        if (content.trim().startsWith("filename")) {
	        	String path = content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
	            return path.substring(path.lastIndexOf("\\") + 1);
	        }
	    }
	    
	    return null;
	}
	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}

