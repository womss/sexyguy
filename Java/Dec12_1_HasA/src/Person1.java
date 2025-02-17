
public class Person1 {
	String name;
	Market market;
	
	
	public Person1() {
	}


	public Person1(String name, Market market) {
		this.name = name;
		this.market = market;
	}

	public void printInfo() {
		System.out.println(name);
		market.printMarket();
	}
	
	
}
