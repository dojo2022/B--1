<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forza</title>
<link rel="stylesheet" type="text/css" href="/Forza/css/login.css">
</head>
<body>
    <div class="bg">
    <div class="rogin">

    <div class="titlegazou">
        <img src="/Forza/images/Forza_trans.png" alt="home">
    </div>
    <div class="table-center">
        <form method="POST" action="/Forza/RegisterServlet" id="login_form'">

           <div class="ID1">
                 ID(メール)
              <label><input type="text" name="id"><br></label>
           </div>
           <div class="PW1">
                 PW
              <label><input type="password" name="password"><br></label>
           </div>
           <div>
              <input type="submit" name="REGIST" value="新規登録">
           </div>
        </form>
    </div>
    </div>
    </div>
</body>
