<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	table {
		width:100%;
	}
		th, td {
		border:solid 1px #000;}
	</style>
</head>
<body>
	<h1>위치 히스토리 목록</h1>
	
	<div>
		<a href="mission1_1.jsp">홈 |</a>
		<a href="history.jsp"> 위치 히스토리 목록 |</a>
		<a href="openAPI.jsp"> Open API 와이파이 정보 가져오기 |</a>
		<a href="openAPI.jsp"> 북마크 보기 |</a>
		<a href="openAPI.jsp"> 북마크 그룹 관리</a>
	</div>
	
	<table>
		<thread>
			<tr>
				<th>ID</th>
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>조회일자</th>
				<th>비고</th>
			</tr>
		</thread>
	</table>

</body>
</html>