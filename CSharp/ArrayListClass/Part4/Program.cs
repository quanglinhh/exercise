using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part4
{
    internal class Program
    {
       
        static void Main(string[] args)
        {
            RunProgram();
        }
        public static void RunProgram()
        {
            EmployeeManager manager = new EmployeeManager();
            
            try
            {
                while (true)
                {                
                    Menu();
                    int choice = int.Parse(Console.ReadLine());
                    Console.WriteLine("-----------------------------");
                    switch (choice)
                    {
                        case 1:
                            manager.AddEmployee();
                            Console.WriteLine("-----------------------------");
                            break;
                        case 2:
                            manager.Modify();
                            Console.WriteLine("-----------------------------");
                            break;
                        case 3:
                            manager.DisplayEmployee();
                            Console.WriteLine("-----------------------------");
                            break;
                        case 4:
                            Console.ForegroundColor = ConsoleColor.Yellow;
                            Console.WriteLine("Goodbye!");
                            Console.ResetColor();
                            Console.ReadLine();
                            break;
                        default:
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("wrong syntax, please choice again!");
                            Console.ResetColor();
                            break;

                    }
                }
            }
            catch (FormatException ex)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("Sai cu phap, nhap lai!");
                Console.ResetColor();
            }
            finally
            {
                RunProgram();
            }
        }
        public static void Menu()
        {
            Console.WriteLine("==========MENU==========");
            Console.WriteLine("1. Add Employee");
            Console.WriteLine("2. Modify Employee");
            Console.WriteLine("3. Display all Employees");
            Console.WriteLine("4. Exit");
            Console.Write("Your choice: ");
        }
    }
}
