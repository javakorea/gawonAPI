<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="cm/js/jquery-3.7.1.min.js"></script>
<script>
	var ajax = {};
	ajax.load = function(_id,_url,_data){
		$('#'+_id).load(_url,_data,function(){
		})
	};
	$(document).ready(function(){
		ajax.load("myAcademyList", "/sec/xhr/mypage/digitalplaza/academy/getMyAcademyList", {a:"12", b:"abc"})
	});
	
</script>
</head>
<body>
	<h3 id="main">안녕하세요</h3>
	<div id = "myAcademyList">
	
	</div>
</body>
</html>