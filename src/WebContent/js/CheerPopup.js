//褒めるポップアップの動きについてのJS

//褒めるポップアップの「閉じる」チェックボタンの動き

	const close = document.getElementById('close');	//id[close]が
	close.addEventListener('click', () => {			//clickされたら
		popWin.style.display = 'none';				//popWinのdisplayがなくなる
	});

//紙吹雪の動き
	document.querySelector(".pop-win").addEventListener("click", function (e) {
	    party.confetti(this, {
	        count: party.variation.range(20, 40),
	    });
	});


//CheerAfterの紙吹雪
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





/*//jQueryの記述

	$(function(){
		$('[name="CUSTOMSET_ID"]').change(function(){
			var aryCmp = [];
			$('[name="CUSTOMSET_ID"]:checked').each(function(index, element){
				aryCmp.push($(element).val());
				});
				$('#popWin').html(aryCmp.join(','));
		});
	});*/


/*// valueの値を取得し、画像を表示

var input = document.getElementById('example');
var value = input.getAttribute('value');
function task_popup() {
  // javascriptでdiv領域にCSSを付与
  //document.getElementById("task_check").classList.add("addColor");
  // jQueryでテキストボックスにCSSを付与
  $("#popWin").css( { 'display':'block' });
}
*/

/*const chk= document.getElementById("chk_box");
chk.addEventListener("change",function(){
	document.getElementById("popWin").style.display="block";
});
*/