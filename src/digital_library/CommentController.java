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

@ManagedBean(name = "commentController")
@SessionScoped
public class CommentController {
	private List<Comment> comments;
	private Comment comment;
	private CommentDbUtil commentDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public CommentController() throws Exception {
		comments = new ArrayList<>();
		
		commentDbUtil = CommentDbUtil.getInstance();
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void loadComments() {
		
		logger.info("Loading comments");
		comments.clear();

		try {
			// get all comments from database
			comments = commentDbUtil.getComments();
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading comments", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
		
	}
	
	public String addComment(Comment theComment, int book_id) {
		
		logger.info("Adding comment: " + theComment);

		try {
			// add comment to the database
			theComment.setBook_id(book_id);
			
			commentDbUtil.addComment(theComment);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding comments", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		
		return "index?faces-redirect=true";
	}
	
	public String deleteComment(int commentId) {
		logger.info("Deleting comment id: " + commentId);
		
		try {
			// delete the comment from the database
			commentDbUtil.deleteComment(commentId);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting comment id: " + commentId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "comments";	
	}
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}

