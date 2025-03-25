import java.util.Scanner;

// Bubble Sort : 인접한 두 항목의 값을 비교해서
//				기준에 만족하면 서로의 값을 교환하는 정렬 방법

public class PMain1 {
	
	// 숫자를 입력받아서 배열에 담을것
	//	(숫자(정수)는 5개, 중복 X
	
	// 정렬 전의 값을 출력
	
	// 정렬 후의 값을 출력

public static void BublleSort(int a[]) {
	
	int temp = 0;
	
	for(int j = 0; j < a.length; j ++) {
	for (int i = 0; i < a.length-1
			; i++) {
		if (a[i] > a[i+1]) {
			temp = a[i+1];
			a[i+1] = a[i];
			a[i] = temp;
		
		}
		
	}
	}
	
}
public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		
		int[] a = new int [5]; 						// 배열 a에 5칸 생성
		
		int n = 0;									// 
		for (int i = 0; i < a.length; i++) {		// 배열 a만큼(5) 반복
		
			Scanner sc = new Scanner(System.in);
			System.out.println("수 입력 : ");			// 반복한 만큼 입력
			n = sc.nextInt();
		    a[i] = n;								// 반복 입력한 값 배열a에 할당
		    
		    										// 정렬 전 출력??
		}
		
		for (int j = 0; j < a.length-1; j++) {
	    	System.out.print(a[j]+",");
	    	
		} 	System.out.print(a[4]);						
		
		
		BublleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		
//			System.out.println(" 1수 입력 : ");
//			n1 = k.nextInt();
//			System.out.println(" 2수 입력 : ");
//			n2 = k.nextInt();
//			System.out.println(" 3수 입력 : ");
//			n3 = k.nextInt();
//			System.out.println(" 4수 입력 : ");
//			n4 = k.nextInt();
//			System.out.println(" 5수 입력 : ");
//			n5 = k.nextInt();
		
//		int[] a = {n1,n2,n3,n4,n5};
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
