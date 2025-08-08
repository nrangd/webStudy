/*

	// 구구단 자바스크립트만으로 따로 한거


 */

const gugudan_div = document.getElementById('gugudan');
gugudan_div.style.display = 'flex';
gugudan_div.style.backgroundColor = 'aliceblue';
gugudan_div.style.borderRadius = '20px';
gugudan_div.style.padding = '20px';
gugudan_div.style.color = 'navy';
gugudan_div.style.border = '2px solid cornflowerblue';
for(let i = 2; i < 10; i++) {
    
    for(let j = 1; j < 10; j++) {
        gugudan_div.innerHTML +=  i+'*'+j+ '='+i*j + "<br>";
    }
    if(i < 9) {
        gugudan_div.innerHTML += "<hr>";
    }
}
/*

	// 구구단 예전에 같이한거




 */

const gugudanDivs = document.querySelectorAll('#gugudan2 > div');

for (i = 0; i < gugudanDivs.length; i++) {
    const guguDiv = gugudanDivs[i];

    const dan = i + 2;

    for (let gop = 1; gop <= 9; ++gop) {
        // guguDiv.innerHTML += dan + 'X' + gop + '=' + dan * gop + '<br>';

        //자바 스크립트의 format string
        guguDiv.innerHTML += `${dan} x ${gop} = ${dan * gop}<br>`;
    }
}
	
/*

	// 웹에서 새로 스크립트로 만들어본 구구단

 */


const guguMain = document.getElementById('gugudan3');

const makeGuguTitleCell = dan => {
	const newCell = document.createElement('div');
	const newText = document.createTextNode(`${dan}단`);
	
	newCell.appendChild(newText);
	newCell.classList.add('title');
	
	return newCell;
}

const makeGuguRow = (dan, gop) => {
	const newRow = document.createElement('div');
	const newText = document.createTextNode(`${dan} x ${gop} = ${dan * gop}`);
	
	newRow.appendChild(newText);
	newRow.classList.add('data');
	
	return newRow;
}

for (let dan = 2; dan <= 9; ++dan) {
	guguMain.appendChild(makeGuguTitleCell(dan));
	for (let gop = 1; gop <= 9; ++gop) {
		guguMain.appendChild(makeGuguRow(dan,gop));
	}
}