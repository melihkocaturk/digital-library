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

@ManagedBean(name = "problemController")
@SessionScoped
public class ProblemController {
	private List<Problem> problems;
	private Problem problem;
	private ProblemDbUtil problemDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public ProblemController() throws Exception {
		problems = new ArrayList<>();
		
		problemDbUtil = ProblemDbUtil.getInstance();
	}
	
	public List<Problem> getProblems() {
		return problems;
	}

	public void loadProblems() {
		
		logger.info("Loading problems");
		problems.clear();

		try {
			// get all problems from database
			problems = problemDbUtil.getProblems();
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading problems", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
		
	}
	
	public String addProblem(Problem theProblem, int book_id) {
		
		logger.info("Adding problem: " + theProblem);

		try {
			// add problem to the database
			theProblem.setBook_id(book_id);
			
			problemDbUtil.addProblem(theProblem);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding problems", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		
		return "index?faces-redirect=true";
	}
	
	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}

