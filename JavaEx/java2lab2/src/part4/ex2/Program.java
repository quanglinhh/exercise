package part4.ex2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        System.out.println("RUN MY FAVORITE PROGRAMS\n");
        System.out.println("1. Notepad");
        System.out.println("2. Paint");
        System.out.println("3. Microsoft Word");
        System.out.println("4. Microsoft Excel");
        System.out.println("5. Calculator");
        System.out.println("6. Internet Explorer");
        System.out.println("7. Windows Explorer");
        System.out.println("8. Exit");

        Scanner sc = new Scanner(System.in);
        int ch;
        System.out.print("Run: ");
        ch = sc.nextInt();
        try{
            FileReader fileReader = new FileReader("Program.txt");
            BufferedReader br = new BufferedReader(fileReader);
//            String[] arr = new String[8];
//
//            for (int i = 0 ; i <8; i++){
//                arr[i] = br.readLine();
//            }
//            System.out.println(arr);
            String line = " ";

            while (true){
                if(line==null){
                    break;
                }
                line = br.readLine();
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
        }

    }
}
