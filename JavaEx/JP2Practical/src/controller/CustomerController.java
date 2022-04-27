package controller;

import entity.Customers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerController {
    public List<Customers> customers = new ArrayList<Customers>();

    public void addCustomer(String name, String email, String phone){
        Customers customer = new Customers();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customers.add(customer);
    };
    public void findCustomerByName(String name){
        for(int i = 0; i < customers.size();i++){
            if(Objects.equals(name, customers.get(i).getName())){
                System.out.println(customers.get(i));
            }else if(i == (customers.size()-1)){
                System.out.println("Không tìm thấy Customer");
            }
        }
    };
    public void displayAll(){
        for(Customers customer: customers){
            System.out.println(customer);
        }
    };
}
