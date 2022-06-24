console.log('hello1');
//日付を取得するJS

function recalc() {
	const now = new Date();
	const year = now.getFullYear();
	let month = now.getMonth();
	const date = now.getDate();

	month = month + 1;

	document.getElementById('date').textContent
		= year + '年' + month + '月' + date + '日' + 'のタスク';
} recalc();

//ポップアップ
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






//褒めるポップアップの動きについてのJS

//褒めるポップアップの「閉じる」ボタンの動き

	const popupclose = document.getElementById('popupclose');	//id[popupclose]が
	popupclose.addEventListener('click', () => {			//clickされたら
		popWin.style.display = 'none';				//popWinのdisplayがなくなる
	});

//褒めるポップアップ表示に関する動き

	function checkedBox() {
		const chkBox = document.getElementById('chk_box');
		const popWin = document.getElementById('popWin');

		// ボタンをクリックしたときにポップアップを表示させる
		chkBox.addEventListener('change', () => {
			popWin.style.display = "block";
		});
	}

//チェックボックスにチェックを入れるとポップアップウィンドウが出る
	const chk= document.getElementById("chk_box");
	chk.addEventListener("change",function(){
		document.getElementById("popWin").style.display="block";
	});


//非同期通信

	function goAjax(){
			//alert("functionはいったよ！");
			//入力値を取得してくる
			let testData1 = document.getElementById('chk_box').value;

			//{変数名：中に入れるもの}みたいに書いて、複数の値をpostData変数に格納
			let postData = {data1:testData1};

			//非同期通信始めるよ
			$.ajaxSetup({scriptCharset:'utf-8'});
			$.ajax({
				//どのサーブレットに送るか
				//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
				url: '/Forza/CheerPopupServlet',
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
				//alert("成功1");
				// 今回は上の<div id="test"></div>の中に返ってきた文字列を入れる
				// 褒めるポップアップにCheerimageを表示する
				var img_element=document.createElement('img');
				img_element.src = data[0].cheer_image;
				var content_area=document.getElementById("cheerImage");
				content_area.appendChild(img_element);
				// 褒めるポップアップにCheerMessageを表示する
				document.getElementById("cheerMessage").innerText=data[0].cheer_message;
			  })
			   //非同期通信が失敗したときの処理
			  .fail(function() {
				//失敗とアラートを出す
				alert("失敗！");
			  });
		}

//紙吹雪の動き（閉じるをクリックしたときの動き）
//理由は分からないが、13-17行目を消すと全画面の方の紙吹雪も消える

	document.querySelector(".popwin-inside").addEventListener("click", function () {
	    party.confetti(this, {
	        count: party.variation.range(20,40),
	    });
	});

//紙吹雪の動き（全画面の動き）

	particlesJS("particles-js",{
	"particles":{
		"number":{
			"value":150,//この数値を変更すると紙吹雪の数が増減できる
			"density":{
				"enable":false,
				"value_area":400
			}
		},
		"color": {
        "value": ["#EA5532", "#F6AD3C", "#FFF33F", "#00A95F", "#00ADA9", "#00AFEC","#4D4398", "#E85298"]//紙吹雪の色の数を増やすことが出来る
		},
		"shape":{
			"type":"polygon",//形状はpolygonを指定
			"stroke":{
				"width":0,
			},
			"polygon":{
				"nb_sides":5//多角形の角の数
			}
			},
			"opacity":{
				"value":1,
				"random":false,
				"anim":{
					"enable":true,
					"speed":20,
					"opacity_min":0,
					"sync":false
				}
			},
			"size":{
				"value":5.305992965476349,
				"random":true,//サイズをランダムに
				"anim":{
					"enable":true,
					"speed":1.345709068776642,
					"size_min":0.8,
					"sync":false
				}
			},
			"line_linked":{
				"enable":false,
			},
			"move":{
				"enable":true,
			"speed":10,//この数値を小さくするとゆっくりな動きになる
			"direction":"bottom",//下に向かって落ちる
			"random":false,//動きはランダムにならないように
			"straight":false,//動きをとどめない
			"out_mode":"out",//画面の外に出るように描写
			"bounce":false,//跳ね返りなし
				"attract":{
					"enable":false,
					"rotateX":600,
					"rotateY":1200
				}
			}
		},
		"interactivity":{
			"detect_on":"canvas",
			"events":{
				"onhover":{
					"enable":false,
				},
				"onclick":{
					"enable":false,
				},
				"resize":true
			},
		},
		"retina_detect":true
	});








