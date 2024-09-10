import java.sql.*;

public class Demo {
    public static void main(String[] args) {
        String sql = "SELECT * FROM \"cart-items\" WHERE cart_id = 1";
        String url = "jdbc:postgresql://localhost:5433/user";  //here 5433 is port and user is database in postgres inside the cart-items table
        String username = "postgres";
        String password = "123";

        try {
            //Create connection
            Connection con = DriverManager.getConnection(url, username, password);

            //Create Statement
            Statement st = con.createStatement();

            //Execute Query
            ResultSet rs = st.executeQuery(sql);

            boolean found = false;
            while (rs.next()) {
                int cartId = rs.getInt("item_id");
                String itemName = rs.getString("name");
                System.out.println("Cart ID: " + cartId + ", Item Name: " + itemName);
                found = true;
            }

            if (!found) {
                System.out.println("Data not found ");
            }

            // Close resources
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
