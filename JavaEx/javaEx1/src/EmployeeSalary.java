import java.util.Scanner;

public class EmployeeSalary {
    public static void main(String[] args) {
        double salary = 0.0, bonus = 0.0, taxAmount, netSalary;
        String designation;
        int yearsServed;

        Scanner input = new Scanner(System.in);
        System.out.println("1. Manager \n2. System Analyst \n3. Developer \n4. Accounttant");
        System.out.println("Enter the Employee's designation");
        designation = input.nextLine();
        switch (designation){
            case "Manager":
                salary = 21346.876;
                break;
            case "System Analyst":
                salary = 16729.564;
                break;
            case "Developer":
                salary = 14525.345;
                break;
            case "Accountant":
                salary=13215.123;
                break;
        }
        System.out.println("\t Employee Salary Details");
        System.out.println("-----------------------------------------");
        System.out.printf("Employee Designation: \t%s%n",designation);
        System.out.printf("Employee Salary: \t$%.2f%n",salary);
        System.out.println("------------------------------------------");

        System.out.println("Enter the number of years served in the company: ");
        yearsServed = input.nextInt();

        if(yearsServed >= 5){
            if (salary>20000){
                bonus = salary * 0.09;
            }else if(salary >14000 && salary <= 20000){
                bonus = salary * 0.05;
            }else {
                bonus = salary * 0.02;
            }
        }else if(yearsServed >=3){
            if(salary >20000){
                bonus = salary * 0.07;
            }else if(salary > 14000 && salary <=20000){
                bonus = salary *0.03;
            }else {
                bonus = salary * 0.01;
            }
        }else{
            bonus = salary *0.05;
        }
        System.out.printf("Employee's Annua Bonnos Amount:\t$%.2f%n",bonus);
    }
}
