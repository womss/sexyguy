/* M2.js*/
function check() {
	let n = document.bmi.name;
	let h = document.bmi.height;
	let w = document.bmi.weight;
	let p = document.bmi.photo;

	// 이름
	if (!n.value) {
		alert("이름 안적음");
		return false;
	}

	// 키
	if (isNaN(h.value)) {
		alert("숫자만 적을 수 있음")
		return false;
	} else if (!h.value) {
		alert("키 안적음");
		h.focus();
		return false;
	}

	// 몸무게
	if (isNaN(w.value)) {
		alert("숫자만 적을 수 있음")
		return false;
	}
	else if (!w.value) {
		alert("몸무게 안적음");
		w.focus();
		return false;
	}

	// 파일
	else if (!p.value) {
		alert("파일안 올림");
		p.focus();
		return false;
	}


	return true;
}









































