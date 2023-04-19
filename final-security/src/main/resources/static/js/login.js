(function($) {
	
	const w = 600;
	const h = 600;
	const left = (window.innerWidth - w) / 2;
	const top = (window.innerHeight - h) / 2;
	
	$(document).on('click', '.naver-login-btn', (e) => {
		e.preventDefault();
		const popup = window.open('/final-security/oauth2/authorization/naver', 'Login', `height=${h},width=${w},left=${left},top=${top}`);
		popup.addEventListener('load', () => {
			// 작업이 끝난 후 응답을 전달하기 위한 데이터를 변수에 저장
			const response = { data: 'example' };
			// 부모 페이지의 함수 호출
			window.opener.handlePopupResponse(response);
			// 팝업 닫기
			window.close();
		});
		return false;
	});

	$(document).on('click','.kakao-login-btn',(e) => {
		e.preventDefault();
		window.open('/final-security/oauth2/authorization/kakao', 'Login', `height=${h},width=${w},left=${left},top=${top}`);
   		return false;
	});


	
})(window.jQuery);