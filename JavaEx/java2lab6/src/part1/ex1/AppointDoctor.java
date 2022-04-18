package part1.ex1;

import java.util.PriorityQueue;

public class AppointDoctor {

    /**Create a new instance if AppointDoctor */
    public AppointDoctor(){}

    public static void main(String[] args) {
        //TODO code application logic here

        //Creating a PriorityQueue
        PriorityQueue pq = new PriorityQueue<>();

        //Creating Doctor objects
        Doctor Cardiologist = new Doctor("Casuality",1);
        Doctor Gynecologist = new Doctor("Surgery",2);
        Doctor Paediatric = new Doctor("Routine Chek-up",3);

        //Adding Doctor objects to the Queue
        pq.offer(Cardiologist);
        pq.offer(Gynecologist);
        pq.offer(Paediatric);

        //Remove The elements from the Queue as per their priorities
        while (!pq.isEmpty()){
            //Displaying the header information
            System.out.println("\nAppointing doctors based of their priorities:");
            System.out.println("***********************************************");

            //Removing the Doctors as per their priorities
            Doctor doctor = ((Doctor) pq.remove());

            //Invokinf the toString() method
            System.out.println(doctor.toString());
        }
    }
}
