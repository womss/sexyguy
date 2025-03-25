function calcCheck() {
	let xBox = document.calcForm.x;
	let yBox = document.calcForm.y;
	
	if ((isEmpty(xBox) || isNotNumber(xBox)) || isEmpty(yBox) || isNotNumber(yBox)) {
	
		alert("숫자 제대로 입력!");
		xBox.value = "";
		yBox.value = "";
		xumBox.focus();
		return false;
	}
	return true;
}






































