package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Netflix;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NetflixRespository {
    public List<Netflix> netflixList = new ArrayList<>();

    public void getData(){
        try{
            FileReader reader = new FileReader("netflix.json");
            Type objectType = new TypeToken<List<Netflix>>(){}.getType();
            netflixList = new Gson().fromJson(reader, objectType);

            for (Netflix netflix : netflixList){
                System.out.println(netflix);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        NetflixRespository netflixRespository = new NetflixRespository();
//        netflixRespository.getData();
//    }
}

