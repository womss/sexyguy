// 클라이언트가 캐릭터 생성 기능을 만들어 달라고 요구
//		=> 만드는데 성공!
//		건네주는 방법 ★★★★★
//	결론 : .java파일 말고 .jar파일로 건네줘라!
//		.java : 소스까지 공개
//		.jar : 소스를 공개하지 않고 + 그 기능만을 전달 !
//	JAR (Java ARchive, 자바 아카이브) 파일
//		: 기계어 상태로 바꿔서 압축을 해놓은 형태

//	한국어 -개발-> .java로 저장
//	.java파일 -번역(Compile)-> .class파일(기계어 / 바이트코드)을
//								자동으로 생성
//	.class파일 -실행->

//	우리가 만든 코드는 .java파일로 저장되고,
//	이 때 compile이라는 작업을 통해 .class파일,
//	즉 기계어로 변환되어 자동으로 생성
//	실행될때는 .class형태로 JVM에서 가동되는 형태

//	.java파일 : 사림이 보려고 만든 것
//	.class파일 : 실제로 자바에서 구동하는 것

// 왜 ? 굳이 ? 기계어 / 바이트코드로 변환해서 돌리는걸까...?
//		- 바이트 코드를 사용하면 실행이 빠르고!
//		- 소스를 노출하게되면 이게 무슨 프로그램인지
//			알 수 있기 때문에 '보안'상의 이유로
//	=> 다른사람에게 기능을 넘겨줄 때 소스를 알려주지 말고,
//		그 기능만을 사용하게 하자
//	=> .java파일 말고 jar파일로

// JavaDoc
//	JavaDoc의 역할 : 제품 설명서
//	우리가 만든 프로그램을 보기 쉽~~게 HTML형식,
//		우리가 알고있는 WEB형식으로 만들어서
//		보기 편~~~~하게 문서화 시킨것

//	JavaDoc의 특징
//		- 주석은 /**	(내용) */ 담아서 보낸다
//		- 주석 안쪽은 크게 2가지로 나뉨
//			설명문
//				주석의 시작에서 첫번째 태그 섹션까지의 부분
//				설명문은 HTML로 설명되기 때문에
//				단순히 주석 작성 당시에 엔터를 쳐서 줄을 바꿔서
//				입력했더라도! => 그대로 이어져서 출력됨
//				줄바꿈 처리를 하고 싶다면 <p>를 작성하면 됨 ~
//			태그 섹션
//				첫번째 문자가 '@'로 시작한다
//				- @author : 이 프로그램의 작성자,
//					설정하지않으면 기본값으로 Winsdows 계정 ID로 설정
//				- @version : 말 그대로 이 프로그램의 버전
//				- @param : 파라미터에 대한 설명을 할 때 사용
//				- @throws : 예외처리에 대한 설명
//				- @return : 메소드에 void가 아닌 반환 값이 있을 때 그것에 대한 설명

/**
 * 게임 캐릭터의 정보를 가지고 있는 클래스
 * <p>
 * @author csm
 * @version 1.1.14
 */

public class GameCharacter {
	String nickname; 
	int level;
	String job;
	String weapon;
	
	// 생성자
	/**
	 * 게임 캐릭터를 생성합니다.
	 * <p> 기본 레벨은 1, 기본 직업은 초보자, 기본 무기는 목검입니다.
	 * @param nickname 캐릭터의 이름; 길이는 3자 이상 10자 이하이어야 합니다
	 * @throws IllegalArgumentException 캐릭터의 nickname 길이가 정해진 // 예외처리
	 * 범위를 벗어나면, 즉 ({@code nickname < 3 || nickname > 10}) 이면 발생합니다.
	 */
	public GameCharacter(String nickname) { // 이건 void가 없음 왜?
		this.level = 1;
		this.job = "초보자";
		this.weapon = "목검";
		if (nickname.length() < 3 || nickname.length() > 10) {// 문자열 관련해서는 문자가 몇글자인지 알려면 .length 활용 
			throw new IllegalArgumentException("캐릭터의 이름은 3자 이상 10자 이하입니다.");
		}
		
		this.nickname = nickname;
	}
	/**
	 * 캐릭터의 레벨을 올려주는 메소드입니다.
	 */
	public void levelUp() {
		this.level++;
	}
	/**
	 * 캐릭터의 직업을 변경합니다.
	 * @param job 캐릭터의 변경할 직업
	 * @throws IllegalArgumentException 캐릭터의 레벨이 10을 넘지 않았다면 발생합니다.
	 */
	public void setjob(String job) {
		if (this.level < 10) {
			throw new IllegalArgumentException("캐릭터의 레벨이 10을 넘지 않습니다");
			
		}
		this.job = job;
	}
	/**
	 * 생성된 캐릭터의 status값을 보여주는 메소드입니다.
	 */
	public void printInfo() {
		System.out.printf("닉네임 : %s\n", nickname);
		System.out.printf("레벨 : %s\n", level);
		System.out.printf("직업 : %s\n", job);
		System.out.printf("무기 : %s\n", weapon);
//		내가
//		System.out.println(nickname);
//		System.out.println(level);
//		System.out.println(job);
//		System.out.println(weapon);
	}
	
//	public void characterName() {
//		
//	}
//	
//	public void characterLevel() {
//		
//	}
//	
//	public void job() {
//		
//	}
//	
//	public void weapon() {
//		
//	}
}
