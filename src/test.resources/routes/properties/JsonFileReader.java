package routes.properties;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileReader {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonparser=new JSONParser();
		FileReader reader=new FileReader("./src/test.resources/JsonTestData.json");
		Object obj=jsonparser.parse(reader);
		
		JSONObject empJsonObj =(JSONObject) obj;
		String firstName =(String) empJsonObj.get("firstName");
		String lastName =(String) empJsonObj.get("lastName");
		System.out.println("************firstName******** : "+firstName);
		System.out.println("************lastName******** : "+lastName);
		
		JSONArray array=(JSONArray) empJsonObj.get("address");
		
		for (int i = 0; i < array.size(); i++) {
			JSONObject address = (JSONObject) array.get(i);
			System.out.println("#############  List of address of : "+i);
			String street=(String) address.get("street");
			String city=(String) address.get("city");
			String state=(String) address.get("state");
			System.out.println("************street******** : "+street);
			System.out.println("************city******** : "+city);
			System.out.println("************state******** : "+state);
		}
	}

}
