console.log('hello1');

function recalc() {
	const now = new Date();
	const year = now.getFullYear();
	let month = now.getMonth();
	const date = now.getDate();

	month = month + 1;

	document.getElementById('date').textContent
		= year + '年' + month + '月' + date + '日' + 'のタスク';
} recalc();


function onButtonClick() {
	const clickBtn = document.getElementById('click-btn');
	const popupWrapper = document.getElementById('popup-wrapper');
	const close = document.getElementById('close');

	// ボタンをクリックしたときにポップアップを表示させる
	clickBtn.addEventListener('click', () => {
		popupWrapper.style.display = "block";
	});

	// ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
	popupWrapper.addEventListener('click', e => {
		if (e.target.id === popupWrapper.id || e.target.id === close.id) {
			popupWrapper.style.display = 'none';
		}
	});

}



const ele = document.getElementsByClassName("data_row");
let clickBtn = [];
let editPopupWrapper =[];
let close = [];
console.log(ele.length);
for (let i = 1; i <= ele.length; i++) {
	clickBtn[i] = document.getElementById("click-name" +i);
	console.log("click-name"+i);
	editPopupWrapper[i] = document.getElementById("edit-popup-wrapper"+i);
	console.log("edit-popup-wrapper"+i);
	close[i] = document.getElementById('edit-close'+i);
	console.log('edit-close'+i);
/*	if (!clickBtn[i]) { return false; }
	if (!editPopupWrapper[i]) { return false; }
	if (!close[i]) { return false; }*/
}
/*clickBtn[1].addEventListener('click', () => {
		editPopupWrapper[1].style.display = "block";
	});
clickBtn[2].addEventListener('click', () => {
		editPopupWrapper[2].style.display = "block";
	});*/
for (let i = 1; i <= ele.length; i++) {
	clickBtn[i].addEventListener('click', () => {
		editPopupWrapper[i].style.display = "block";
	});
	// ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
	close[i].addEventListener('click', () => {
		editPopupWrapper[i].style.display = 'none';
	});
}

