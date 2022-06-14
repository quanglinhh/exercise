using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part4
{
    internal class EmployeeManager
    {
        
        ArrayList employees = new ArrayList();
        public void AddEmployee()
        {
            Console.Write("Enter the name: ");
            string name = Console.ReadLine();
            Console.Write("Enter the age: ");
            int age = int.Parse(Console.ReadLine());
            Console.Write("Enter the salary: ");
            double salary = Convert.ToDouble(Console.ReadLine());
            Employee employee = new Employee(name, age, salary);
            employees.Add(employee);
            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine($"Add {name} succesfull!");
            Console.ResetColor();
        }
        public bool CheckContain(string data)
        {
            
            foreach (Employee emp in employees)
            {
                if (emp.Name == data)
                {
                    return true;
                }
            }
            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine("Employee is not contain!");
            Console.ResetColor();
            return false;
        }
        public void Modify()
        {
            
            Console.Write("Enter the name of employee: ");
            string name = Console.ReadLine();
            if (CheckContain(name))
            {
                try
                {
                    
                    while (true)
                    {
                        MenuModify();
                        int choice = int.Parse(Console.ReadLine());
                        Console.WriteLine("-----------------------------");
                        switch (choice)
                        {
                            case 1:
                                Console.Write("enter the new name: ");
                                string newName = Console.ReadLine();
                                foreach (Employee emp in employees)
                                {
                                    if (emp.Name == name)
                                    {
                                        emp.Name = newName;
                                    }
                                }
                                Console.ForegroundColor = ConsoleColor.Green;
                                Console.WriteLine("Modify {0} to {1}", name, newName);
                                Console.ResetColor();
                                Console.WriteLine("-----------------------------");
                                break;
                            case 2:
                                Console.Write("enter the new age: ");
                                int newAge = int.Parse(Console.ReadLine());
                                foreach (Employee emp in employees)
                                {
                                    if (emp.Name == name)
                                    {
                                        emp.Age = newAge;
                                    }
                                }
                                Console.ForegroundColor = ConsoleColor.Green;
                                Console.WriteLine("Modify age of {0} to {1}", name, newAge);
                                Console.ResetColor();
                                Console.WriteLine("-----------------------------");
                                break;
                            case 3:
                                Console.Write("enter the new salary: ");
                                double newSalary = double.Parse(Console.ReadLine());
                                foreach (Employee emp in employees)
                                {
                                    if (emp.Name == name)
                                    {
                                        emp.Salary = newSalary;
                                    }
                                }
                                Console.ForegroundColor = ConsoleColor.Green;
                                Console.WriteLine("Modify salary of {0} to {1}", name, newSalary);
                                Console.ResetColor();
                                Console.WriteLine("-----------------------------");
                                break;
                            case 4:
                                Console.ForegroundColor = ConsoleColor.Green;
                                Console.WriteLine("Modify {0} finished !",name);
                                Console.ResetColor();                              
                                Program.RunProgram();
                                break;
                            default:
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.WriteLine("wrong syntax, please choice again!");
                                Console.ResetColor();
                                break;
                        }
                    }
                }
                catch (FormatException )
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine("Sai cu phap, nhap lai!");
                    Console.ResetColor();
                }
                finally
                {
                    Modify();
                }
            }
            else
            {
                Modify();
            }
        }
        public void DisplayEmployee()
        {
            Console.ForegroundColor = ConsoleColor.Green;
            foreach(Employee emp in employees)
            {
                Console.WriteLine(emp);
            }
            Console.ResetColor();
        }
        public static void MenuModify()
        {
            Console.WriteLine("You want modify:  ");
            Console.WriteLine("1. name");
            Console.WriteLine("2. age");
            Console.WriteLine("3. salary");
            Console.WriteLine("4. finist modify");
            Console.Write("Your choice: ");
        }
        


    }
}
