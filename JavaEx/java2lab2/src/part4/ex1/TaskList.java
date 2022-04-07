package part4.ex1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jdk.internal.org.jline.reader.ScriptEngine;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    public static List<Task> taskList = new ArrayList<>();

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }
    public void addList(Task task) throws IOException {
        try{
            this.taskList.add(task);
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("Tasks.json");
            String information = gson.toJson(taskList);
            writer.write(information);
            writer.close();
        }catch (IOException e){}
    }


    public void showTaskList(){
        try {
            FileReader reader = new FileReader("Tasks.json");
            Type objectType = new TypeToken<List<Task>>(){}.getType();
            taskList= new Gson().fromJson(reader, objectType);
            for (Task task:taskList){
                System.out.println(task);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }





}
