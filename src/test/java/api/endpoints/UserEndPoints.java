package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.EmployeeData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response createEmployee(EmployeeData payload) {
		
	Response	response = given()
						.contentType(ContentType.JSON)
						.body(payload)
				.when()
						.post(Routes.postEmp_URL);
		return response;
	}
	
	public static Response getAllEmployees() {
		
		Response	response = given()
							
					.when()
							.get(Routes.getAllEmp_URL);
			return response;
	}
	
	public static Response getEmployee(int EmpId) {
		
		Response	response = given()
							.pathParam("id", EmpId)
					.when()
							.get(Routes.getEmp_URL);
			return response;
	}
	
	public static Response updateEmployee(int EmpId, EmployeeData payload) {
		
		Response	response = given()
							.contentType(ContentType.JSON)
							.pathParam("id", EmpId)
							.body(payload)
					.when()
							.put(Routes.updateEmp_URL);
			return response;
	}
	
	public static Response deleteEmployee(int EmpId) {
		
		Response	response = given()
							.pathParam("id", EmpId)
					.when()
							.delete(Routes.deleteEmp_URL);
			return response;
	}
	

}
