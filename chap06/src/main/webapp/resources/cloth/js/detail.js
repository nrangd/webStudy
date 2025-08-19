function addLinkToButton(button_id, url) {
	document.getElementById(button_id).addEventListener('click', (e) => {
		location.href= url;
	});
}

function movoTo(url) {
	loction.href=url;
}

//addLinkToButton('modify_btn','./modify');
addLinkToButton('list_btn','./list');