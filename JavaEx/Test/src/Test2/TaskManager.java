package Test2;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    public static List<Task> taskList = new ArrayList<>();

    public TaskManager(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskManager() {
        this.taskList = new ArrayList<Task>();
    }
    public void addList(Task task){
        this.taskList.add(task);
    }
}
