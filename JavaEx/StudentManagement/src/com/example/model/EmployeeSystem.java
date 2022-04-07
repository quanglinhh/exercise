package com.example.model;

import com.example.entity.Employee;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
class CustomException extends Exception{
    private static final long serialVersionUID = 1l;

    public CustomException(String str){
        super();
        System.out.println(str);
        EmployeeSystem.opeations();
    }
}


public class  EmployeeSystem{
    public static Map<Integer, Employee> map = new HashMap<>();

    public static void addEmployee(String name, int age, int id){
        try {
            Employee emp = new Employee(name, age, id);
            map.put(id, emp);
            opeations();
        }catch (InputMismatchException e){
            System.out.println("Sai cu phap");
        }

    }

    public static void deleteEmployee(int EmpId) throws CustomException{
        if(map.containsKey(EmpId)){
            map.remove(EmpId);
            System.out.println("Successfully Deleted from the List !!");
        }else{
            System.out.println("Not found Exception");
        }
        opeations();
    }

    public static void searchEmployee(int EmpId) throws CustomException{
        if (map.containsKey(EmpId)){
            //map.get(EmpId);
            System.out.println("Employee Details:- "+ map.get(EmpId));
        }else {
            System.out.println("Not Found Exception");
        }
        opeations();
    }

    public static void employeeList(){

        System.out.println(map.toString());
    }

    public static void opeations(){
        System.out.println("\n****** Employee management system ********");
        System.out.println("1. Add Employee");
        System.out.println("2. Delete Employee");
        System.out.println("3. Search Employee");
        System.out.println("4. Employee List");
        System.out.println("5. Exit");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1 -> {
                System.out.println("Enter Employee Details (Name, age. Id)");
                Scanner scanner1 = new Scanner(System.in);
                String name = scanner1.next();
                int age = scanner1.nextInt();
                int id = scanner1.nextInt();
                if (!name.equals("") && age != 0 && id != 0) {
                    addEmployee(name, age, id);
                }
            }
            case 2 -> {
                System.out.println("Enter Employee Id");
                Scanner scanner2 = new Scanner(System.in);
                int EmpId2 = scanner2.nextInt();
                try {
                    deleteEmployee(EmpId2);
                }catch (CustomException e){

                }
            }
            case 3 -> {
                System.out.println("Enter Employee Id");
                Scanner scanner3 = new Scanner(System.in);
                int EmpId3 = scanner3.nextInt();
                try {
                    searchEmployee(EmpId3);
                } catch (CustomException e) {
                    //e.printStackTrace();
                }
                opeations();
            }
            case 4 -> {
                employeeList();
                opeations();
            }
            case 5 -> System.exit(0);
            default -> {
                System.out.println("chon lai");
                opeations();
            }
        }
    }

    public static void main(String[] args) {
        opeations();
    }
}