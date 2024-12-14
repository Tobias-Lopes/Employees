package aplicattion;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		sc.nextLine();
		List<Employee> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("Employee #" + (i+1));
			System.out.print("ID: ");
			Integer id = sc.nextInt();
			
			while(hasId(list, id)) {
				System.out.println("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			System.out.println();
			
			list.add(new Employee(id, name, salary));
			
		}
		
		System.out.print("Enter the employee id that will have salary increase : ");
		int idemployee = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == idemployee).findFirst().orElse(null);
		System.out.println();
		
		if(emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			Double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		System.out.println();
		System.out.println("List of employees: ");
		
		for (Employee e: list) {
			System.out.println(e);
		}
		
		
		
		sc.close();
	}
	
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
