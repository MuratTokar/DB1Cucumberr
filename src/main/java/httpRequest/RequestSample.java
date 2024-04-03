package httpRequest;
import org.junit.Test;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class RequestSample {
    @Test
    public void test() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://reqres.in/api/users?page=2"))
                .GET()
                .build();
        HttpClient client=HttpClient.newHttpClient();// client hazir olan request i gönderecek

        HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // karsidan gelecekler icin ,Yani value ler icin
        System.out.println(response.body());

    }
}
