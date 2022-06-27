<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
  <meta charset="UTF-8">
  <title>Forza</title>
  <link rel="stylesheet" type="text/css" href="/Forza/css/login.css">
</head>
<body>


    <div class="titlegazou">
        <img src="/Forza/images/title2.png" alt="home" class="forzagazou">
    </div>


    <div class="table-center">
        <form method="POST" action="/Forza/LoginServlet" id="login_form'">

           <table align = "center">
           	<tr>
           		<td><label>ID</label></td>
           		<td><input type="text" name="ID" class="m-form-text"></td>
           		<td><label>PW</label></td>
           		<td><input type="password" name="PW" class="m-form-text"></td>
           </tr>
           <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
           <tr><td colspan="4"><input type="submit" name="LOGIN" value="ログイン"></td>
           </tr>
            <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>

           </table>
        </form>


              <a href="/Forza/RegisterServlet" class="new">新規登録はこちら</a>
    </div>


</body>
</html>