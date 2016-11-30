package digital_library;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "comment")
public class Comment {
	private int id;
	private int book_id;
	private String title;
	private String content;

	public Comment() {
	}
	
	public Comment(int id, int book_id, String title, String content) {
		this.id = id;
		this.book_id = book_id;
		this.title = title;
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
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", book_id=" + book_id + ", title=" + title + ", content=" + content + "]";
	}
	
}
