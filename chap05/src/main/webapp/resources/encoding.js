const getBtn = document.getElementById('getBtn');
const postBtn = document.getElementById('postBtn');

const f = document.getElementById('f');

console.dir(f);

/*
getBtn.addEventListener('click', (e) => {
	// html 폼을 자바스크립트에서 제어하기
	f.action = contextPath + '/test/encoding';
	f.method = 'GET';

	// 해당 폼 소속인 input들 보기
	for (let i = 0; i < f.length; i++) {
		console.log(f.elements[i]);
	}	

	// 하나만 접근하기
	console.log(f.elements.age);	
	console.log(f.elements.name);
	
	f.elements.age.value=27;
	f.elements.name.value='포카칩 치즈맛';
	
	f.submit();
});
*/

/*
// 실행하면 함수를 리턴해주는 함수
const makeBtnClickHandler = method => e => {
	f.action = contextPath + '/test/encoding';
	f.method = method;
	f.submit();
};

postBtn.addEventListener('click', makeBtnClickHandler('post'));
getBtn.addEventListener('click', makeBtnClickHandler('get'));
*/


const send = () => {
	// html 폼을 자바스크립트에서 제어하기
	f.action = contextPath + '/test/encoding';

	// 해당 폼 소속인 input들 보기
	for (let i = 0; i < f.length; i++) {
		console.log(f.elements[i]);
	}

	// 하나만 접근하기
	console.log(f.elements.age);	
	console.log(f.elements.name);
	
	f.elements.age.value=27;
	f.elements.name.value='포카칩 치즈맛';
	
	f.submit();
};

//getBtn.addEventListener('click', send);
//postBtn.addEventListener('click', send);

window.addEventListener('click', (e) => {
	const curr = e.target.id;
	console.log(curr== getBtn);
	if(curr == 'getBtn') {
		console.log('test');
		f.method = 'GET';
		send();
	} else if(curr == 'postBtn') {
		f.method = 'POST';
		send();
	}
})
