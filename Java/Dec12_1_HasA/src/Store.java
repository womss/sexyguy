
public class Store {
	String name;
	String location;
	int tellNum;
	Person owner;
	
	public Store() {
	}

	public Store(String name, String location, int tellNum, Person oner) {
		this.name = name;
		this.location = location;
		this.tellNum = tellNum;
		this.owner = oner;
	}
	
	public void printStore() {
		System.out.printf("식당의 이름은 %s이고, 위치는 %s 매장 번호는 02%d입니다\n", name, location, tellNum);
		if (name != null) {
			System.out.println("아래는 해당 식당의 주인 정보입니다");
			owner.printOner();
		}
		
	}
	
}
