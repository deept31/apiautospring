import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ApiAutomationApplication {

    public static void main(String[] args) {

        final String url = "http://restful-booker.herokuapp.com/auth";
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // create request body
        String requestBody = "{ \"username\" : \"admin\", \"password\" : \"password123\" }";

        // build the request
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // send POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        // check response status code
        if (response.getStatusCodeValue() == 200) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed. Status Code: " + response.getStatusCodeValue());
        }
    }
}
