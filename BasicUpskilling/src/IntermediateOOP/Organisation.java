package IntermediateOOP;

class Employee{
	static double income = 30000;
	
	public static void salaryCalculation() {
		
	}
}

class Manager extends Employee{
	static double incentive = 5000;
	public static void salaryCalculation() {
		income = income + incentive;
		System.out.println("Managers income " + income);
	}
}

class Labour extends Employee{
	static double overTime = 2000;
	public static void salaryCalculation() {
		income = income + overTime;
		System.out.println("Labours income " + income);
	}
}

public class Organisation {

	public static void main(String[] args) {
		Manager mg = new Manager();
		Labour lb = new Labour();
		mg.salaryCalculation();
		lb.salaryCalculation();
		
	}

}
