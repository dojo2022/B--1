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
        <form method="POST" action="/Forza/RegisterServlet" id="login_form'">

			<table align = "center">
				<tr>
					<td><label><b class="idpw">ID</b></label></td>
					<td><input type="text" name="id" class="m-form-text1"></td>
					<td><label><b class="idpw">PW</b></label></td>
					<td><input type="password" name="password" class="m-form-text1"></td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				<tr><td colspan="4"><input type="submit" name="REGIST" value="新規登録"></td></tr>
			</table>
        </form>

    </div>
</body>
