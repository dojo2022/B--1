<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forza</title>
<link rel="stylesheet" type="text/css" href="/Forza/css/result.css">
</head>
<body>

<div class="resu">
<p><c:out value="${result.message}" /></p>
</div>
<div class="back">
<a href="${result.backTo}">戻る</a>
</div>

</body>
</html>