import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {

    public static void main(String[] args){
       String sql = "UPDATE \"student\" SET age = ?, city = ? WHERE id = ?";
        try {
            ConnectionClass cq = new ConnectionClass("postgres");

            PreparedStatement st = cq.getExecutePreparedQuery(sql);

            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your Age : " );
            int age = Integer.parseInt(br.readLine());

            System.out.print("Enter your City : " );
            String city = br.readLine();

            System.out.print("Enter your id : " );
            int id = Integer.parseInt(br.readLine());

            st.setInt(1, age);
            st.setString(2, city);
            st.setInt(3, id);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("Data not found for ID: " + id);
            }

        } catch (IOException | SQLException e) {
            System.out.println(e);
        }
    }
}
