
public class Main {
	public static void main(String[] args) {
		Car c = new Car("부릉이", 190, "벤츠", "스뽀츠카");
		c.printInfo();
		System.out.printf("%s의 최고 속도는 : "+c.maxspeed()+"km/h 입니다\n", c.name);
		
		System.out.println("-----------------------------------");
		
		Airplane a = new Airplane("펄럭이", 850, "대한항공", 80);
		a.printInfo();
		System.out.printf("%s의 최고 속도는 : "+a.maxspeed()+ "km/h 입니다\n", a.name);
	}
}
