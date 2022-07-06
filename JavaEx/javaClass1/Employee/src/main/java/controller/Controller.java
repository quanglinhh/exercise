package controller;

import entity.EmployeeRoot;
import entity.Engineer;
import entity.Staff;
import entity.Worker;
import repository.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Controller {
    List<Engineer> engineerList = new ArrayList<>();
    List<Worker> workerList = new ArrayList<>();
    List<Staff> staffList = new ArrayList<>();
    Repository repository = new Repository();
    EmployeeRoot employeeRoot = new EmployeeRoot();
    public void addEmployee(int choice) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter the address: ");
        String address = scanner.nextLine();
        switch (choice){
            case 1:
                System.out.print("Enter the lever of Worker: ");
                int lever = scanner.nextInt();
                if(lever < 1 || lever >10){
                    System.out.println("lever of Worker from 1 to 10!");
                    addEmployee(choice);
                }else{
                    Worker worker = new Worker(name,age,gender,address,lever);
                    workerList.add(worker);
                    Worker[] workers=  new Worker[workerList.size()];;
                    workerList.toArray(workers);
                    employeeRoot.setWorkers(workers);
                    repository.saveToFile(employeeRoot);
                }
                break;
            case 2:
                System.out.print("Enter the department: ");
                String department = scanner.nextLine();
                Engineer engineer = new Engineer(name,age,gender,address,department);
                engineerList.add(engineer);
                Engineer[] engineers = new Engineer[engineerList.size()];
                engineerList.toArray(engineers);
                employeeRoot.setEngineers(engineers);
                repository.saveToFile(employeeRoot);
                break;
            case 3:
                System.out.print("Enter the job of staff: ");
                String job = scanner.nextLine();
                Staff staff = new Staff(name,age,gender,address,job);
                staffList.add(staff);
                Staff[] staffs = new Staff[staffList.size()];
                staffList.toArray(staffs);
                employeeRoot.setStaff(staffs);
                repository.saveToFile(employeeRoot);
                break;
        }

    }
    public void displayAllEmployee() throws IOException {
        repository.loadFromFileJson();
        System.out.println(employeeRoot);
    }
    public void searchEmployeeByName() throws  IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        int count = 0;
        for(int i = 0 ; i < workerList.size(); i++){
            if(Objects.equals(workerList.get(i).getFullname(), name)){
                System.out.println(workerList.get(i));
                count = 0;
            } else if (i == workerList.size()-1) {
                count++;
            }
        }
        for(int i = 0 ; i < engineerList.size(); i++){
            if(Objects.equals(engineerList.get(i).getFullname(), name)){
                System.out.println(engineerList.get(i));
                count = 0;
            } else if (i == engineerList.size()-1) {
                count++;
            }
        }
        for(int i = 0 ; i < staffList.size(); i++){
            if(Objects.equals(staffList.get(i).getFullname(), name)){
                System.out.println(staffList.get(i));
                count = 0;
            } else if (i == staffList.size()-1) {
                count++;
            }
        }
        if(count==3){
            System.out.println("Employee not found!!!!");
            searchEmployeeByName();
        }

    }
    public void displayEngineer() throws IOException {
        repository.loadFromFileJson();
        Engineer[] engineers = employeeRoot.getEngineers();
         for(Engineer engineer: engineers){
             System.out.println(engineer);
         }

    }
    public void displayWorker() throws IOException {
        repository.loadFromFileJson();

        Worker[] workers = employeeRoot.getWorkers();
        for(Worker worker: workers){
            System.out.println(worker);
        }
    }
    public void displayStaff() throws IOException {
        repository.loadFromFileJson();
        Staff[] staffs = employeeRoot.getStaff();
        for(Staff staff : staffs){
            System.out.println(staff);
        }
    }
}
