package entities;

public class Employee {
	private Integer id;
	private String name;
	private Double salary;
	public Object list;
	
	public Employee(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public Double getSalary() {
		return salary;
	}
	
	public void increaseSalary(Double percentage) {
		salary = ((percentage/100)+1)*salary;
	}
	
	@Override
	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
	}
}
