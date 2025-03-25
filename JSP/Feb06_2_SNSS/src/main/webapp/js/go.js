function membershipController() {
	location.href = "membershipController"; // 멤버십으로 이동한다
}

function logout() {
	let really = confirm("정말 로그아웃 하시겠습니까 ?");
	if (really) {
	location.href = "LoginController";
	}
	
function memberInfoGo() {
	location.href = "memberInfoController";
}
	
function bye() {
	let t = prompt("탈퇴하시겠습니까 ? Y/N")
	if (t == "Y") {
		location.href = "DeleteMemberController";
	}
		
}








}




