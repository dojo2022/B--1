//カスタムセットのタグをクリックしたときの動作

$(function(){
	$('.clickableTitle').on('click',(e) => {
		console.log('click');
		$(e.currentTarget).nextAll('.hiddenLine').slideToggle(500);
	});
});
