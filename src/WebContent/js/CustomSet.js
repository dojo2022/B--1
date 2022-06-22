//カスタムセットのタグをクリックしたときの動作

$(function(){
	$('.clickableTitle').on('click',(e) => {
		$(e.currentTarget).nextAll('.hiddenLine').slideToggle(500);
	});
});
