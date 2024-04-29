import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetBookingIds {

    public static void main(String[] args) {

        final String url = "http://restful-booker.herokuapp.com/booking";
        RestTemplate restTemplate = new RestTemplate();

        // send GET request
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // check response status code
        if (response.getStatusCodeValue() == 200) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed. Status Code: " + response.getStatusCodeValue());
        }
    }
}

