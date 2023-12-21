package api.utilities;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	
	@DataProvider (name="data")
	public Object[][] EmpData(){
		return new Object[][] {
			{"Navee","90000","28"}
//			,{"Pravee","30000","33"}
		};
	} 

}
