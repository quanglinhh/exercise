package Personnel.controller;

import Personnel.entity.Engineer;
import Personnel.entity.Staff;
import Personnel.entity.Worker;
import Personnel.repository.Respository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    Engineer[] engineerss = {};
    List<Worker> workers = new ArrayList<>();
    List<Engineer> engineers = new ArrayList<>();
    List<Staff> staffs = new ArrayList<>();

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
                workers.add(worker);
                System.out.println(worker);
                System.out.println(workers);
                Respository respository = new Respository();

                break;
            case 2:
                System.out.print("Enter the industry: ");
                String industry = scanner.nextLine();
                Engineer engineer = new Engineer(name, age, gender, address, industry);
                engineers.add(engineer);
                System.out.println(engineers);
                break;
            case 3:
                System.out.print("Enter the job: ");
                String job = scanner.nextLine();
                Staff staff = new Staff(name, age, gender, address, job);
                staffs.add(staff);
                System.out.println(staffs);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.addPersonnel(1);

    }


}
