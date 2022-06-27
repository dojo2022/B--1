
	function previewImage(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('preview');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);

			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
	}


/*
	function update(){
				alert("updataはいったよ！");

		//入力値を取得してくる
		let setPw = document.getElementById('pw').value;
		let setSalary = document.getElementById('salaryDay').value;
		let setSun = document.getElementById('sunday').value;
		let setMon = document.getElementById('monday').value;
		let setTue = document.getElementById('tuesday').value;
		let setWed = document.getElementById('wednesday').value;
		let setThu = document.getElementById('thursday').value;
		let setFri = document.getElementById('friday').value;
		let setSat = document.getElementById('saturday').value;
		let setBirthMonth = document.getElementById('birthMonth').value;
		let setBirthDay = document.getElementById('birthDay').value;

		//{変数名：中に入れるもの}みたいに書いて、複数の値をpostData変数に格納
		let postData = {Pw:setPw, Salary:setSalary, Sun:setSun,
		Mon:setMon, Tue:setTue, Wed:setWed, Thu:setThu, Fri:setFri, Sat:setSat,
		BirthMonth:setBirthMonth, BirthDay:setBirthDay}


		//非同期通信始めるよ
		$.ajaxSetup({scriptCharset:'utf-8'});
		$.ajax({
			//どのサーブレットに送るか
			//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
			url: '/Forza/PersonalOptionServlet',
			//どのメソッドを使用するか
			type:"POST",
			//受け取るデータのタイプ
			dataType:"json",
			//何をサーブレットに飛ばすか（変数を記述）
			data: postData,
			//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
			processDate:false,
			timeStamp: new Date().getTime()
		})
		//非同期通信が成功したときの処理
		.done(function(data) {
//			alert("成功1");
			// アイコンの表示を変える。リマインドのデフォルトを変更する。
//				for(var i in data){
//				document.getElementById("iconImage").src = data[i].icon_image;
//				}
		})
		//非同期通信が失敗したときの処理
		.fail(function() {
			//失敗とアラートを出す
			alert("失敗！");
		});
	}



	function newIcon() {
			alert("newIconはいったよ！");

		let setIcon = document.getElementById('img').value;

		let postData = { Icon : setIcon }

		$.ajaxSetup({scriptCharset:'utf-8'});
		$.ajaxSetup({enctype:'multipart/form-data'});
		$.ajax({
			//どのサーブレットに送るか
			//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
			url: '/Forza/PersonalOptionServlet',
			//どのメソッドを使用するか
			type:"POST",
			//受け取るデータのタイプ
			dataType:"json",
			//何をサーブレットに飛ばすか（変数を記述）
			data: postData,
			//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
			processDate:false,
			timeStamp: new Date().getTime()
		})
		//非同期通信が成功したときの処理
		.done(function(data) {
//			alert("成功1");
			// アイコンの表示を変える。リマインドのデフォルトを変更する。
					document.getElementById("iconImage").src = data[0].icon_image;
		})
		//非同期通信が失敗したときの処理
		.fail(function() {
			//失敗とアラートを出す
			alert("失敗！");
		});
		return false;
	}

*/


/*ヘッダーのテストコード*/
//ドロップダウンの設定を関数でまとめる
function mediaQueriesWin(){
  var width = $(window).width();
  if(width <= 768) {//横幅が768px以下の場合
    $(".has-child>a").off('click'); //has-childクラスがついたaタグのonイベントを複数登録を避ける為offにして一旦初期状態へ
    $(".has-child>a").on('click', function() {//has-childクラスがついたaタグをクリックしたら
      var parentElem =  $(this).parent();// aタグから見た親要素の<li>を取得し
      $(parentElem).toggleClass('active');//矢印方向を変えるためのクラス名を付与して
      $(parentElem).children('ul').stop().slideToggle(500);//liの子要素のスライドを開閉させる※数字が大きくなるほどゆっくり開く
      return false;//リンクの無効化
    });
  }else{//横幅が768px以上の場合
    $(".has-child>a").off('click');//has-childクラスがついたaタグのonイベントをoff(無効)にし
    $(".has-child").removeClass('active');//activeクラスを削除
    $('.has-child').children('ul').css("display","");//スライドトグルで動作したdisplayも無効化にする
  }
}

// ページがリサイズされたら動かしたい場合の記述
$(window).resize(function() {
  mediaQueriesWin();/* ドロップダウンの関数を呼ぶ*/
});

// ページが読み込まれたらすぐに動かしたい場合の記述
$(window).on('load',function(){
  mediaQueriesWin();/* ドロップダウンの関数を呼ぶ*/
});
