package Personnel.controller;

import Personnel.entity.Engineer;
import Personnel.entity.PersonnelRoot;
import Personnel.entity.Staff;
import Personnel.entity.Worker;
import Personnel.repository.Respository;


import java.io.IOException;
import java.util.*;

public class Controller {
    PersonnelRoot personnelRoot = new PersonnelRoot();
    Respository respository = new Respository();
    List<Worker> workerList = new ArrayList<>();
    List<Engineer> engineerList = new ArrayList<>();
    List<Staff> staffList = new ArrayList<>();
    public void addPersonnel(int ch) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        switch (ch) {
            case 1:
                System.out.print("Enter the lever of Worker: ");
                int lever = scanner.nextInt();
                Worker worker = new Worker(name, age, gender, address,lever);
                workerList.add(worker);
                Worker[] workers=  new Worker[workerList.size()];;
                workerList.toArray(workers);
                personnelRoot.setWorker(workers);
                respository.saveToFile(personnelRoot);
                break;
            case 2:
                System.out.print("Enter the industry: ");
                String industry = scanner.nextLine();
                Engineer engineer = new Engineer(name, age, gender, address, industry);
                engineerList.add(engineer);
                Engineer[] engineers = new Engineer[engineerList.size()];
                engineerList.toArray(engineers);
                personnelRoot.setEngineer(engineers);
                respository.saveToFile(personnelRoot);
                break;
            case 3:
                System.out.print("Enter the job: ");
                String job = scanner.nextLine();
                Staff staff = new Staff(name, age, gender, address, job);
                staffList.add(staff);
                Staff[] staffs = new Staff[staffList.size()];
                staffList.toArray(staffs);
                personnelRoot.setStaff(staffs);
                respository.saveToFile(personnelRoot);
                break;
        }
    }
    public void displayAllPersonnel() throws IOException {
        respository.loadFromFileJson();
        System.out.println(personnelRoot);
    }
    public void displayPersonnelByRoll(int ch) throws IOException {
        switch (ch){
            case 3:
                Worker[] workers = respository.loadFromFileJson().getWorker();
                for(Worker worker : workers){
                    System.out.println(worker);
                }
                break;
            case 4:
                Engineer[] engineers = respository.loadFromFileJson().getEngineer();
                for(Engineer engineer : engineers){
                    System.out.println(engineer);
                }
                break;
            case 5:
                Staff[] staffs = respository.loadFromFileJson().getStaff();
                for(Staff staff : staffs){
                    System.out.println(staff);
                }
        }
    }
    public void searchPersonnel() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String nameP = scanner.nextLine();
        Worker[] workers = respository.loadFromFileJson().getWorker();
        Engineer[] engineers = respository.loadFromFileJson().getEngineer();
        Staff[] staffs = respository.loadFromFileJson().getStaff();
        try{int count = 0;
            for(int i = 0; i < workers.length; i++){

                if(Objects.equals(workers[i].getName(), nameP)){
                    System.out.println(workers[i]);
                }else if(i == (workers.length-1)){
                    count+=1;
                }
            }
            for(int i = 0; i < engineers.length; i++){
                if(Objects.equals(engineers[i].getName(), nameP)){
                    System.out.println(engineers[i]);
                }else if(i == (engineers.length-1)){
                    count+=1;
                }
            }
            for(int i = 0; i < staffs.length; i++){
                if(Objects.equals(staffs[i].getName(), nameP)){
                    System.out.println(staffs[i]);
                }else if(i == (staffs.length-1)){
                    count+=1;
                }
            }
            if(count>0){
                System.out.println("Không tìm thấy tên người cần tìm");
            }}catch (Exception e){}
    }
    public void deletePersonnel() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String nameP = scanner.nextLine();
        Worker[] workers = respository.loadFromFileJson().getWorker();


        Engineer[] engineers = respository.loadFromFileJson().getEngineer();
        Staff[] staffs = respository.loadFromFileJson().getStaff();
        try{int count = 0;
            for(int i = 0; i < workerList.size(); i++){
                if(Objects.equals(workerList.get(i).getName(), nameP)){
                    Worker worker = workerList.get(i);
                    workerList.remove(worker);

                }else if(i == (workers.length-1)){
                    count+=1;
                }

            }
            workerList.toArray(workers);
            personnelRoot.setWorker(workers);
            respository.saveToFile(personnelRoot);
            for(int i = 0; i < engineers.length; i++){
                if(Objects.equals(engineers[i].getName(), nameP)){
                    System.out.println(engineers[i]);
                }else if(i == (engineers.length-1)){
                    count+=1;
                }
            }
            for(int i = 0; i < staffs.length; i++){
                if(Objects.equals(staffs[i].getName(), nameP)){
                    System.out.println(staffs[i]);
                }else if(i == (staffs.length-1)){
                    count+=1;
                }
            }
            if(count>0){
                System.out.println("Không tìm thấy tên người cần tìm");
            }

        }catch (Exception e){}
    }
}
