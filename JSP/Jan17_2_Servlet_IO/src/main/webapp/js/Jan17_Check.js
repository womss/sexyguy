function bmiCheck() {
	let nameBox = document.bmiform.name;
	let heightBox = document.bmiform.height;
	let weightBox = document.bmiform.weight;
	let photoBox = document.bmiform.photo;
	
	if (isEmpty(nameBox) || atLeastLetter(nameBox, 2)) {
		alert("Please Fill in Your Name Properly.");
		nameBox.value = "";
		nameBox.focus();
		return false;
	} else if(isEmpty(heightBox) || atLeastLetter(heightBox, 2) || isNotNumber(heightBox)) {
		alert("Please Fill in Your Height Properly.");
		heightBox.value = "";
		heightBox.focus();
		return false;
	} else if(isEmpty(weightBox) || atLeastLetter(weightBox, 2)	|| isNotNumber(weightBox)) {
		alert("Please Fill in Your Weight Properly.");
		weightBox.value = "";
		weightBox.focus();
		return false;
	} else if(isEmpty(photoBox) || (isNotType(photoBox, "png") && isNotType(photoBox, "gif") && isNotType(photoBox, "jpg") && isNotType(photoBox, "bmp"))) {
		alert("Please Fill in Photo Properly.");
		photoBox.value = "";
		photoBox.focus();
		return false;
	}
	
//	정상적으로 입력했다면 트루값 반환
	return true;
	
} // bmiCheck() 끝





































