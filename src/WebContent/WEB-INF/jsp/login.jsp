<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Forza</title>
  <link rel="stylesheet" type="text/css" href="/Forza/css/login.css">
</head>
<body>
<div class="table-center">
<form method="POST" action="/Forza/LoginServlet" id="login_form'">
  <table>
   <tr>
      <td>
         ID(メール)<br>
      </td>
      <td><label><input type="text" name="ID"><br></label></td>
   </tr>
   <tr>
      <td>PW<br>
      </td>
      <td>
         <label>
           <input type="password" name="PW"><br>
         </label>
      </td>
   </tr>
  </table>
 <input type="submit" name="LOGIN" value="ログイン">
 <span id="error_message"></span>
</form>
<a href="/Forza/RegisterServlet">新規登録はこちら</a>
</div>
</body>
</html>