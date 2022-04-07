package part4.ex1;

import java.util.Scanner;

public class Home {

    public static void homeManager(){
        Worker worker1 = new Worker("Linh",1);
        Worker worker2 = new Worker("Công nhân số 2", 2);
        Worker worker3 = new Worker("Công nhân sô 3", 1);
        System.out.println("=========Chọn=========");
        System.out.println("1. Quản lí");
        System.out.println("2. Xem tiến trình công việc");
        System.out.println("3. Xem danh sách công việc");
        System.out.println("4. Thoat chương trình");
        System.out.println("=============================");

        TaskList taskList = new TaskList();
        TaskManager taskManager = new TaskManager();

        Scanner scanner = new Scanner(System.in);
        int ch = scanner.nextInt();

        switch (ch){
            case 1:
                taskManager.opeationsManager();
                break;
            case 2:
                worker1.start();
                worker2.start();
                worker3.start();
                break;
            case 3:
                taskList.showTaskList();
                homeManager();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        Home home = new Home();
        home.homeManager();
    }

}
