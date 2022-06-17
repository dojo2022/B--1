
// valueの値を取得し、画像を表示

var input = document.getElementById('example');
var value = input.getAttribute('value');
function task_popup() {
  // javascriptでdiv領域にCSSを付与
  //document.getElementById("task_check").classList.add("addColor");
  // jQueryでテキストボックスにCSSを付与
  $("#popWin").css( { 'display':'block' });
}

//褒めるポップアップの
//「閉じる」ボタン(チェックの画像"images/check.png")の動き

    const close = document.getElementById('close');  	//id "close"が
    close.addEventListener('click', () => {  			//clickされたら
    popWin.style.display = 'none';  					//popWinのdisplayがなくなる
    });
