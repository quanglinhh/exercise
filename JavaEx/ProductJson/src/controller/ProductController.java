package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Product;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProductController {
    public static List<Product> products = new ArrayList<>();
    public void getProductById(){
        ProductController.getDataWithGson();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search by Id: ");
        int id = scanner.nextInt();
        for(int i = 0; i < products.size(); i++){
            if(Objects.equals(id,products.get(i).getId())){
                System.out.println(products.get(i));
                break;
            }else if(i==(products.size()-1)){
                System.out.println("Product not found !!");
            }
        }
    }
    public void getProductByName(){
        ProductController.getDataWithGson();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search by Id: ");
        String name = scanner.nextLine();
        for(int i = 0; i < products.size(); i++){
            if(Objects.equals(name,products.get(i).getProName())){
                System.out.println(products.get(i));
                break;
            }else if(i==(products.size()-1)){
                System.out.println("Product not found !!");
            }
        }
    };
    public void getAllProduct(){
        ProductController.getDataWithGson();
        for(Product product: products){
            System.out.println(product);
        }
    }
    public static void getDataWithGson(){
        //Read file json
        Gson gson = new Gson();
        try{
            FileReader reader = new FileReader("product.json");
            Type objectType = new TypeToken<List<Product>>(){}.getType();
            products = new Gson().fromJson(reader,objectType);
        }catch(FileNotFoundException e){
            System.out.println("Khong tim thay file, kiem tra lai !!!");
        }
    }

}
