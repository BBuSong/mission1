package oa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class OAList {
	
	public void main(String[] args) {
	
		
		String key = "6867596a6564643336307556536879";
		String result = "";
		
	
		try {
		URL url = new URL("http://openapi.seoul.go.kr:8088/" + key + "/json/TbPublicWifiInfo/1/1000/");
		
		BufferedReader bf;
		
		bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		result = bf.readLine();
		
		System.out.println(result);
		
		JSONParser jP = new JSONParser();
		JSONObject jsonObject = (JSONObject)jP.parse(result);
		JSONObject TbPublicWifiInfo = (JSONObject)jsonObject.get("TbPublicWifiInfo");
		JSONArray row = (JSONArray)TbPublicWifiInfo.get("row");
		
		
		String X_SWIFI_MGR_NO = "";
		String X_SWIFI_WRDOFC = "";
		String X_SWIFI_MAIN_NM = "";
		String X_SWIFI_ADRES1 = "";
		String X_SWIFI_ADRES2 = "";
		String X_SWIFI_INSTL_FLOOR = "";
		String X_SWIFI_INSTL_TY = "";
		String X_SWIFI_INSTL_MBY = "";
		String X_SWIFI_SVC_SE = "";
		String X_SWIFI_CMCWR = "";
		String X_SWIFI_CNSTC_YEAR = "";
		String X_SWIFI_INOUT_DOOR = "";
		String X_SWIFI_REMARS3 = "";
		String LNT = "";
		String LAT = "";
		String WORK_DTTM = "";
		
		


		String url1 = "jdbc:mariadb://localhost:3305/mission1";
	    String dbUserId = "mission1";
	    String dbPassword = "mission";
	    

	    try {
	        Class.forName("org.mariadb.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;


	    try {
	        connection = DriverManager.getConnection(url1, dbUserId, dbPassword);


	        String sql = "insert into wifi " +
	        		" (X_SWIFI_MGR_NO , X_SWIFI_WRDOFC , X_SWIFI_MAIN_NM , X_SWIFI_ADRES1 ,X_SWIFI_ADRES2 " +
	                ", X_SWIFI_INSTL_FLOOR , X_SWIFI_INSTL_TY , X_SWIFI_INSTL_MBY , X_SWIFI_SVC_SE , X_SWIFI_CMCWR " +
	                ", X_SWIFI_CNSTC_YEAR , X_SWIFI_INOUT_DOOR , X_SWIFI_REMARS3 , LAT , LNT , WORK_DTTM) " +
	                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";


			ps = connection.prepareStatement(sql);
	        
	        
		
	
			for (int i = 0; i < row.size(); i++) {
			JSONObject row_X_SWIFI_MGR_NO = (JSONObject)row.get(i);
			X_SWIFI_MGR_NO = String.valueOf(row_X_SWIFI_MGR_NO.get("X_SWIFI_MGR_NO"));
			
			JSONObject row_X_SWIFI_WRDOFC = (JSONObject)row.get(i);		
			X_SWIFI_WRDOFC = row_X_SWIFI_WRDOFC.get("X_SWIFI_WRDOFC") + " ";
			
			JSONObject row_X_SWIFI_MAIN_NM = (JSONObject)row.get(i);
			X_SWIFI_MAIN_NM = row_X_SWIFI_MAIN_NM.get("X_SWIFI_MAIN_NM") + " ";
			
			JSONObject row_X_SWIFI_ADRES1 = (JSONObject)row.get(i);
			X_SWIFI_ADRES1 = row_X_SWIFI_ADRES1.get("X_SWIFI_ADRES1") + " ";
			
			JSONObject row_X_SWIFI_ADRES2 = (JSONObject)row.get(i);
			X_SWIFI_ADRES2 = row_X_SWIFI_ADRES2.get("X_SWIFI_ADRES2") + " ";
			
			JSONObject row_X_SWIFI_INSTL_FLOOR = (JSONObject)row.get(i);
			X_SWIFI_INSTL_FLOOR = row_X_SWIFI_INSTL_FLOOR.get("X_SWIFI_INSTL_FLOOR") + " ";
			
			JSONObject row_X_SWIFI_INSTL_TY = (JSONObject)row.get(i);
			X_SWIFI_INSTL_TY = row_X_SWIFI_INSTL_TY.get("X_SWIFI_INSTL_TY") + " ";
			
			JSONObject row_X_SWIFI_INSTL_MBY = (JSONObject)row.get(i);
			X_SWIFI_INSTL_MBY = row_X_SWIFI_INSTL_MBY.get("X_SWIFI_INSTL_MBY") + " ";
			
			JSONObject row_X_SWIFI_SVC_SE = (JSONObject)row.get(i);
			X_SWIFI_SVC_SE = row_X_SWIFI_SVC_SE.get("X_SWIFI_SVC_SE") + " ";
			
			JSONObject row_X_SWIFI_CMCWR = (JSONObject)row.get(i);
			X_SWIFI_CMCWR = row_X_SWIFI_CMCWR.get("X_SWIFI_CMCWR") + " ";
			
			JSONObject row_X_SWIFI_CNSTC_YEAR = (JSONObject)row.get(i);
			X_SWIFI_CNSTC_YEAR = row_X_SWIFI_CNSTC_YEAR.get("X_SWIFI_CNSTC_YEAR") + " ";
			
			JSONObject row_X_SWIFI_INOUT_DOOR = (JSONObject)row.get(i);
			X_SWIFI_INOUT_DOOR = row_X_SWIFI_INOUT_DOOR.get("X_SWIFI_INOUT_DOOR") + " ";
			
			JSONObject row_X_SWIFI_REMARS3 = (JSONObject)row.get(i);
			X_SWIFI_REMARS3 = row_X_SWIFI_REMARS3.get("X_SWIFI_REMARS3") + " ";
			
			JSONObject row_LNT = (JSONObject)row.get(i);
			LNT = row_LNT.get("LNT") + " ";
			
			JSONObject row_LAT = (JSONObject)row.get(i);
			LAT = row_LAT.get("LAT") + " ";
			
			JSONObject row_WORK_DTTM = (JSONObject)row.get(i);
			WORK_DTTM = row_WORK_DTTM.get("WORK_DTTM") + " ";
			
			/*
			System.out.println("관리번호: " + X_SWIFI_MGR_NO);
			System.out.println("자치구: " + X_SWIFI_WRDOFC);
			System.out.println("와이파이명: " + X_SWIFI_MAIN_NM);
			System.out.println("도로명주소: " + X_SWIFI_ADRES1);
			System.out.println("상세주소: " + X_SWIFI_ADRES2);
			System.out.println("설치위치(층) : " + X_SWIFI_INSTL_FLOOR);
			System.out.println("설치유형: " + X_SWIFI_INSTL_TY);
			System.out.println("설치기관: " + X_SWIFI_INSTL_MBY);
			System.out.println("서비스구분: " + X_SWIFI_SVC_SE);
			System.out.println("망종류: " + X_SWIFI_CMCWR);
			System.out.println("설치년도: " + X_SWIFI_CNSTC_YEAR);
			System.out.println("실내외구분: " + X_SWIFI_INOUT_DOOR);
			System.out.println("WIFI접속환경: " + X_SWIFI_REMARS3);
			System.out.println("X좌표: " + LNT);
			System.out.println("Y좌표: " + LAT);
			System.out.println("작업일자: " + WORK_DTTM);
			*/
			
			//System.out.println(list);
			
			
			ps.setString(1, X_SWIFI_MGR_NO);
	        ps.setString(2, X_SWIFI_WRDOFC); 
	        ps.setString(3, X_SWIFI_MAIN_NM); 
	        ps.setString(4, X_SWIFI_ADRES1); 
	        ps.setString(5, X_SWIFI_ADRES2); 
	        ps.setString(6, X_SWIFI_INSTL_FLOOR); 
	        ps.setString(7, X_SWIFI_INSTL_TY); 
	        ps.setString(8, X_SWIFI_INSTL_MBY); 
	        ps.setString(9, X_SWIFI_SVC_SE); 
	        ps.setString(10, X_SWIFI_CMCWR); 
	        ps.setString(11, X_SWIFI_CNSTC_YEAR); 
	        ps.setString(12, X_SWIFI_INOUT_DOOR); 
	        ps.setString(13, X_SWIFI_REMARS3); 
	        ps.setString(15, LNT); 
	        ps.setString(14, LAT); 
	        ps.setString(16, WORK_DTTM);


	       
	        
			
			//list = new ArrayList<>();
			}
			
			int affected = ps.executeUpdate();

	        if (affected > 0) {
	            System.out.println("23343개의 WIFI 정보를 정상적으로 저장했습니다.");
	        }
	        else {
	            System.out.println("저장 실패");
	        }
			
			
		 } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    finally {


		        try {
		            if (rs != null && !rs.isClosed()) {
		                rs.close();
		            }
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }

		        try {
		            if (ps != null && !ps.isClosed()) {
		            	ps.close();
		            }
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }

		        try {
		            if (connection != null && !connection.isClosed()) {
		                connection.close();
		            }
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }

		    }
		
		
			
		
		
		
		
		// System.out.println(list);
		//System.out.println("관리번호: " + X_SWIFI_MGR_NO);
		/*
		System.out.println("자치구: " + X_SWIFI_WRDOFC);
		System.out.println("와이파이명: " + X_SWIFI_MAIN_NM);
		System.out.println("도로명주소: " + X_SWIFI_ADRES1);
		System.out.println("상세주소: " + X_SWIFI_ADRES2);
		System.out.println("설치위치(층) : " + X_SWIFI_INSTL_FLOOR);
		System.out.println("설치유형: " + X_SWIFI_INSTL_TY);
		System.out.println("설치기관: " + X_SWIFI_INSTL_MBY);
		System.out.println("서비스구분: " + X_SWIFI_SVC_SE);
		System.out.println("망종류: " + X_SWIFI_CMCWR);
		System.out.println("설치년도: " + X_SWIFI_CNSTC_YEAR);
		System.out.println("실내외구분: " + X_SWIFI_INOUT_DOOR);
		System.out.println("WIFI접속환경: " + X_SWIFI_REMARS3);
		System.out.println("X좌표: " + LNT);
		System.out.println("Y좌표: " + LAT);
		System.out.println("작업일자: " + WORK_DTTM);
		
		*/
		
		// System.out.println(X_SWIFI_MGR_NO.getClass().getName());
		
		
			
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

	
		
	


