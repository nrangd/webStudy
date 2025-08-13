const nomoreChk = document.querySelector('#nomore > [type="checkbox"]');
		
console.log(nomoreChk);

nomoreChk.addEventListener('change', (e) => {
	// 체크가 true가 되면 서버로 요청 보냄
	if(e.target.checked) {
		location.href = '/chap04/popup?nomore=t';
	}
});