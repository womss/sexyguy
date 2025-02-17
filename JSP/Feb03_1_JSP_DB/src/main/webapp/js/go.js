function goAppleDetail(loc) { // "goAppleDetail('${apple.a_location}');"의 location
	location.href = "AppleDetailController?a_location=" + loc; // 이것도 찾
}

function deleteApple(loc) {
	let t = confirm(`${loc } 사과 정말 지우시겠습니까 ?`);
	if (t) {
		location.href = "AppleDeleteController?a_location=" + loc; 
	}
}



