package Test2;

public class Task {
    private int taskId;
    private String taskName;
    private String worker;

    public Task(int taskId,String taskName, String worker) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.worker = worker;
    }
    public Task(int taskId, String taskName) {
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

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return taskId + " ---------- "+ taskName + " --------------- "+worker;
    }
}
