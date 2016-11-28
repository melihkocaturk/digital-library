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

@ManagedBean(name = "categoryController")
@SessionScoped
public class CategoryController {
	private List<Category> categories;
	private List<Book> books;
	private Category category;
	private CategoryDbUtil categoryDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public CategoryController() throws Exception {
		categories = new ArrayList<>();
		books = new ArrayList<>();
		
		categoryDbUtil = CategoryDbUtil.getInstance();
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void loadCategories() {
		
		logger.info("Loading categories");
		categories.clear();

		try {
			// get all categories from database
			categories = categoryDbUtil.getCategories();
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading categories", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
		
	}
		
	public String addCategory(Category theCategory) {
		
		logger.info("Adding category: " + theCategory);

		try {
			// add category to the database
			categoryDbUtil.addCategory(theCategory);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding categories", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		
		return "categories?faces-redirect=true";
	}

	public String loadCategory(int categoryId, String url) {
		logger.info("loading category: " + categoryId);
		
		try {
			// get category from database
			Category theCategory = categoryDbUtil.getCategory(categoryId);
			this.setCategory(theCategory);
			
			logger.info("loading category: " + this.category);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading category id:" + categoryId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
				
		return url + "?faces-redirect=true";
	}	
	
	public String updateCategory() {		
		try {
			// update category in the database
			categoryDbUtil.updateCategory(this.category);
			// logger.info("updating category: " + theCategory);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating category: " + this.category, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "categories?faces-redirect=true";		
	}
	
	public String deleteCategory(int categoryId) {
		logger.info("Deleting category id: " + categoryId);
		
		try {
			// delete the category from the database
			categoryDbUtil.deleteCategory(categoryId);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting category id: " + categoryId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "categories";	
	}	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void loadBooks(int categoryId) {
		
		logger.info("Loading books");
		books.clear();

		try {
			// get categories books from database
			books = categoryDbUtil.getBooks(categoryId);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading books", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
		
	}
	
	public List<Book> getBooks() {
		return books;
	}	

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}

