package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.EmployeeData;
import api.utilities.Dataprovider;
import io.restassured.response.Response;
import junit.framework.Assert;

public class EmployeeTests_DataProvider {
	Faker faker;
	EmployeeData empPayload;
	
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		empPayload=new EmployeeData();
		System.out.println("************************* TEST STARTED *************************");
//		empPayload.setName(faker.name().username());
//		empPayload.setSalary(faker.number().digits(5));
//		empPayload.setAge(faker.number().digits(2));	
	}
	
	@Test(priority=1)
	public void getAllEmp() {
		Response response = UserEndPoints.getAllEmployees();
		response.then().log().all();
		
		 String msg = response.jsonPath().get("message").toString();
		 System.out.println("Message is : "+msg);
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status code : "+response.getStatusCode());
	}
	
	@Test(priority=2,dataProvider = "data",dataProviderClass = Dataprovider.class,enabled=false)
	public void createEmp(String name,String salary, String age) throws InterruptedException {
		Thread.sleep(5000);
		empPayload.setName(name);
		empPayload.setSalary(salary);
		empPayload.setAge(age);
		Response response = UserEndPoints.createEmployee(empPayload);
		response.then().log().all();
		
		String msg = response.jsonPath().get("message").toString();
		 System.out.println("Message is : "+msg);
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status code : "+response.getStatusCode());
	}

	@Test(priority=3)
	public void getEmp() {
		int empID=faker.number().numberBetween(100, 200);
		System.out.println("Employee ID is (getEmp): "+empID);
		Response response = UserEndPoints.getEmployee(empID);
		response.then().log().all();
		
		String msg = response.jsonPath().get("message").toString();
		 System.out.println("Message is : "+msg);
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status code : "+response.getStatusCode());
	}
	
	@Test(priority=4,dataProvider = "data",dataProviderClass = Dataprovider.class)
	public void updateEmp(String name,String salary, String age) {
		empPayload.setName(name);
		empPayload.setSalary(salary);
		empPayload.setAge(age);
		int empID=faker.number().numberBetween(100, 200);
		System.out.println("Employee ID is: "+empID);
		Response response = UserEndPoints.updateEmployee(empID, empPayload);
		response.then().log().all();
		
		String msg = response.jsonPath().get("message").toString();
		 System.out.println("Message is : "+msg);
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status code : "+response.getStatusCode());
	}
	
	@Test(priority=5,enabled=false)
	public void deleteEmp() {
		Response response = UserEndPoints.deleteEmployee(faker.number().numberBetween(10, 20));
		response.then().log().all();
		
		String msg = response.jsonPath().get("message").toString();
		 System.out.println("Message is : "+msg);
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status code : "+response.getStatusCode());
	}
}
