import java.sql.*;

public class InserTable {

    public static void main(String[] aregs){
        String sql = "CREATE TABLE \"student\" (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(20), " +
                "age INT, " +
                "city VARCHAR(50)" +
                ")";

        String url = "jdbc:postgresql://localhost:5433/postgres";  //here 5433 is port and user is database in postgres inside the cart-items table
        String username = "postgres";
        String password = "123";

        try{
            Connection cq = DriverManager.getConnection(url, username, password);

            Statement st = cq.createStatement();

            int res = st.executeUpdate(sql);

            System.out.println(res);
            System.out.println("Table is created");

            cq.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
