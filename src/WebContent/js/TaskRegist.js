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


/*何列あるのかを計測*/
const ele = document.getElementsByClassName("data_row");
/*各エレメントを格納する配列*/
let clickBtn = [];
let editPopupWrapper =[];
let close = [];
/*console.log(ele.length);*/
/*列の分だけイベントを準備*/
/*今回は列の分だけ「edit-popup-wrapper」を作成したが*/
/*「edit-popup-wrapper」は一つで必要項目のvalue値をjspから取ってきて格納しても良かった*/
for (let i = 1; i <= ele.length; i++) {
	clickBtn[i] = document.getElementById("click-name" +i);
	console.log("click-name"+i);
	editPopupWrapper[i] = document.getElementById("edit-popup-wrapper"+i);
	console.log("edit-popup-wrapper"+i);
	close[i] = document.getElementById('edit-close'+i);
	console.log('edit-close'+i);
	/*他のページに同じJavaScriptを使うときはコメントを外す*/
/*	if (!clickBtn[i]) { return false; }
	if (!editPopupWrapper[i]) { return false; }
	if (!close[i]) { return false; }*/
}
/*閉じるためのイベント*/
for (let i = 1; i <= ele.length; i++) {
	clickBtn[i].addEventListener('click', () => {
		editPopupWrapper[i].style.display = "block";
	});
	// ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
	close[i].addEventListener('click', () => {
		editPopupWrapper[i].style.display = 'none';
	});
}

