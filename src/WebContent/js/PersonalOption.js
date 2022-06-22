
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

	function update(){
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
			alert("成功1");
			// アイコンの表示を変える。リマインドのデフォルトを変更する。
				for(var i in data){
					document.getElementById("iconImage").src = data[i].icon_image;
				}
		})
		//非同期通信が失敗したときの処理
		.fail(function() {
			//失敗とアラートを出す
			alert("失敗！");
		});
	}

	function newIcon() {
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
			contentType:false,
			processDate:false,
			timeStamp: new Date().getTime()
		})
		//非同期通信が成功したときの処理
		.done(function(data) {
			alert("成功1");
			// アイコンの表示を変える。リマインドのデフォルトを変更する。
				for(var i in data){
					document.getElementById("iconImage").src = data[i].icon_image;
				}
		})
		//非同期通信が失敗したときの処理
		.fail(function() {
			//失敗とアラートを出す
			alert("失敗！");
		});
	}


