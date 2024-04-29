import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ApiAutomationCreateBooking {

    public static void main(String[] args) {

        final String url = "http://restful-booker.herokuapp.com/booking";
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");

        // create request body
        String requestBody = "{ \"firstname\" : \"Jim\", \"lastname\" : \"Brown\", \"totalprice\" : 111, \"depositpaid\" : true, \"bookingdates\" : { \"checkin\" : \"2018-01-01\", \"checkout\" : \"2019-01-01\" }, \"additionalneeds\" : \"Breakfast\" }";

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
