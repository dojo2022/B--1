<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forza</title>
<link rel="stylesheet" type="text/css" href="/Forza/css/result.css">
<meta name="description"  content="書籍「動くWebデザインアイディア帳」のサンプルサイトです">

<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--==============レイアウトを制御する独自のCSSを読み込み===============-->
<link rel="stylesheet" type="text/css" href="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/reset.css">
<link rel="stylesheet" type="text/css" href="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/6-3-1/css/6-3-1.css">
</head>
<body>
<header id="header">
  <h1>Forza</h1>
    <div id="video-area">
  <video id="video" poster="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/6-3-1/img/movie.jpg" webkit-playsinline playsinline muted autoplay loop>
    <!--
        poster：動画ファイルが利用できない環境で代替表示される画像
        webkit-playsinline：iOS 9までのSafari用インライン再生指定
        playsinline：iOS 10以降のSafari用インライン再生指定
        muted：音声をミュートさせる
        autoplay：動画を自動再生させる
        loop：動画をループさせる
        controls：コントロールバーを表示する
    -->
  <source src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/6-3-1/video/movie.mp4" type="video/mp4">
  <source src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/6-3-1/video/movie.ogv" type="video/ogv">
  <source src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/6-3-1/video/movie.webm" type="video/webm">
  <p>動画を再生できる環境ではありません。</p>
  </video>
    <!--/video-area--></div>
</header>
<div class="resu">
<p><c:out value="${result.message}" /></p>
</div>
<div class="back">
<a href="${result.backTo}">戻る</a>
</div>

</body>
</html>