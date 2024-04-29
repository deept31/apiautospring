import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJSONusingJackson {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("C://Users//VZ724WP//Downloads//employee.json");
        Employee emp = mapper.readValue(file,Employee.class);

        System.out.println("First Name : " + emp.getFirstName());
        System.out.println("Last Name : " + emp.getLastName());

        System.out.println("Addresses....");

        for(Address address:emp.getAddress()){
            System.out.println("Street:"+ address.getStreet());
            System.out.println("City:"+ address.getCity());
            System.out.println("State:"+ address.getState());
        }

    }
}
