
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ImageDownloader {
    public static void main(String[] args) {
        String folderPath = "your_folder_path_here";
        
       
        try {
        	Connection connection = DriverManager.getConnection("jdbc:your_db_connection_string_here");
                     Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT image_url FROM your_table_name")) {
            
            while (resultSet.next()) {
                String imageUrl = resultSet.getString("image_url");
                downloadImage(imageUrl, folderPath);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void downloadImage(String imageUrl, String folderPath) {
        try {
            URL url = new URL(imageUrl);
            try (InputStream in = url.openStream();
                 OutputStream out = new FileOutputStream(folderPath + File.separator + "image.jpg")) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
