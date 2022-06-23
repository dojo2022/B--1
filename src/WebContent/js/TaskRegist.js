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


function Delete(){
			alert("functionはいったよ！");
			//入力値を取得してくる
			let testData1 = document.getElementById('test_data1').value;
			let testData2 = document.getElementById('test_data2').value;
			let testData3 = document.getElementById('test_data3').value;

			//{変数名：中に入れるもの}みたいに書いて、複数の値をpostData変数に格納
			let postData = {data1:testData1,data2:testData2,data3:testData3}


			//非同期通信始めるよ
			$.ajaxSetup({scriptCharset:'utf-8'});
			$.ajax({
				//どのサーブレットに送るか
				//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
				url: '/Forza/TaskUpdateDeleteServlet',
				//どのメソッドを使用するか
				type:"POST",
				//受け取るデータのタイプ
				dataType:"json",
				//何をサーブレットに飛ばすか（変数を記述）
				data: postData,
				//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
				processDate:false,
				timeStamp: new Date().getTime()
			   //非同期通信が成功したときの処理
			}).done(function(data) {
				alert("成功1");
				// 今回は上の<div id="test"></div>の中に返ってきた文字列を入れる
				document.getElementById("test").innerText=data[0].name;
			  })
			   //非同期通信が失敗したときの処理
			  .fail(function() {
				//失敗とアラートを出す
				alert("失敗！");
			  });
		}


function Regist(){
			alert("functionはいったよ！");
			//入力値を取得してくる
			let setId = document.getElementById('id').value;
			let setUser_id = document.getElementById('user_id').value;
			let setTask_id = document.getElementById('task_id').value;
			let setCustomset_id = document.getElementById('customset_id').value;
			let setTask_name = document.getElementById('task_name').value;
			let setTask_memo = document.getElementById('task_memo').value;
			let setTask_date = document.getElementById('task_date').value;
			let setPriority = document.getElementById('priority').value;
			let setTask_judge = document.getElementById('task_judge').value;


			//{変数名：中に入れるもの}みたいに書いて、複数の値をpostData変数に格納
			let postData = {id:setId,user_id:setUser_id,task_id:setTask_id,
							customset_id:setCustomset_id,task_name:setTask_name,task_memo:setTask_memo,
							task_date:setTask_date,priority:setPriority,task_judge:setTask_judge}




			//非同期通信始めるよ
			$.ajaxSetup({scriptCharset:'utf-8'});
			$.ajax({
				//どのサーブレットに送るか
				//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
				url: '/Forza/TaskUpdateDeleteServlet',
				//どのメソッドを使用するか
				type:"POST",
				//受け取るデータのタイプ
				dataType:"json",
				//何をサーブレットに飛ばすか（変数を記述）
				data: postData,
				//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
				processDate:false,
				timeStamp: new Date().getTime()
			   //非同期通信が成功したときの処理
			}).done(function(data) {
				alert("成功1");
				// 今回は上の<div id="test"></div>の中に返ってきた文字列を入れる

				document.getElementById("test").innerText=data[0].name;
			  })
			   //非同期通信が失敗したときの処理
			  .fail(function() {
				//失敗とアラートを出す
				alert("失敗！");
			  });
		}


