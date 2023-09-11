package oa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import db.Zero;
import oa.OA;
import oa.Apidata;
import oa.ApiList;

public class ApiList {
	public List<Apidata> list () {
        String url = "jdbc:mariadb://localhost:3305/mission1";
        String dbUserId = "mission1";
        String dbPassword = "mission";
        
        List<Apidata> list = new ArrayList<>();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "select X_SWIFI_MGR_NO , X_SWIFI_WRDOFC , X_SWIFI_MAIN_NM , X_SWIFI_ADRES1 ,X_SWIFI_ADRES2 " +
                    ", X_SWIFI_INSTL_FLOOR , X_SWIFI_INSTL_TY , X_SWIFI_INSTL_MBY , X_SWIFI_SVC_SE , X_SWIFI_CMCWR " +
                    ", X_SWIFI_CNSTC_YEAR , X_SWIFI_INOUT_DOOR , X_SWIFI_REMARS3 , LAT , LNT , WORK_DTTM " +
                    "from wifi; ";

            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Apidata ad = new Apidata();
                ad.setX_SWIFI_MGR_NO(rs.getString("X_SWIFI_MGR_NO"));
                ad.setX_SWIFI_WRDOFC(rs.getString("X_SWIFI_WRDOFC"));;
                ad.setX_SWIFI_MAIN_NM(rs.getString("X_SWIFI_MAIN_NM"));
                ad.setX_SWIFI_ADRES1(rs.getString("X_SWIFI_ADRES1"));
                ad.setX_SWIFI_ADRES2(rs.getString("X_SWIFI_ADRES2"));
                ad.setX_SWIFI_INSTL_FLOOR(rs.getString("X_SWIFI_INSTL_FLOOR"));
                ad.setX_SWIFI_INSTL_TY(rs.getString("X_SWIFI_INSTL_TY"));
                ad.setX_SWIFI_INSTL_MBY(rs.getString("X_SWIFI_INSTL_MBY"));
                ad.setX_SWIFI_SVC_SE(rs.getString("X_SWIFI_SVC_SE"));
                ad.setX_SWIFI_CMCWR(rs.getString("X_SWIFI_CMCWR"));
                ad.setX_SWIFI_CNSTC_YEAR(rs.getString("X_SWIFI_CNSTC_YEAR"));
                ad.setX_SWIFI_INOUT_DOOR(rs.getString("X_SWIFI_INOUT_DOOR"));;
                ad.setX_SWIFI_REMARS3(rs.getString("X_SWIFI_REMARS3"));
                ad.setLNT(rs.getString("LNT"));;
                ad.setLAT(rs.getString("LAT"));
                ad.setWORK_DTTM(rs.getString("WORK_DTTM"));
                list.add(ad);
            }
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return list;
    }



/*public void dbInsert(OAList oal) {
    String url = "jdbc:mariadb://localhost:3305/mission1";
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
        connection = DriverManager.getConnection(url, dbUserId, dbPassword);


        String sql = "insert into wifi " +
        		" (X_SWIFI_MGR_NO , X_SWIFI_WRDOFC , X_SWIFI_MAIN_NM , X_SWIFI_ADRES1 ,X_SWIFI_ADRES2 " +
                ", X_SWIFI_INSTL_FLOOR , X_SWIFI_INSTL_TY , X_SWIFI_INSTL_MBY , X_SWIFI_SVC_SE , X_SWIFI_CMCWR " +
                ", X_SWIFI_CNSTC_YEAR , X_SWIFI_INOUT_DOOR , X_SWIFI_REMARS3 , LAT , LNT , WORK_DTTM) " +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";


        ps = connection.prepareStatement(sql);
        
        
        
        for (int i = 0; i < row.size() ; i++) {
        
        ps.setString(1, oal.getX_SWIFI_WRDOFC());
        ps.setString(2, apidata.getX_SWIFI_WRDOFC()); 
        ps.setString(3, apidata.getX_SWIFI_MAIN_NM()); 
        ps.setString(4, apidata.getX_SWIFI_ADRES1()); 
        ps.setString(5, apidata.getX_SWIFI_ADRES2()); 
        ps.setString(6, apidata.getX_SWIFI_INSTL_FLOOR()); 
        ps.setString(7, apidata.getX_SWIFI_INSTL_TY()); 
        ps.setString(8, apidata.getX_SWIFI_INSTL_MBY()); 
        ps.setString(9, apidata.getX_SWIFI_SVC_SE()); 
        ps.setString(10, apidata.getX_SWIFI_CMCWR()); 
        ps.setString(11, apidata.getX_SWIFI_CNSTC_YEAR()); 
        ps.setString(12, apidata.getX_SWIFI_INOUT_DOOR()); 
        ps.setString(13, apidata.getX_SWIFI_REMARS3()); 
        ps.setString(15, apidata.getLNT()); 
        ps.setString(14, apidata.getLAT()); 
        ps.setString(16, apidata.getWORK_DTTM());


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
}
*/
}
