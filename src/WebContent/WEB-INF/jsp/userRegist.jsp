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
<<<<<<< HEAD
    <div class="bg">
    <div class="rogin">

    <div class="titlegazou">
        <img src="/Forza/images/Forza_trans.png" alt="home">
    </div>
    <div class="table-center">
        <form method="POST" action="/Forza/LoginServlet" id="login_form'">

           <div class="ID1">
                 ID(メール)
              <label><input type="text" name="ID"><br></label>
           </div>
           <div class="PW1">
                 PW
              <label><input type="password" name="PW"><br></label>
           </div>
           <div>
              <input type="submit" name="REGIST" value="新規登録">
           </div>
        </form>
    </div>
    </div>
    </div>


</body>
=======
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
>>>>>>> b8261d12d48a86cd3c7bd134d2d5e500b40651e9
