package digital_library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "bookController")
@SessionScoped
public class BookController  {
	private List<Book> books;
	private Book book;
	private BookDbUtil bookDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public BookController() throws Exception {
		books = new ArrayList<>();
		
		bookDbUtil = BookDbUtil.getInstance();
	}
	
	public List<Book> getBooks() {
		return books;
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
		
	public String addBook(Book theBook) {
		
		logger.info("Adding book: " + theBook);

		try {
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

	public String loadBook(int bookId) {
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
				
		return "update-book-form?faces-redirect=true";
	}	
	
	public String updateBook() {		
		try {
			// update book in the database
			bookDbUtil.updateBook(this.book);
			// logger.info("updating book: " + theBook);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating book: " + this.book, exc);
			
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
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}

