import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
    public class ReadDataFromJSONusingSimpleJSON {
        public static void main(String[] args) throws IOException, ParseException {

            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("C://Users//VZ724WP//Downloads//employee.json");
            //Object obj = jsonParser.parse(reader);
            //JSONObject empjsonobj = (JSONObject)obj;

            JSONObject empjsonobj = (JSONObject)jsonParser.parse(reader);
            String fname = (String) empjsonobj.get("firstName");
            String lname = (String) empjsonobj.get("lastName");
           // System.out.println("First Name : " + fname);
           // System.out.println("Last Name : " + lname);

            JSONArray addressArray = (JSONArray) empjsonobj.get("address");
            for(int i=0;i<addressArray.size();i++){
                JSONObject address = (JSONObject)addressArray.get(i);
                //String street = (String) address.get("street");
                String city = (String) address.get("city");
                if(city.equalsIgnoreCase("Chennai")){
                    String street = (String) address.get("street");
                    System.out.println("street: " + street + " for city: " + city   );
                }
                //String state = (String) address.get("state");

                //System.out.println(street + "\t" + city + "\t" + state);
            }
    }
    }
