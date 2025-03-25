// Mask is a Product2
public class Mask extends Product2{
	public Mask() {
		// TODO Auto-generated constructor stub
	}
	
	// Product2(name, price)랑 같은 생성자를 갖고 싶음
	// 1. 직접 입력하거나
//	public Mask(String name, int price) {
//		super(name, price);
		
	// 2. 가상의 멤버변수 하나 만들어놓고 
	//		단축키 이용
	
	public Mask(String name, int price, int a) {
		super(name, price);
		
	}
	
	
}
