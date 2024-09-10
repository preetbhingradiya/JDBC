import java.sql.*;

public class ConnectionClass {

    private String DBName = "";
    String url ;
    String username = "postgres";
    String password = "123";

    public ConnectionClass(String DBName){
        this.DBName = DBName;
        this.url = "jdbc:postgresql://localhost:5433/" + DBName;
    }

    public Statement getConnection(){
        Statement st = null;
        try{
            Connection cq = DriverManager.getConnection(url, username, password);

            st = cq.createStatement();
        }catch(SQLException e){
            System.out.println(e);
        }

        return st;
    }

    public ResultSet  getExecuteQuery(String url){
        ResultSet res = null;
        try{
            res = getConnection().executeQuery(url);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }


    public  PreparedStatement getExecutePreparedQuery(String sql){
        PreparedStatement res = null;
        try{
            Connection cq = DriverManager.getConnection(url, username, password);

            res = cq.prepareStatement(sql);
        }catch(SQLException e){
            System.out.println(e);
        }

        return res;
    }
}
