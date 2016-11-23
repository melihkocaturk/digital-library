package digital_library;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

@ManagedBean(name = "book")
public class Book {
	private int id;
	private int category_id;
	private String title;
	private String description;
	private String author;
	private Part imagePart;
	private Part pdfPart;
	private String image;
	private String pdf;
	
	public Book() {
	}
	
	public Book(int id, int category_id, String title, String description, String author, String image, String pdf) {
		this.id = id;
		this.category_id = category_id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.image = image;
		this.pdf = pdf;
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

	public Part getImagePart() {
		return imagePart;
	}

	public void setImagePart(Part imagePart) {
		this.imagePart = imagePart;
	}

	public Part getPdfPart() {
		return pdfPart;
	}

	public void setPdfPart(Part pdfPart) {
		this.pdfPart = pdfPart;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", category_id=" + category_id + ", title=" + title + ", description="
				+ description + ", author=" + author + ", image=" + image + ", pdf=" + pdf + "]";
	}
}
