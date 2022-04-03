package controller;

import model.Netflix;
import repository.NetflixRespository;

import java.util.List;

public class NetflixController {
    NetflixRespository netflixRespository = new NetflixRespository();
    public void searchMovieByName(List<Netflix> list, String name){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getTitle().contains(name)){
                System.out.println(list.get(i));
            }
        }
    }
    public void searchMovieByCategory(List<Netflix> list, String name){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCategory().contains(name)){
                System.out.println(list.get(i));
            }
        }
    }
    public void searchMovieByLanguage(List<Netflix> list, String name){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getLanguage().contains(name)){
                System.out.println(list.get(i));
            }
        }
    }
}
