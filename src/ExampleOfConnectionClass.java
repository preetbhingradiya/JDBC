import java.sql.ResultSet;
import java.sql.Statement;

public class ExampleOfConnectionClass {
    public static void main(String[] args){
//        String sql = "SELECT * FROM \"cart-items\" WHERE cart_id = 1";
        String sql = "SELECT * FROM \"student\"";
        try{
            ConnectionClass cq = new ConnectionClass("postgres");

            ResultSet response = cq.getExecuteQuery(sql);
            if(response != null){
                while (response.next()) {
//                    int cartId = response.getInt("item_id");
//                    String itemName = response.getString("name");
//                    System.out.println("Cart ID: " + cartId + ", Item Name: " + itemName);

                    int studentId = response.getInt("id");
                    String studentName = response.getString("name");
                    int studnetAge = response.getInt("age");
                    String studentCity = response.getString("city");

                    System.out.println("ID: " + studentId + ", Name: " + studentName + ", Age : " + studnetAge + ", city : " + studentCity);
                }
                response.close();
            }

            System.out.println("Execute the Query !!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
