package DefaultPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Import the new Date and Time classes
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeMain {
    /**
     * @param
     */
    public static void main(String[] args) {
        //TODO Auto-generated method stub
        try{
            //Create an instance of BufferedReader class to read form the console
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            //Create a HashMap instance to store employee id and date of birth
            Map<String, LocalDate> hm = new HashMap<String, LocalDate>();
            System.out.println("Enter the total number of employees");
            int size = Integer.parseInt(input.readLine());
            for(int i = 0 ; i<size; i++){
                System.out.println("Enter the employee id");
                String empID = input.readLine();
                System.out.println("Enter t he date of birth in this format dd/MM/yyy");
                String strBOD = input.readLine();
                //Use DateTimeFormatter to format the given input date into specific format
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dob = LocalDate.parse(strBOD,formatter);//Covert the formatted string bank into date
                hm.put(empID,dob);//Add the employee empId and dob into the Hashmap
            }
            retirementList(hm);//Invoke the method retirementList with the Hashmap List
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void retirementList(Map<String, LocalDate>hm)
    {
        LocalDate currentDate = LocalDate.now();//Retrieve the current date
        //Display the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Current Date is: "+currentDate.format(formatter));
        LocalDate dateOfBirth;//Create a variable of type LocalDate named dateOfBirth

        String empId;
        List<String> list = new ArrayList<String>();
        System.out.println("Retirement List");
        //For every employee in the list, perform this iteration
        for (Map.Entry<String, LocalDate>me: hm.entrySet())
        {
            empId = me.getKey();
            dateOfBirth = me.getValue();
            Period diff = Period.between(dateOfBirth,currentDate);//Period class id used to retrieve an amount of time with date-based value
            int diff1 = Period.between(dateOfBirth,currentDate).getYears();//Retrieve the years
            int dif4 = 66 -(int) diff1;
            int diff22 = Period.between(dateOfBirth,currentDate).getMonths();//Retrieve the months
            int dif6 = 12 -diff22;
            int age = diff.getYears();//Retrieve the age of employee
            if(age>66)//Check age if above
            {
                list.add(empId);//stored in list
                System.out.println("Empp Id: "+empId+" retired already");
            }
            else
            {
                System.out.println("Emp Id: "+empId+" has "+dif4+" year "+dif6 +"month for retirement");
            }

        }
    }
}
