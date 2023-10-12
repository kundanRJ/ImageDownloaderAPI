import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ImageDownloader {
    public static void main(String[] args) {
        String folderPath = "your_folder_path_here";
        String apiUrl = "your_api_url_here";

        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(apiUrl);
            HttpResponse response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                String jsonResponse = EntityUtils.toString(response.getEntity());
                List<String> imageUrls = parseImageUrlsFromJson(jsonResponse);

                for (String imageUrl : imageUrls) {
                    downloadImage(imageUrl, folderPath);
                }
            } else {
                System.err.println("API request failed with status code: " + response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> parseImageUrlsFromJson(String jsonResponse) {
        // Parse the JSON response to extract image URLs and return them as a list.
        // You can use a JSON parsing library like Jackson or Gson for this.
        // Example: Gson.fromJson(jsonResponse, List.class);
        // Return a list of image URLs.
        return null;
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
