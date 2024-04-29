import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadDataFromJSONusingGson {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("C://Users//VZ724WP//Downloads//employee.json");

        Gson gson = new Gson();
        Employee emp = gson.fromJson(reader,Employee.class);

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
