// 잘못됐으면 true값 (뭔가 문제가 있으면 true, 정상적이면 false)

// <input>을 넣었을 때
//	아무것도 안썼으면 true, 뭐라도 썼으면 false
function isEmpty(input) {
	return (!input.value);
}

// <input>을 넣었을 때
//	한글 / 특수문자 값이 들어있다면 true, 없다면 false
function containsAnother(input) { // 매일같은거 작성할때 한글값 안들어가게 막아놓는 
	let pass = "1234567890qwertyuiopasdfghjklzxcvbnmQWEASDZXCRTYFGHVBNUIOPJKLM@_.";
	
	let iv = input.value;
	for (let i = 0; i < iv.length; i++){
		if (pass.indexOf(iv[i]) == -1 ) {	// pass에 있는 내용중에서
			return true;					// 내용이 없다면 트루값 리턴
		}
	}
	return false; 							// 내용이 있다면 폴스값 리턴	
}

// <input>, 글자 수를 넣었을 때
//	지정한 글자수보다 적으면 true, 지정한 글자수 이상이면 false
function atLeastLetter(input, len) {
	return (input.value.length < len);
}

// <input> x 2 두개를 넣었을 때 (pw, pw확인)
//	내용이 다르면 true, 같으면 false
function notEqualPw(input1, input2) {
	return (input1.value != input2.value);
}

// <input>, 문자열셋 넣었을 때
// 없으면 true, 있으면 false (입력한 pw에 지정한 문자열이 없는 경우)
function cotContain (input, passSet) {
	let iv = input.value;
	for (let i = 0; i < passSet.length; i++) {
		if (iv.indexOf(passSet[i]) != -1) {
			return true;
		}
	}
return false;
}

// <input> 넣었을 때
//	숫자 아닌거 있으면 true, 숫자만 있으면 false 
function isNotNumber(input) { // 신발 사이즈 체크
	return isNaN(input.value);
}

// <input>, 확장자 넣었을 때
//	확장자명이 아니면 true, 맞으면 false
function isNotType(input, type) { // ex) 파일명.확장자 의 . 을 구분짓는(type자리에)
	// .gif, .png, ...
	type = "." + type;
	return (input.value.indexOf(type)== -1) // 우리가 찾는 확장자의 경우가 아니면 폴스 맞으면 리턴
}



































