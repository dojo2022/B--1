//タスク追加・編集のポップアップに関するJS

const popup = document.getElementById('popup'); //＋ボタン
    const close = document.getElementById('close'); //「閉じる」ボタン
    const popWin = document.getElementById('popWin'); //ポップアップしてくるウィンドウ(登録画面)
    popup.addEventListener('click', () => {
    popWin.style.display = 'flex';
    });
    close.addEventListener('click', () => {
    popWin.style.display = 'none';
    });




    <script>
    const popup = document.getElementById('popup');
    const close = document.getElementById('close');
    const popWin = document.getElementById('popWin');
    popup.addEventListener('click', () => {
    popWin.style.display = 'flex';
    });
    close.addEventListener('click', () => {
    popWin.style.display = 'none';
    });
</script>