<%@page import="oa.OAList"%>
<%@page import="oa.ApiList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="oa.Apidata"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
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
	<h1>와이파이 정보 구하기</h1>
	
	<%
		OAList oal = new OAList();
		
	%>
	
	<div>
		<a href="mission1_1.jsp">홈 |</a>
		<a href="history.jsp"> 위치 히스토리 목록 |</a>
		<a href="openAPI.jsp"> Open API 와이파이 정보 가져오기 |</a>
		
		
			<% 
			
			
				
			%>
				
				<tr>
				<td>  </td>
				<td> </td>
				<td>
					<a href="detail.jsp?X_SWIFI_MAIN_NM()=<%=oal.toString()%>"> 
					 
					</a>
				</td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				</tr>
				
				
				
			
			
		
		<a href="lookBook.jsp"> 북마크 보기 |</a>
		<a href="setBook.jsp"> 북마크 그룹 관리</a>
		
		
	</div>
	
	<div>
	<p>LAT:<input id = 'name' onkeyup='printName()'></p> <p>LNT:<input id = 'name' onkeyup='printName()'/></p>
	<div id = 'result'></div> <div id = 'result'></div>
	</div>
	
	
		<a href="whereIam.jsp">내 위치 가져오기 |</a>
		<a href="wifiCall.jsp"> 근처 WIFI 정보 보기</a>
	
	<table>
		<thread>
			<tr>
				<th>거리(Km)</th>
				<th>관리번호</th>
				<th>자치구</th>
				<th>와이파이명</th>
				<th>도로명주소</th>
				<th>상세주소</th>
				<th>설치위치(층)</th>
				<th>설치유형</th>
				<th>설치기관</th>
				<th>서비스구분</th>
				<th>망종류</th>
				<th>설치년도</th>
				<th>실내외구분</th>
				<th>WIFI접속환경</th>
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>작업일자</th>
			</tr>
			<tbody>
			<tr>
				
				
			</tr>
			</tbody>
		</thread>
	</table>

</body>
</html>