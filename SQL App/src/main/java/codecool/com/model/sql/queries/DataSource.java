package codecool.com.model.sql.queries;

import java.sql.*;

public class DataSource {
    private String url;
    private String driverName;

    public DataSource(){
        this.url = "jdbc:postgresql://localhost:5432/test";
//        this.url = "jdbc:postgresql://manny.db.elephantsql.com:5432/tuurtwbr";
        this.driverName = "org.postgresql.Driver";
    }
    private Connection con;
    private Statement stmt = null;
    private ResultSet rs = null;

    public Connection getConnection() {
        try {

            Class.forName(driverName);
            con = DriverManager.getConnection(url,"kamkik", "e97jco");
//            System.out.println("Connection Successful");

        }
        catch (SQLException ex) {
            System.out.println("Failed to create the database connection.");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }
        return con;
    }

    public ResultSet executeQuery(String sql){
        DataSource ds = new DataSource();
        this.con = ds.getConnection();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
//
//    public void updateQuery(String sql){
//        DataSource ds = new DataSource();
//        this.con = ds.getConnection();
//        try {
//            stmt = con.createStatement();
//            stmt.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void close(){
//        try {
//            con.close();
//            stmt.close();
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
