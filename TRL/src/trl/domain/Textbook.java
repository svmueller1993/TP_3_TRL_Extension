package trl.domain;

public class Textbook {

	private String id;
	private String isbn;
	private String title;
	private String author;

	public Textbook(String id, String isbn, String title, String author) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Textbook [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + "]";
	}

}
