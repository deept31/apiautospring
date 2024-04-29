import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GetBookingIds3 {

    public static void main(String[] args) {

        final String url = "http://restful-booker.herokuapp.com/booking";
        RestTemplate restTemplate = new RestTemplate();

        // create URI with query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("checkin", "2018-01-01")
                .queryParam("checkout", "2019-01-01");

        // send GET request
        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);

        // check response status code
        if (response.getStatusCodeValue() == 200) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed. Status Code: " + response.getStatusCodeValue());
        }
    }
}

