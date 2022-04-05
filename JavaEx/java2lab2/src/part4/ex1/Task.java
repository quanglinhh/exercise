package part4.ex1;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private AtomicInteger taskId;
    private String taskName;
    private String worker;

    public Task(String taskName, String worker) {
        this.taskName = taskName;
        this.worker = worker;
    }
    public Task() {
    }

    public Task(int taskId, String taskName) {
        this.taskName = taskName;
    }

    //
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return taskId + " ---------- "+ taskName + " --------------- "+worker;
    }
}
