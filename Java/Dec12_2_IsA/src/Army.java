
public class Army extends Person {
	String rank;
	
	public Army() {
	}
	
	
	
	public Army(String name, int age, String division, String rank) {
		super(name, age, division);
		this.rank = rank;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("\t계급  : %s\n", rank);
	}
	
}
