<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forza</title>
<link rel="stylesheet" type="text/css" href="/Forza/css/style.css">
</head>
<body>
<div class="table-center">
<h1 id="logo">
            <img src="/Forza/images/Forza_trans.png" alt="home">
        </h1>
<h2>IDとPWの新規登録</h2>
<form method="POST" action="/Forza/RegisterServlet">
<table>
 <tr>
  <td>
<label>ID<br><input type="text" name="id"><br>
</label>
  </td>
  <td>
<label>PW<br><input type="password" name="password"><br>
</label>
 </td>
  </tr>
   </table>
     <input type="submit">
     <input type="reset" name="reset" value="リセット">
</form>
<a href="/Forza/LoginServlet">メニューへ戻る</a>
<!-- フッター（ここから） -->
        <div id="footer">
        </div>
        <!-- フッター（ここまで） -->
        </div>
</body>
</html>