'use strict';

let url = new URL(window.location.href);

// URLSearchParamsオブジェクトを取得
let params = url.searchParams;

/*ログイン日数をYとする。パラメータを受け取る*/
var y=params.get('loginCount');
/*タスクカウントをXとする*/
var x=params.get('taskCount');

console.log(x + ',' + y);
window.onload = function Trophy(){

	document.getElementById("loginC").textContent = y;

	if(7<=y){document.getElementById("login7").src="images/cup.png";}
	if(30<=y){document.getElementById("login30").src="images/cup.png";}
	if(60<=y){document.getElementById("login60").src="images/cup.png";}
	if(100<=y){document.getElementById("login100").src="images/cup.png";}
	if(180<=y){document.getElementById("login180").src="images/cup.png";}
	if(365<=y){document.getElementById("login365").src="images/cup.png";}
	if(555<=y){document.getElementById("login555").src="images/cup.png";}
	if(777<=y){document.getElementById("login777").src="images/cup.png";}
	if(1000<=y){document.getElementById("login1000").src="images/cup.png";}

	/*達成している場合、トロフィーの下の数字にクラスを追加しCSSを適用*/
	if(7<=y){document.getElementById("login7n").classList.add("a");}
	if(30<=y){document.getElementById("login30n").classList.add("a")}
	if(60<=y){document.getElementById("login60n").classList.add("a")}
	if(100<=y){document.getElementById("login100n").classList.add("a")}
	if(180<=y){document.getElementById("login180n").classList.add("a")}
	if(365<=y){document.getElementById("login365n").classList.add("a")}
	if(555<=y){document.getElementById("login555n").classList.add("a")}
	if(777<=y){document.getElementById("login777n").classList.add("a")}
	if(1000<=y){document.getElementById("login1000n").classList.add("a")}




	document.getElementById("taskC").textContent = x;

	if(1<=x){document.getElementById("task1").src="images/cup.png";}
	if(7<=x){document.getElementById("task7").src="images/cup.png";}
	if(30<=x){document.getElementById("task30").src="images/cup.png";}
	if(60<=x){document.getElementById("task60").src="images/cup.png";}
	if(100<=x){document.getElementById("task100").src="images/cup.png";}
	if(180<=x){document.getElementById("task180").src="images/cup.png";}
	if(365<=x){document.getElementById("task365").src="images/cup.png";}
	if(555<=x){document.getElementById("task555").src="images/cup.png";}
	if(777<=x){document.getElementById("task777").src="images/cup.png";}
	if(1000<=x){document.getElementById("task1000").src="images/cup.png";}

	/*達成している場合、トロフィーの下の数字にクラスを追加しCSSを適用*/
	if(1<=x){document.getElementById("task1n").classList.add("a");}
	if(7<=x){document.getElementById("task7n").classList.add("a");}
	if(30<=x){document.getElementById("task30n").classList.add("a")}
	if(60<=x){document.getElementById("task60n").classList.add("a")}
	if(100<=x){document.getElementById("task100n").classList.add("a")}
	if(180<=x){document.getElementById("task180n").classList.add("a")}
	if(365<=x){document.getElementById("task365n").classList.add("a")}
	if(555<=x){document.getElementById("task555n").classList.add("a")}
	if(777<=x){document.getElementById("task777n").classList.add("a")}
	if(1000<=x){document.getElementById("task1000n").classList.add("a")}




}








