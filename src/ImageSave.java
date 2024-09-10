import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageSave {

    public  static void main(String[] args){
        try {
            String sql = "INSERT INTO \"image-data\" (pic) VALUES (?)";

            ConnectionClass cq  = new ConnectionClass("postgres");

            PreparedStatement pstmt = cq.getExecutePreparedQuery(sql);

            //give file choose from documents
            JFileChooser fileChoose = new JFileChooser();
            fileChoose.showOpenDialog(null);
            File file = fileChoose.getSelectedFile();

            FileInputStream fd = new FileInputStream(file);

//          FileInputStream fd = new FileInputStream("/home/crawlapps/Downloads/images.png");
            pstmt.setBinaryStream(1, fd, fd.available());

            pstmt.executeUpdate();

            pstmt.close();

            System.out.println("Image is Add.");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
