package Test2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập mã công việc: ");
        int taskId = Integer.valueOf(sc.nextLine());
        System.out.println("Nhập tên công việc: ");
        String taskName = String.valueOf(sc.nextInt());
        Task task = new Task(taskId, taskName);
        taskManager.addList(task);
    }
}
