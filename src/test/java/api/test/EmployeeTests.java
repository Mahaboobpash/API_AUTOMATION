package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.EmployeeData;
import io.restassured.response.Response;
import junit.framework.Assert;

public class EmployeeTests {
	Faker faker;
	EmployeeData empPayload;
	
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		empPayload=new EmployeeData();
		System.out.println("************************* TEST STARTED *************************");
		empPayload.setName(faker.name().username());
		empPayload.setSalary(faker.number().digits(5));
		empPayload.setAge(faker.number().digits(2));	
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
	
	@Test(priority=2)
	public void createEmp() {
		Response response = UserEndPoints.createEmployee(empPayload);
		response.then().log().all();
		
		String msg = response.jsonPath().get("message").toString();
		 System.out.println("Message is : "+msg);
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status code : "+response.getStatusCode());
	}

	@Test(priority=3)
	public void getEmp() {
		Response response = UserEndPoints.getEmployee(faker.number().numberBetween(12, 20));
		response.then().log().all();
		
		String msg = response.jsonPath().get("message").toString();
		 System.out.println("Message is : "+msg);
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status code : "+response.getStatusCode());
	}
	
	@Test(priority=4)
	public void updateEmp() {
		Response response = UserEndPoints.updateEmployee(faker.number().numberBetween(12, 20), empPayload);
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
