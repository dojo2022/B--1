//褒めるポップアップの
//閉じるボタン（チェックの画像）に関するJS

const close = document.getElementById('close');
close.addEventListener('click', () => {
popWin.style.display = 'none';
});

//カスタムセット編集のJSファイルがないため一時ここに（長崎）
//ハンバーガーメニューボタン
$(function() {
    $('.hamburger').click(function() {
        $(this).toggleClass('active');

        if ($(this).hasClass('active')) {
            $('.globalMenuSp').addClass('active');
        } else {
            $('.globalMenuSp').removeClass('active');
        }
    });
});