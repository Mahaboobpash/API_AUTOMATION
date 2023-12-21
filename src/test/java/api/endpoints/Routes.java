package api.endpoints;

import java.io.FileInputStream;
import java.util.Properties;

public class Routes {
	
	public static Properties propertyFileRead() {
		Properties prop = null ;
		try {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/api/utilities/TestData.properties");
		prop=new Properties();
		prop.load(fis);
		} catch (Exception e) {
			System.out.println("Failed to read Property file");
		}
		return prop;
	}
	

//	public static String base_URL="https://dummy.restapiexample.com/api/v1";
	public static String base_URL=propertyFileRead().getProperty("base_URL");
	
	//user model
	public static  final String getAllEmp_URL= base_URL+"/employees";
	public static final String getEmp_URL=    base_URL+"/employee/{id}";
	public static final String postEmp_URL=   base_URL+"/create";
	public static final String updateEmp_URL=   base_URL+"/update/{id}";
	public static final String deleteEmp_URL=   base_URL+"/delete/{id}";
}
