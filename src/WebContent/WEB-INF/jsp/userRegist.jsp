<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
  <meta charset="UTF-8">
  <title>Forza</title>
  <link rel="stylesheet" type="text/css" href="/Forza/css/login.css">
<body>
    <div class="bg">
    <div class="rogin">

    <div class="titlegazou">
        <img src="/Forza/images/Forza_trans.png" alt="home">
    </div>
    <div class="table-center">
        <form method="POST" action="/Forza/LoginServlet" id="login_form'">

           <div class="ID">
                 ID(メール)
              <label><input type="text" name="ID"><br></label>
           </div>
           <div class="PW">
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