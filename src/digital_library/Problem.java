package digital_library;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "problem")
public class Problem {
	private int id;
	private int book_id;
	private String content;

	public Problem() {
	}
	
	public Problem(int id, int book_id, String content) {
		this.id = id;
		this.book_id = book_id;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBook_id() {
		return book_id;
	}
	
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Problem [id=" + id + ", book_id=" + book_id + ", content=" + content + "]";
	}
	
}
