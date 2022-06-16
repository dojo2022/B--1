//褒めるポップアップの
//「閉じる」ボタン(チェックの画像"images/check.png")の動き

    const close = document.getElementById('close');  	//id "close"が
    close.addEventListener('click', () => {  			//clickされたら
    popWin.style.display = 'none';  					//popWinのdisplayがなくなる
    });
