// M
//		front-end개발자 B (유효성 검사 파일은 front-end개발자 A가 만듦)
function check() {
	let x = document.f.x;
	let y = document.f.x;
	
	if (isEmpty(x) || isNotNumber(x) || isEmpty(y) || isNotNumber(y)) {
		alert("Ouch!");
		return false;
	}
	return true;
}












































