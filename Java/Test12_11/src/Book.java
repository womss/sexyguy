
public class Book {
	String title;
	String author;
	int edition;
	int stock;
	Bookstore brand;
	
	public Book() {
	}

	public Book(String title, String author, int edition, int stock, Bookstore brand) {
		super();
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.stock = stock;
		this.brand = brand;
	}

	public void printbook() {
		System.out.printf("책의 이름은 %s이고 %d권까지 발행 되었으며, 작가는 %s입니다\n", title, edition, author);
		if (title != null) {
			System.out.printf("이 책은 다음 서점에서 판매하고 있고, 재고는 %d권입니다\n", stock);
		}
		brand.printStore();
	}
}
