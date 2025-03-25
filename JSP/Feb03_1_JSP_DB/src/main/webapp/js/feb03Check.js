function appleRegCheck() {
			let lBox = document.appleRegForm.a_location;
			let pBox = document.appleRegForm.a_price;
			let iBox = document.appleRegForm.a_info;
			// 원산지
			if (!lBox.value) {
				alert("지역 안적음");
				lBox.focus();
				return false;
			// 숫자 아닌것만 입력
			} else if (isEmpty(pBox) || isNotNumber(pBox)) {
				alert("제대로 입력 하시오")
				pBox.value = "";
				pBox.focus();
				return false;
			} else if (isEmpty(iBox) || atLeastLetter(iBox, 5)) {
				alert("제대로 입력 하시오")
				iBox.value = "";
				iBox.focus();
				return false;
			} 
		return true;
		}



























