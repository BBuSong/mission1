<%@page import="db.Zero"%>
<%@page import="java.util.List"%>
<%@page import="db.ZeroMission1DBTest"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	table {
		width: 100%;
	}
		th, td {
		border:solid 1px #000;
		}
	</style>
</head>


<body>
		<% 
		String memberType = request.getParameter("memberType");
		String userId = request.getParameter("userId");
		
		ZeroMission1DBTest zeroMission1DBTest = new ZeroMission1DBTest();
		Zero zero = zeroMission1DBTest.detail(memberType, userId);
		%>
	<h1>회원 상세</h1>
	<table>
	<colgroup>
		<col style="width:20%;"/>
		<col style="width:80%;"/>
	</colgroup>
		<tbody>
			<tr>
				<th>회원구분</th>
				<td>
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
				</td>
			</tr>
			
		</tbody>
	</table>


</body>
</html>