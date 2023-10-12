package imagePkg;

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
        String folderPath = "C:\\Users\\bunty\\Pictures\\Camera Roll";
        
       
       
                downloadImage("file:///C:/Users/bunty/Pictures/WhatsApp%20Image%202023-08-20%20at%2021.33.24.jpeg", folderPath);
           
        }
    

    public static void downloadImage(String imageUrl, String folderPath) {
        try {
                 int i=1;
            URL url = new URL(imageUrl);
            System.out.println("run 1");
            try (InputStream in = url.openStream();              
            		 
                 OutputStream out = new FileOutputStream(folderPath + File.separator + "image"+(i++)+" "+".jpg")) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                    System.out.println("run 2");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
