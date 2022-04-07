package part4.ex1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Worker extends Thread{
    public static List<Task> lists = new ArrayList<>();
    private String workerName;
    private int task;

    public Worker(String workerName, int task){
        this.workerName = workerName;
        this.task = task;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    @Override
    public void run() {
        try{
            FileReader reader = new FileReader("Tasks.json");
            Type objectType = new TypeToken<List<Task>>(){}.getType();
            lists = new Gson().fromJson(reader, objectType);
            for (int i = 1; i <= lists.size(); i++){
                    if(i == task){
                        for (int j = 5; j >=0; j--){
                            synchronized(lists.get(i-1)){
                            System.out.println(lists.get(i-1)+workerName+" đang làm trong: "+j);
                            System.out.println("Công việc được hoàn thành");
                            Thread.sleep(1000);
                        }
                    }
                    Thread.sleep(5000);
                }

            }
        }catch(FileNotFoundException | InterruptedException e){
            e.printStackTrace();
        }
    }







}
