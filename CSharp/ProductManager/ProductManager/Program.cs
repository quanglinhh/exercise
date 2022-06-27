using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProductManager
{
    internal class Program
    {
        static void Main(string[] args)
        {
            RunProgram();
        }
        public static void RunProgram()
        {


            Controller controller = new Controller();
            try {
                int choice = 0;
                while (choice != 4)
                {
                    Menu();
                    choice = int.Parse(Console.ReadLine());
                    switch (choice)
                    {
                        case 1:
                            controller.AddProduct();
                            Console.WriteLine("--------------------------------");

                            break;
                        case 2:
                            controller.DisplayProduct();
                            Console.WriteLine("--------------------------------");
                            break;
                        case 3:
                            controller.DeleteProductById();
                            Console.WriteLine("--------------------------------");
                            break;
                        case 4:
                            break;
                        default:
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("wrong syntax, please choice again!");
                            Console.ResetColor();
                            break;
                    }
                    if (choice == 4)
                    {
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("Exit!");
                        Console.ReadLine();
                        Environment.Exit(0);
                    }
                }
            } 
            catch (FormatException ex) {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("wrong syntax, please choice again!");
                Console.ResetColor();
            }
            finally
            {
                RunProgram();
            }

            Console.ReadLine();
        }
        public static void Menu()
        {
            Console.WriteLine("1. Add product record");
            Console.WriteLine("2. Display product record");
            Console.WriteLine("3. Delete product by Id");
            Console.WriteLine("4 Exit");
            Console.Write("Your choice: ");
        }
    }
}
