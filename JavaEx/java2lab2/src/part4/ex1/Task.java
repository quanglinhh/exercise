package part4.ex1;

public class Task {
    private int taskId;
    private String taskName;

    public Task(int taskId,String taskName/*, String worker*/) {
        this.taskId = taskId;
        this.taskName = taskName;

    }


    //
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return taskId + " ---------- "+ taskName + " --------------- ";
    }


}
