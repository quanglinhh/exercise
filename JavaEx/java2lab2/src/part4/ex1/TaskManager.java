package part4.ex1;

import java.io.IOException;
import java.util.*;


public class TaskManager {

    public static void opeationsManager(){
        Scanner sc = new Scanner(System.in);
        TaskList taskList = new TaskList();
        Home home = new Home();
        while (true){
            System.out.println("====Giao diện Quản lí====");
            System.out.println("1. Thêm công việc");
            System.out.println("2. Xem danh sách công việc");
            System.out.println("3. Quay lại trang chủ");
            System.out.println("==========================");
            int managerInput = sc.nextInt();
            switch (managerInput){
                case 1:
                    System.out.println("Nhập mã công việc: ");
                    int taskId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên công việc: ");
                    String taskName = sc.nextLine();
                    Task task = new Task(taskId, taskName);
                    try{
                        taskList.addList(task);
                    }catch (IOException e){}
                    break;
                case 2:
                    taskList.showTaskList();
                    break;
                case 3:
                    home.homeManager();
                    break;
                default:
                    System.out.println("chon lai");
                    opeationsManager();
            }
        }

    }




}
