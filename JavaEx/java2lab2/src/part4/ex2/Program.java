package part4.ex2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
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
        File f = new File("D:\\exercise\\JavaEx\\java2lab2\\Programs.txt");
        try{
            List<String> allText = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
            for(int i = 0 ; i > allText.size(); i++){
                System.out.println(allText.get(i));
            }

            for (int i = 1; i <=8;i++){
                if(ch == i){
                    String line = String.valueOf(allText.get(i-1));
                    System.out.println(line);
                }
            }

        }catch (FileNotFoundException e){}

    }
}
