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
              <input type="submit" name="LOGIN" value="ログイン">
           </div>
        </form>
         <script>
      function pushHideButton() {
        var txtPass = document.getElementById("textPassword");
        var btnEye = document.getElementById("buttonEye");
        if (txtPass.type === "text") {
          txtPass.type = "password";
          btnEye.className = "fa fa-eye";
        } else {
          txtPass.type = "text";
          btnEye.className = "fa fa-eye-slash";
        }
      }
    </script>
           <div class="new">
              <a href="/Forza/RegisterServlet">新規登録はこちら</a>
    </div>
    </div>
    </div>
    </div>

</body>
</html>