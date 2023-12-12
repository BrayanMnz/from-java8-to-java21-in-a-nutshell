
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class TextBlock {

    public static void main(String[] args) {

        var body = """
                {
                "name": "From Java 8 to Java 21, in a nutshell.",
                "data": {
                "year": 2023,
                "price": 0.00,
                "talk": "From Java 8 to Java21, in a nutshell",
                "Speaker": "Brayan M."
                        }
                }
                """;

        try {
            postJSON("https://api.restful-api.dev/objects", body);

            //get("https://api.restful-api.dev/objects?id=ff8081818c01d7ae018c5fd93202640d");
        } catch (Exception e) {
            System.out.println("Something happens... " + e.getMessage());
        }
    }

    public static void postJSON(String uri, String body)
            throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<?> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code --> " + response.statusCode());

        System.out.println(" ===  BODY  === ");
        System.out.println(response.body());

    }

    public static void get(String uri) throws IOException, InterruptedException {

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("get-response.json")));

            System.out.println("Response saved to file named --> " + response.body());

        }
    }
}
