    function recalc() {
		const now = new Date();
		const year = now.getFullYear();
		let month = now.getMonth();
		const date = now.getDate();

		month = month +1;

		document.getElementById('date').textContent
		= year + '年' + month + '月' + date + '日' + 'のタスク';
	} recalc();


	function onButtonClick(){
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


function onNameClick(){
		const clickBtn = document.getElementById('click-name');
		const editPopupWrapper = document.getElementById('edit-popup-wrapper');
		const close = document.getElementById('edit-close');

		// ボタンをクリックしたときにポップアップを表示させる
		clickBtn.addEventListener('click', () => {
		  editPopupWrapper.style.display = "block";
		});

		// ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
		popupWrapper.addEventListener('click', e => {
		  if (e.target.id === popupWrapper.id || e.target.id === close.id) {
		    editPopupWrapper.style.display = 'none';
		  }
		});
}