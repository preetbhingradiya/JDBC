import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class InsertData {

    public  static void main(String[] args){
        String sql = "INSERT INTO  \"student\" (name, age, city) VALUES (?, ?, ?)";

        try{
            ConnectionClass cq = new ConnectionClass("postgres");

            PreparedStatement pstmt = cq.getExecutePreparedQuery(sql);

//            if(pstmt != null){
//                pstmt.setString(1, "vikash");
//                pstmt.setInt(2, 12);;
//                pstmt.setString(3, "vapi");
//
//                pstmt.executeUpdate();
//                System.out.println("Insert data into table");
//                pstmt.close();
//            }else{
//                System.out.println("Something went wrong");
//            }



            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your name  : ");
            String name = br.readLine();

            System.out.println("Enter Your Age  : ");
            int age = Integer.parseInt(br.readLine());

            System.out.println("Enter Your City  : ");
            String city = br.readLine();

            if(pstmt != null){
                pstmt.setString(1, name);
                pstmt.setInt(2, age);;
                pstmt.setString(3, city);

                pstmt.executeUpdate();
                System.out.println("Insert data into table");
                pstmt.close();
            }else{
                System.out.println("Something went wrong");
            }
        }catch (SQLException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}
