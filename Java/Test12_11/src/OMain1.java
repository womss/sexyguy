
public class OMain1 {
	public static void main(String[] args) {
		
		
		
		
		Bookstore s1 = new Bookstore("문학서점", "서울 강남구", 22);
		Book b1 = new Book("자바의정석", "남궁성", 2,7, s1);
		
		b1.printbook();
		
		
		
	}
}
