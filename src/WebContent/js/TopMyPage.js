'use strict';

    function displayChange(){
        //対象パネルを取得する
	$panel = $("#displayPanel");
	//現在の状態を取得し、ボタンを変更する
	//styleのdisplayがnoneの時は非表示、として判定する
	var isHidden = $("#displayPanel").css("display") == 'none';
        if(isHidden){
            $('#displayChangeButton').val('close');
        }else{
            $('#displayChangeButton').val('open');
        }
	$panel.toggle(700);
    }