import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class APIAutomationUsingSpringBoot {

    private static final String BASE_URL = "http://restful-booker.herokuapp.com";
    private static final String AUTH_ENDPOINT = "/auth";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Create request body
        String requestBody = "{\"username\": \"admin\", \"password\": \"password123\"}";

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create HTTP entity
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Send POST request to /auth/login
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + AUTH_ENDPOINT, entity, String.class);

        // Extract token from response (assuming it's in a JSON format)
        String token = response.getBody();

        // Now you can use this token for other authenticated requests.
        // For example, to create a room:
        // String createRoomEndpoint = "/room";
        // HttpHeaders roomHeaders = new HttpHeaders();
        // roomHeaders.set("Cookie", "token=" + token);
        // HttpEntity<String> roomEntity = new HttpEntity<>(roomRequestBody, roomHeaders);
        // ResponseEntity<String> roomResponse = restTemplate.postForEntity(BASE_URL + createRoomEndpoint, roomEntity, String.class);
        // ...

        System.out.println("Token: " + token);
    }
}
