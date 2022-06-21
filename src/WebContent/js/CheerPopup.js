//褒めるポップアップの動きについてのJS

//褒めるポップアップの「閉じる」チェックボタンの動き

	const close = document.getElementById('close');	//id[close]が
	close.addEventListener('click', () => {			//clickされたら
		popWin.style.display = 'none';				//popWinのdisplayがなくなる
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