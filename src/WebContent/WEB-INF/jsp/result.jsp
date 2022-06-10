<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forza</title>
<link rel="stylesheet" type="text/css" href="/Forza/css/style.css">
</head>
<body>

<h1><c:out value="${result.title}" /></h1>
<hr>
<div class="resu">
<p><h3><c:out value="${result.message}" /></h3></p>
</div>
<div class="back">
<a href="${result.backTo}">戻る</a>
</div>

</body>
</html>