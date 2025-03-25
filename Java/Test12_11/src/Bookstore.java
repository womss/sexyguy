
public class Bookstore {
	String name;
	String location;
	int close;
	
	public Bookstore() {
	}

	
	
	public Bookstore(String name, String location, int close) {
		this.name = name;
		this.location = location;
		this.close = close;
	}



	public void printStore() {
		System.out.printf("서점의 이름은 %s이고, 위치는 %s 닫는 시간은 %d시 입니다\n", name, location, close);
	}
}
