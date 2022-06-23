//カスタムセットのタグをクリックしたときの動作

$(function(){
	$('.clickableTitle').on('click',(e) => {
		console.log('click');
		$(e.currentTarget).nextAll('.hiddenLine').slideToggle(500);
	});
});
function goAjax(){
			alert("functionはいったよ！");
			//入力値を取得してくる
			let testData1 = document.getElementById('DATA1').value;

			//{変数名：中に入れるもの}みたいに書いて、複数の値をpostData変数に格納
			let postData = {data1:testData1}


			//非同期通信始めるよ
			$.ajaxSetup({scriptCharset:'utf-8'});
			$.ajax({
				//どのサーブレットに送るか
				//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
				url: '/sampleProgram/AjaxSampleServlet',
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
					for(var i in data){
					$("hidouki").append('<div class="clickableTitle">' + data[i].customset_name + '</div><div class="hiddenLine"><div class="postLeft"></div><div class="postcenter"></div></div>' );
			  })
			   //非同期通信が失敗したときの処理
			  .fail(function() {
				//失敗とアラートを出す
				alert("失敗！");
			  });
		}