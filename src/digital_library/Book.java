package digital_library;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "book")
public class Book {
	private int id;
	private int category_id;
	private String title;
	private String description;
	private String author;
	
	public Book() {
	}
	
	public Book(int id, int category_id, String title, String description, String author) {
		this.id = id;
		this.category_id = category_id;
		this.title = title;
		this.description = description;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", category_id=" + category_id + ", title=" + title + ", description="
				+ description + ", author=" + author + "]";
	}
}
