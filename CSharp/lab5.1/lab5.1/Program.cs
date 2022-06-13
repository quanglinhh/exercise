using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;
using System.Threading;

namespace lab5._1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            RunProgram();
        }
        public static void RunProgram()
        {
            try
            {
                int choice = 0;
                Controller controller = new Controller();
                while (choice != 7)
                {
                    Menu();
                    choice = Convert.ToInt32(Console.ReadLine());
                    switch (choice)
                    {
                        case 1:
                            controller.AddProduct();
                            Console.WriteLine("-------------------------------");
                            break;
                        case 2:
                            controller.EditProduct();
                            Console.WriteLine("-------------------------------");
                            break;
                        case 3:
                            controller.DeleteProduct();
                            Console.WriteLine("-------------------------------");
                            break;
                        case 4:
                            controller.ViewAllProducts();
                            Console.WriteLine("-------------------------------");
                            break;
                        case 5:
                            controller.SearchProductById();
                            Console.WriteLine("-------------------------------");
                            break;
                        case 6:
                            controller.SearchProductByName();
                            Console.WriteLine("-------------------------------");
                            break;
                        case 7:
                            break;
                        default:
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("wrong syntax, please choice again!");
                            Console.ResetColor();
                            break;
                    }
                }
                if (choice == 7)
                {
                    Console.ForegroundColor = ConsoleColor.Yellow;
                    Console.WriteLine("Exit!");
                    Console.ReadLine();                  
                    Environment.Exit(0);
                }
            }
            catch (FormatException ex)
            {
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
            Console.WriteLine("========== Actions=========");
            Console.WriteLine("1. Add Product");
            Console.WriteLine("2. Edit product");
            Console.WriteLine("3. Delete product");
            Console.WriteLine("4. View all products");
            Console.WriteLine("5. Search product by Id");
            Console.WriteLine("6. Search product by name");
            Console.WriteLine("7. End ");
            Console.Write("Your choice: ");
        }
    }
}
