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
			
			logger.info("theBook: " + theBook);
			
			// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();	

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("book", theBook);
			
			logger.info("requestMap: " + requestMap);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading book id:" + bookId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
				
		return "update-book-form.xhtml";
	}	
	
	public String updateBook(Book theBook) {
		// logger.info("updating book: " + theBook);
		
		/*
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		logger.info("requestMap: " + requestMap);
		*/
		
		try {
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
	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}

