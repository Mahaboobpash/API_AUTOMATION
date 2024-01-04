package Lombok;

public class Lombok_Test {

	public static void main(String[] args) {
		Lombok_Utils	data=new Lombok_Utils("John",25,"Delhi",true);
		System.out.println("********** fetch age ************** : "+data.getAge());
		System.out.println("********** fetch city ************** : "+data.getCity());
		System.out.println("********** fetch name ************** : "+data.getName());
	}

}
