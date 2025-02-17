function signUpCheck() {
	let id = document.loginForm.id;
	let pw = document.loginForm.pw;
	let pwc = document.loginForm.pwc;
	let name = document.loginForm.name;
	let phone = document.loginForm.phone;
	let y = document.loginForm.year;
	let m = document.loginForm.month;
	let d = document.loginForm.day;
	let p = document.loginForm.photo;
	
	
	if (isEmpty(id) || atLeastLetter(id, 3)) {
		alert("ID는 최소 3자 이상 입력해주세요");
		id.focus();
		return false;
	}
	
	if (containsAnother(id))  {
		alert("ID는 영어,숫자,특수문자 @ _ . 만 입력 가능합니다.");
		id.value="";
		id.focus();
		return false;
	}

	if (isEmpty(pw) || atLeastLetter(pw, 3)) {
		alert("PW는 최소 3자 이상 입력해주세요");
		pw.value="";
		pw.focus();
		return false;
	}
	
	if (notEqualPw(pw, pwc))  {
		alert("PW가 다릅니다 다시 입력해주세요.");
		pw.value="";
		pwc.value="";
		pw.focus();
		return false;
	}
	
	if (isEmpty(name) || atLeastLetter(name, 2)) {
		alert("Name은 최소 2자 이상 입력해주세요");
		name.value="";
		name.focus();
		return false;
	}
	
	if (isEmpty(phone) || atLeastLetter(phone, 11) || isNotNumber(phone)) {
		alert("전화번호를 숫자로 전부 입력해주세요");
		phone.value="";
		phone.focus();
		return false;
	}
	
	if ((y.value == "choice") || (m.value == "choice") || (d.value == "choice")) {
		alert("생년월일을 전부 선택해주세요");
		return false;
	}
	
	if (isNotType(f, "jpeg") && isNotType(f, "jpg")) {
    alert("허용되지 않은 파일 형식입니다. JPEG 또는 JPG 파일만 업로드해주세요.");
    f.value = ""; // 잘못된 파일 초기화
    f.focus();
    return false;
	}
	
	if (isEmpty(p)) {
		alert("사진을 선택해주세요");
		p.focus();
		return false;
	}
	
	
	return true;

}
function updateCheck() {
	let id = document.loginForm.id;
	let pw = document.loginForm.pw;
	let pwc = document.loginForm.pwc;
	let name = document.loginForm.name;
	let phone = document.loginForm.phone;
	let y = document.loginForm.year;
	let m = document.loginForm.month;
	let d = document.loginForm.day;
	let p = document.loginForm.photo;
	
	
	if (isEmpty(id) || atLeastLetter(id, 3)) {
		alert("ID는 최소 3자 이상 입력해주세요");
		id.focus();
		return false;
	}
	
	if (containsAnother(id))  {
		alert("ID는 영어,숫자,특수문자 @ _ . 만 입력 가능합니다.");
		id.value="";
		id.focus();
		return false;
	}

	if (isEmpty(pw) || atLeastLetter(pw, 3)) {
		alert("PW는 최소 3자 이상 입력해주세요");
		pw.value="";
		pw.focus();
		return false;
	}
	
	if (notEqualPw(pw, pwc))  {
		alert("PW가 다릅니다 다시 입력해주세요.");
		pw.value="";
		pwc.value="";
		pw.focus();
		return false;
	}
	
	if (isEmpty(name) || atLeastLetter(name, 2)) {
		alert("Name은 최소 2자 이상 입력해주세요");
		name.value="";
		name.focus();
		return false;
	}
	
	if (isEmpty(phone) || atLeastLetter(phone, 11) || isNotNumber(phone)) {
		alert("전화번호를 숫자로 전부 입력해주세요");
		phone.value="";
		phone.focus();
		return false;
	}
	
	if ((y.value == "choice") || (m.value == "choice") || (d.value == "choice")) {
		alert("생년월일을 전부 선택해주세요");
		return false;
	}
	
	if (isNotType(f, "jpeg") && isNotType(f, "jpg")) {
    alert("허용되지 않은 파일 형식입니다. JPEG 또는 JPG 파일만 업로드해주세요.");
    f.value = ""; // 잘못된 파일 초기화
    f.focus();
    return false;
	}
	
	if (isEmpty(p)) {
		alert("사진을 선택해주세요");
		p.focus();
		return false;
	}
	
	
	return true;

}




























































